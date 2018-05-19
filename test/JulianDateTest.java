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
    public void tomorrow() { assertEquals(1,date.tomorrow() - date.getJulianDate());
    }

    @Test
    public void yesterday() { assertEquals(1, date.getJulianDate() - date.yesterday());
    }

    @Test
    public void daysBetween() { assertEquals(6, date.daysBetween(new JulianDate(2018, 5, 10)));
    }

    @Test
    public void daysBetweenReverse() { assertEquals(6, date.daysBetween(new JulianDate(2018, 5, 22)));
    }

    @Test
    public void weekday() { assertEquals(Weekday.WEDNESDAY, date.weekday());
    }

    @Test
    public void toGregorianDate() { assertEquals("16.05.2018", date.toGregorianDate());
    }

    @Test
    public void toMetricDate() { assertEquals("Day 5, Week 5, Month 2, Year 2458", date.toMetricDate());
    }

    @Test
    public void getJulianDate() { assertEquals(2458255, date.getJulianDate());
    }

    @Test
    public void setJulianDate() { date.setJulianDate(42); assertEquals(date.getJulianDate(), 42);
    }
}