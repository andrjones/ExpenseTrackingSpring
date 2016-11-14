package ca.joneshousehold.expensetrackingspring.web.controllers;

import ca.joneshousehold.expensetrackingspring.web.model.CategoryDTO;
import ca.joneshousehold.expensetrackingspring.web.services.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for the categories controller.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryService categoryService;

    @Captor
    private ArgumentCaptor<CategoryDTO> categoryDtoCaptor;

    @Test
    public void getCategories() throws Exception {
        // Exercise
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/categories"))
                .andExpect(status().isOk());

        // Verify
        verify(categoryService, times(1)).getCategories();
    }

    @Test
    public void getCategory() throws Exception {
        // Exercise
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/categories/abc123"))
                .andExpect(status().isOk());

        // Verify
        verify(categoryService, times(1)).getCategory(eq("abc123"));
    }

    @Test
    public void createCategory() throws Exception {
        // Setup
        String category =
                "{" +
                    "\"id\":null," +
                    "\"category\":\"test\"," +
                    "\"subCategory\":\"testing\"" +
                "}";

        // Exercise
        mvc.perform(MockMvcRequestBuilders.post("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(category))
                .andExpect(status().isOk());

        // Verify
        verify(categoryService).createCategory(categoryDtoCaptor.capture());
    }

    @Test
    public void updateCategory() throws Exception {
        // Setup
        String category =
                "{" +
                        "\"id\":\"abc123\"," +
                        "\"category\":\"test\"," +
                        "\"subCategory\":\"testing\"" +
                        "}";

        // Exercise
        mvc.perform(MockMvcRequestBuilders.put("/api/v1/categories/abc123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(category))
                .andExpect(status().isOk());

        // Verify
        verify(categoryService).updateCategory(eq("abc123"), categoryDtoCaptor.capture());
    }

    @Test
    public void deleteCategory() throws Exception {
        // Exercise
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/categories/abc123"))
                .andExpect(status().isOk());

        // Verify
        verify(categoryService, times(1)).archiveCategory(eq("abc123"));
    }
}
