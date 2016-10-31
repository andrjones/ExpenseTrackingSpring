package ca.joneshousehold.expensetrackingspring.data.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category Data Access Object.
 */
@Entity
@Table(name = "Categories")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class CategoryDAO  extends TimeStampedEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String category;
    private String subcategory;
    private boolean active;

    public CategoryDAO(String category, String subcategory) {
        this.category = category;
        this.subcategory = subcategory;
        this.active = true;
    }

}
