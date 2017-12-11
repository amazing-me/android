package amazingme.util;

import org.joda.time.LocalDate;

public class DateAdapter {

    public static long convertLocalDateToMillis(LocalDate localDate) {
        return localDate.toDateTimeAtStartOfDay().toInstant().getMillis();
    }

    public static LocalDate convertMillisToLocalDate(long birthday) {
        return new LocalDate(birthday);
    }

}
