package ca.joneshousehold.expensetrackingspring.web.model;

import lombok.AccessLevel;
import org.joda.time.DateTime;

/**
 * ExpenseDTO DTO.
 */
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExpenseDTO {
    private String id;
    private CategoryDTO category;
    private DateTime date;
    private double amount;
    private String place;
    private String note;
}
