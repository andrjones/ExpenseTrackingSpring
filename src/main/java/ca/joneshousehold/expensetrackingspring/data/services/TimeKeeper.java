package ca.joneshousehold.expensetrackingspring.data.services;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;

/**
 * Wrapper around Joda's DateTime.now() so that we can easily inject a test mock to supply dates and times for testing.
 */
@Component
public class TimeKeeper {
    private static final TimeKeeper instance = new TimeKeeper();

    private TimeKeeper() {}

    public static TimeKeeper getInstance() {
        return instance;
    }

    public DateTime now() {
        return DateTime.now(DateTimeZone.UTC);
    }
}
