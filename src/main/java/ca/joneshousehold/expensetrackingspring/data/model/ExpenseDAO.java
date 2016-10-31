package ca.joneshousehold.expensetrackingspring.data.model;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

/**
 * Expense Data Access Object.
 */
@Entity
@Table(name = "Expenses")
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
public class ExpenseDAO extends TimeStampedEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "categoryId")
    private CategoryDAO category;
    private LocalDateTime date;
    private double amount;
    private String place;
    private String note;

    public DateTime getDate() {
        return this.date.toDateTime(DateTimeZone.UTC);
    }

    public void setDate(DateTime date) {
        this.date = date.toLocalDateTime();
    }
}
