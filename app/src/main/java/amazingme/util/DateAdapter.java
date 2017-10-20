package amazingme.util;

import org.joda.time.LocalDate;

import amazingme.model.AmazingMeDate;

public class DateAdapter {

    public static AmazingMeDate convertLocalDateToBirthday(LocalDate localDate) {
        return new AmazingMeDate(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth());
    }

    public static LocalDate convertBirthdayToLocalData(AmazingMeDate birthday) {
        return new LocalDate(birthday.getBirthYear(), birthday.getBirthMonth(), birthday.getBirthDay());
    }

}
