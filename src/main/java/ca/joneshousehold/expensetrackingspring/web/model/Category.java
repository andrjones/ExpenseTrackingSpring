package ca.joneshousehold.expensetrackingspring.web.model;

import lombok.AccessLevel;

/**
 * Category DTO.
 */
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    private String id;
    private String category;
    private String subCategory;
}
