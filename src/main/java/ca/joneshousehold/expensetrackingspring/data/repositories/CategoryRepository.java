package ca.joneshousehold.expensetrackingspring.data.repositories;

import ca.joneshousehold.expensetrackingspring.data.model.CategoryDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Category Repository.
 */
public interface CategoryRepository extends JpaRepository<CategoryDAO, String> {
}
