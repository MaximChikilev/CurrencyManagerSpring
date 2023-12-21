package ua.kiev.prog.demo;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Component
public class DateConverter {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    java.util.Date date = null;

    public Date convertStringToDate(String stringDate) {
        try {
            date = formatter.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String prepareStringDate(String inputDate) {
        String output = (inputDate.equals("") ? getDayBeforeDate() : inputDate);
        String[] array = output.split("-");
        output = array[0] + array[1] + array[2];
        return output;
    }

    private String getDayBeforeDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(LocalDate.now().toString(), formatter);
        LocalDate dayBefore = date.minusDays(1);
        return dayBefore.toString();
    }
}
