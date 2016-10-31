package ca.joneshousehold.expensetrackingspring.data.model;

import ca.joneshousehold.expensetrackingspring.data.services.TimeKeeper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

/**
 * A JPA Entity super class to manage createdOn and updatedOn timestamps.
 */
@MappedSuperclass
public class TimeStampedEntity {
    @Transient
    private TimeKeeper timeKeeper = TimeKeeper.getInstance();

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    public void created() {
        setCreatedOn(timeKeeper.now());
        setUpdatedOn(timeKeeper.now());
    }

    @PreUpdate
    public void updated() {
        setUpdatedOn(timeKeeper.now());
    }

    private DateTime getCreatedOn() {
        return this.createdOn.toDateTime(DateTimeZone.UTC);
    }

    private void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn.toLocalDateTime();
    }

    private DateTime getUpdatedOn() {
        return this.updatedOn.toDateTime(DateTimeZone.UTC);
    }

    private void setUpdatedOn(DateTime updatedOn) {
        this.updatedOn = updatedOn.toLocalDateTime();
    }
}
