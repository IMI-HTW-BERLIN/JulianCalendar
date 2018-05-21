import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args) {
        JulianDate date = new JulianDate(2018, 5, 16);
        System.out.println(date.weekday());
        System.out.println(date.toGregorianDate());
        System.out.println(date.toMetricDate());

        System.out.println();

        birthday(1997, 10, 10);
        birthday(1999, 1, 19);

        System.out.println(isBirthdayToday(1999, 5, 17));

        System.out.println();
        aliveMetric("David", new JulianDate(1997, 10, 10));
        aliveMetric("Luis", new JulianDate(1999, 1, 1));
    }

    private static void birthday(int year, int month, int day) {
        LocalDateTime today = LocalDateTime.now();
        JulianDate todayJulian = new JulianDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());

        JulianDate birthday = new JulianDate(year, month, day);

        long ageInDays = JulianDate.daysBetween(birthday, todayJulian);

        System.out.println("You are " + ageInDays + " days old.");
        System.out.println("You were born on a " + birthday.weekday() + ".");

        if (todayJulian.toGregorianDate().substring(0, 5).equals(birthday.toGregorianDate().substring(0, 5)))
            System.out.println("Happy birthday!");

        if (ageInDays % 100 == 0)
            System.out.println("You are " + ageInDays / 100 + " times 100 days old! Congratulations!");
    }

    public static boolean isBirthdayToday(int year, int month, int day) {
        LocalDateTime today = LocalDateTime.now();
        JulianDate todayJulian = new JulianDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());

        JulianDate birthday = new JulianDate(year, month, day);

        return todayJulian.toGregorianDate().substring(0, 5).equals(birthday.toGregorianDate().substring(0, 5));
    }

    public static String aliveMetric(JulianDate birthday){
        LocalDateTime today = LocalDateTime.now();
        JulianDate now = new JulianDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
        birthday.setJulianDate(JulianDate.daysBetween(now, birthday));
        return birthday.toMetricDate();
    }

}
