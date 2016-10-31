package ca.joneshousehold.expensetrackingspring.data.repositories;

import ca.joneshousehold.expensetrackingspring.data.model.ExpenseDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ExpenseRepository.
 */
public interface ExpenseRepository extends JpaRepository<ExpenseDAO, String> {
}
