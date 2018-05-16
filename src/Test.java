import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args) {
        JulianDate date = new JulianDate(2018, 5, 16);
        System.out.println(date.weekday());
        System.out.println(date.toGregorianDate());
        System.out.println(date.toMetricDate());

        System.out.println();

        birthday(1997, 10, 10);
        birthday(1999, 01, 19);
    }

    public static boolean test() {
        return false;
    }

    private static void birthday(int year, int month, int day) {
        LocalDateTime today = LocalDateTime.now();
        JulianDate todayJulian = new JulianDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());

        JulianDate birthday = new JulianDate(year, month, day);

        long ageInDays = JulianDate.daysBetween(birthday, todayJulian);

        System.out.println("You are " + ageInDays + " days old.");
        System.out.println("You were born on a " + birthday.weekday() + ".");

        if (todayJulian.getJulianDate() == birthday.getJulianDate())
            System.out.println("Happy birthday!");

        if (ageInDays % 100 == 0)
            System.out.println("You are " + ageInDays / 100 + " times 100 days old! Congratulations!");
    }

}
