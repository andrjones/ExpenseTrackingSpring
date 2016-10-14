package ca.joneshousehold.expensetrackingspring.web.controllers;

import ca.joneshousehold.expensetrackingspring.web.model.Expense;
import ca.joneshousehold.expensetrackingspring.web.services.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API endpoints for resource: Expenses.
 */
@RestController
@RequestMapping("api/v1/")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @RequestMapping(value = "expenses", method = RequestMethod.GET)
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }

    @RequestMapping(value = "expenses", method = RequestMethod.POST)
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @RequestMapping(value = "expenses/{id}", method = RequestMethod.GET)
    public Expense getExpense(@PathVariable String id) {
        return expenseService.getExpense(id);
    }

    @RequestMapping(value = "expenses/{id}", method = RequestMethod.PUT)
    public Expense updateExpense(@PathVariable String id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @RequestMapping(value = "expenses/{id}", method = RequestMethod.DELETE)
    public Expense deleteExpense(@PathVariable String id) {
        return expenseService.deleteExpense(id);
    }

}
