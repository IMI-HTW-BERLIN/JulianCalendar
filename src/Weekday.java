public enum Weekday {

    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday"),
    ERROR("");

    private String name;

    Weekday(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
