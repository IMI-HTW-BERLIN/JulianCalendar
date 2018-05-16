public class JulianDate {
    private final float daysPerYear = 365.2563604167F, daysPerMonth = 30.4380300347F;
    private long julianDate;
    private float julianDateF;

    public JulianDate(int year, int month, int day){
        julianDateF = (year + 4713) * daysPerYear + month * daysPerMonth + day;
        julianDate = (long)julianDateF;
    }

    public long tomorrow(){
        return julianDate+1;
    }

    public long yesterday(){
        return julianDate-1;
    }

    public static long daysBetween(JulianDate FirstDate, JulianDate SecondDate){
        long delta = SecondDate.julianDate - FirstDate.julianDate;
        if(delta  < 0) return -delta;
        return delta;
    }

    public long daysBetween(JulianDate SecondDate){
        long delta = SecondDate.julianDate - julianDate;
        if(delta  < 0) return -delta;
        return delta;
    }

    public long getJulianDate() {
        return julianDate;
    }

    public void setJulianDate(long julianDate) {
        this.julianDate = julianDate;
    }
}
