package ca.joneshousehold.expensetrackingspring.web.controllers;

import ca.joneshousehold.expensetrackingspring.web.model.CategoryDTO;
import ca.joneshousehold.expensetrackingspring.web.model.ExpenseDTO;
import ca.joneshousehold.expensetrackingspring.web.services.ExpenseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
 * Unit tests from the expenses controller.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ExpenseController.class)
public class ExpenseControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ExpenseService expenseService;

    @Captor
    private ArgumentCaptor<ExpenseDTO> expenseDtoCaptor;

    @Test
    public void getExpenses() throws Exception {
        // Exercise
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/expenses"))
                .andExpect(status().isOk());

        // Verify
        verify(expenseService, times(1)).getExpenses();
    }

    @Test
    public void getExpense() throws Exception {
        // Exercise
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/expenses/abc123"))
                .andExpect(status().isOk());

        // Verify
        verify(expenseService, times(1)).getExpense(eq("abc123"));
    }

    @Test
    public void createExpense() throws Exception {
        // Setup
        String expense =
                "{" +
                    "\"id\":null," +
                    "\"category\":{" +
                        "\"id\":\"xyz987\"," +
                        "\"category\":\"test\"," +
                        "\"subCategory\":\"testing\"" +
                    "}," +
                    "\"date\":10000," +
                    "\"amount\":123.45," +
                    "\"place\":\"the place\"," +
                    "\"note\":\"\"" +
                "}";

        // Exercise
        mvc.perform(MockMvcRequestBuilders.post("/api/v1/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(expense))
                .andExpect(status().isOk());

        // Verify
        verify(expenseService, times(1)).createExpense(expenseDtoCaptor.capture());
    }

    @Test
    public void updateExpense() throws Exception {
        // Setup
        String expense =
                "{" +
                    "\"id\":\"abc123\"," +
                    "\"category\":{" +
                        "\"id\":\"xyz987\"," +
                        "\"category\":\"test\"," +
                        "\"subCategory\":\"testing\"" +
                    "}," +
                    "\"date\":10000," +
                    "\"amount\":123.45," +
                    "\"place\":\"the place\"," +
                    "\"note\":\"\"" +
                "}";

        // Exercise
        mvc.perform(MockMvcRequestBuilders.put("/api/v1/expenses/abc123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(expense))
                .andExpect(status().isOk());

        // Verify
        verify(expenseService, times(1)).updateExpense(eq("abc123"), expenseDtoCaptor.capture());
    }

    @Test
    public void deleteExpense() throws Exception {
        // Exercise
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/expenses/abc123"))
                .andExpect(status().isOk());

        // Verify
        verify(expenseService, times(1)).deleteExpense(eq("abc123"));
    }
}
