package ca.joneshousehold.expensetrackingspring.web.model;

import lombok.AccessLevel;

/**
 * CategoryDTO DTO.
 */
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryDTO {
    private String id;
    private String category;
    private String subCategory;
}
