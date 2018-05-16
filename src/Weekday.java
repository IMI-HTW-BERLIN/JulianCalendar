public enum Weekday {

    MONDAY(0, "Monday"),
    TUESDAY(1, "Tuesday"),
    WEDNESDAY(2, "Wednesday"),
    THURSDAY(3, "Thursday"),
    FRIDAY(4, "Friday"),
    SATURDAY(5, "Saturday"),
    SUNDAY(6, "Sunday"),
    ERROR(-1, "");

    private final String name;
    private final int number;

    Weekday(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Weekday fromNumber(int number) {
        for (Weekday w : Weekday.values()) {
            if (w.number == number) return w;
        }
        return ERROR;
    }

}
