import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JulianDateTest {

    private JulianDate date;

    @Before
    public void setUp() {
        date = new JulianDate(2018, 5, 16);
    }

    @Test
    public void tomorrow() {
        assertEquals(date.tomorrow() - date.getJulianDate(), 1);
    }

    @Test
    public void yesterday() {
        assertEquals(date.getJulianDate() - date.yesterday(), 1);
    }

    @Test
    public void daysBetween() {
        assertEquals(date.daysBetween(new JulianDate(2018, 5, 10)), 6);
    }

    @Test
    public void weekday() {
        assertEquals(date.weekday(), Weekday.WEDNESDAY);
    }

    @Test
    public void toGregorianDate() {
        assertEquals(date.toGregorianDate(), "16.05.2018");
    }

    @Test
    public void toMetricDate() {
        assertEquals(date.toMetricDate(), "Day 5, Week 5, Month 2, Year 2458");
    }
}