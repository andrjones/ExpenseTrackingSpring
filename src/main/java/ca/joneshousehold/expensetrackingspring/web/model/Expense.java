package ca.joneshousehold.expensetrackingspring.web.model;

import lombok.AccessLevel;
import org.joda.time.DateTime;

/**
 * Expense DTO.
 */
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Expense {
    private String id;
    private Category category;
    private DateTime date;
    private double amount;
    private String place;
    private String note;
}
