package ca.joneshousehold.expensetrackingspring.web.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown by controller method if a requested Expense is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(String id) {
        super(String.format("Expense %s not found", id));
    }
}
