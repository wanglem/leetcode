import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

// MSFT
class DayOfTheWeek {
    private List<String> days =  Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return days.get(date.getDayOfWeek().getValue() % 7);
    }
}