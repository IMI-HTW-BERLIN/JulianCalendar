import java.security.InvalidParameterException;

/**
 * This class represents a Julian Date. It provides various methods to transform the date or to convert it into other date formats.
 * @author David Panagiotopulos
 * @author Luis Hankel
 * @version 2018.05.17
 */
public class JulianDate {

    //private final float daysPerYear = 365.2563604167F, daysPerMonth = 30.4380300347F;
    private long julianDate;

    /**
     * Creates a new JulianDate.
     * @param year The year of the date
     * @param month The month of the date
     * @param day The day of the date
     */
    public JulianDate(int year, int month, int day){
        month = Math.abs(month);
        day = Math.abs(day);
        //julianDate = (int) ((year + 4713) * daysPerYear + month * daysPerMonth + day);
        julianDate = (1461 * (year + 4800 + (month - 14)/12))/4 +(367 * (month - 2 - 12 * ((month - 14)/12)))/12 - (3 * ((year + 4900 + (month- 14)/12)/100))/4 + day - 32075;
    }

    /**
     * Get the following day.
     * @return The Julian Day Number plus one
     */
    public long tomorrow(){
        return julianDate+1;
    }

    /**
     * Get the previous day.
     * @return The Julian Day Number minus one
     */
    public long yesterday(){
        return julianDate-1;
    }

    /**
     * Gets the number of days between the first and the second julian date.
     * @param firstDate The first date
     * @param secondDate The second date
     * @return The number of days between the dates
     */
    public static long daysBetween(JulianDate firstDate, JulianDate secondDate){
        long delta = secondDate.julianDate - firstDate.julianDate;
        return (delta < 0) ? -delta : delta;
//        if(delta  < 0) return -delta;
//        return delta;
    }

    /**
     * Gets the number of days between the date the method is called on and the provided second date.
     * @param secondDate The second date
     * @return The number of days between the dates
     */
    public long daysBetween(JulianDate secondDate){
        return daysBetween(this, secondDate);
    }

    /**
     * Returns the day of the week of the julian date as enum
     * @return The weekday enum
     */
    public Weekday weekday() {
        int weekdayNum = (int) (julianDate % 7);
        return Weekday.fromNumber(weekdayNum);
    }

    /**
     * Converts the julian date into a gregorian date in the format "dd.MM.yyyy".
     * For the meaning of the date format see Java {@link java.text.SimpleDateFormat SimpleDateFormat}.
     * @return The gregorian date as String
     */
    public String toGregorianDate() {
        long f = julianDate + 1401 + (((4 * julianDate + 274277) / 146097) * 3) / 4 -38;
        long e = 4 * f + 3;
        long g = e % 1461 / 4;
        long h = 5 * g + 2;
        long day = (h % 153) / 5 + 1;
        long month = (h / 153 + 2) % 12 + 1;
        long year = (e / 1461) - 4716 + (12 + 2 - month) / 12;

        return ((day < 10) ? "0" : "") + day + "." + ((month < 10) ? "0" : "") + month + "." + year;
    }

    /**
     * Converts the julian date into a metric date in the format "Day u, Week W, Month M, Year y".
     * For the meaning of the date format see Java {@link java.text.SimpleDateFormat SimpleDateFormat}.
     * @return The metric date as String
     */
    public String toMetricDate() {
        long year = julianDate / 1000;
        long month = (julianDate - (year * 1000)) / 100;
        long week = (julianDate - (year * 1000 + month * 100)) / 10;
        long day = julianDate - (year * 1000 + month * 100 + week * 10);

        return "Day " + ++day + ", Week " + ++week + ", Month " + ++month + ", Year " + ++year;
    }

    /**
     * Gets the Julian Day Number of the date.
     * @return The Julian Day Number
     */
    public long getJulianDate() {
        return julianDate;
    }

    /**
     * Sets the Julian Day Number of the date.
     * @param julianDate The Julian Day Number to set the date to.
     */
    public void setJulianDate(long julianDate) {
        if(julianDate >= 0)
            this.julianDate = julianDate;
        else
            throw new InvalidParameterException("julianDate has to be a number greater that or equal to 0");
    }
}
