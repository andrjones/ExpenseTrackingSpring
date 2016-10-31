package ca.joneshousehold.expensetrackingspring.web.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown by controller method if a requested Category is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String id) {
        super(String.format("Category %s not found", id));
    }
}
