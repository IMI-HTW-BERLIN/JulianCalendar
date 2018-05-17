public class JulianDate {

    //private final float daysPerYear = 365.2563604167F, daysPerMonth = 30.4380300347F;
    private long julianDate;

    public JulianDate(int year, int month, int day){
        //julianDate = (int) ((year + 4713) * daysPerYear + month * daysPerMonth + day);
        julianDate = (1461 * (year + 4800 + (month - 14)/12))/4 +(367 * (month - 2 - 12 * ((month - 14)/12)))/12 - (3 * ((year + 4900 + (month- 14)/12)/100))/4 + day - 32075;
    }

    public long tomorrow(){
        return julianDate+1;
    }

    public long yesterday(){
        return julianDate-1;
    }

    public static long daysBetween(JulianDate firstDate, JulianDate secondDate){
        long delta = secondDate.julianDate - firstDate.julianDate;
        if(delta  < 0) return -delta;
        return delta;
    }

    public long daysBetween(JulianDate secondDate){
        return daysBetween(this, secondDate);
    }

    public Weekday weekday() {
        int weekdayNum = (int) (julianDate % 7);
        return Weekday.fromNumber(weekdayNum);
    }

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

    public String toMetricDate() {
        long year = julianDate / 1000;
        long month = (julianDate - (year * 1000)) / 100;
        long week = (julianDate - (year * 1000 + month * 100)) / 10;
        long day = julianDate - (year * 1000 + month * 100 + week * 10);

        return "Day " + day + ", Week " + week + ", Month " + month + ", Year " + year;
    }

    public long getJulianDate() {
        return julianDate;
    }

    public void setJulianDate(long julianDate) {
        this.julianDate = julianDate;
    }
}
