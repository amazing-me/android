package amazingme.util;

import org.joda.time.LocalDate;

import amazingme.model.Birthday;

public class DateAdapter {

    public static Birthday convertLocalDateToBirthday(LocalDate localDate) {
        return new Birthday(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth());
    }

    public static LocalDate convertBirthdayToLocalData(Birthday birthday) {
        return new LocalDate(birthday.getBirthYear(), birthday.getBirthMonth(), birthday.getBirthDay());
    }

}
