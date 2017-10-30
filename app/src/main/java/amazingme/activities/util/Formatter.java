package amazingme.activities.util;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formatter {

    private static final String stringFormatForScoreDisplay = "#0.0";

    public Formatter() {}

    public static NumberFormat getStringFormatterForScoreDisplay() {
        return new DecimalFormat(stringFormatForScoreDisplay);
    }

}
