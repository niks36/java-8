import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StringToDate {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "11/12/2017";
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(localDate);

        date = "2017-12-11";
        localDate = LocalDate.parse(date);
        System.out.println(localDate);

        date = "11-Dec-2017";
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        localDate = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(localDate);

        date = "Mon, Dec 11 2017";
        dateTimeFormatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");
        localDate = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(localDate);

        date = "Monday, Dec 11, 2017 16:18:00 PM";

        dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
        localDate = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(localDate);

        String dateInString = "2017-12-11T15:23:01Z";
        Instant instant = Instant.parse(dateInString);
        System.out.println(instant);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
        System.out.println(localDateTime.toLocalDate());


        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);

        date = "2017-12-11T10:15:30+08:00";
        ZonedDateTime result = ZonedDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(result);


        System.out.println();

        LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 20, 55);
        LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

        System.out.println(oldDate);
        System.out.println(newDate);

        //count seconds between dates
        Duration duration = Duration.between(oldDate, newDate);
        System.out.println(duration.getSeconds());

        LocalDate oldDate1 = LocalDate.of(1982, Month.AUGUST, 31);
        LocalDate newDate2 = LocalDate.of(2016, Month.NOVEMBER, 9);
        Period period = Period.between(oldDate1, newDate2);
        System.out.print(period.getYears() + " years,");
        System.out.print(period.getMonths() + " months,");
        System.out.print(period.getDays() + " days");

    }

}
