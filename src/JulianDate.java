public class JulianDate {

    private final float daysPerYear = 365.2563604167F, daysPerMonth = 30.4380300347F;
    private long julianDate;
    //private float julianDateF;

    public JulianDate(int year, int month, int day){
        //julianDateF = (year + 4713) * daysPerYear + month * daysPerMonth + day;
        julianDate = (1461 * (year + 4800 + (month - 14)/12))/4 +(367 * (month - 2 - 12 * ((month - 14)/12)))/12 - (3 * ((year + 4900 + (month- 14)/12)/100))/4 + day - 32075;
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

    public Weekday weekday() {
        int weekdayNum = (int) (julianDate % 7);

        switch (weekdayNum) {
            case 0:
                return Weekday.MONDAY;
            case 1:
                return Weekday.TUESDAY;
            case 2:
                return Weekday.WEDNESDAY;
            case 3:
                return Weekday.THURSDAY;
            case 4:
                return Weekday.FRIDAY;
            case 5:
                return Weekday.SATURDAY;
            case 6:
                return Weekday.SUNDAY;
            default:
                return Weekday.ERROR;
        }
    }

    public long getJulianDate() {
        return julianDate;
    }

    public void setJulianDate(long julianDate) {
        this.julianDate = julianDate;
    }
}
