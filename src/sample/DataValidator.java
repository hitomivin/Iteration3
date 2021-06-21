package sample;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataValidator {

    public static boolean isValidCPR(String CPR) {
        String cpr = CPR.trim();

        // blank check
        if (cpr.isBlank()) {
            return false;
        }

        // length check
        if (cpr.length() != 11) {
            return false;
        }

        // format check 6 cifre - 4 cifre
        if (cpr.matches("^[0-9]{6}-[0-9]{4}$")) {
            // date format check
            String date = cpr.substring(0, 6);
            if (!isValidDate(date)) {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    public static boolean isValidDate(String date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMuu");

        try {
            // parse date
            LocalDate parseDate = LocalDate.parse(date, dateFormat);
            return true;
        }
        catch (DateTimeException error) {
            System.err.println("Error: Date format is not correct.");
            return false;
        }

    }

}
