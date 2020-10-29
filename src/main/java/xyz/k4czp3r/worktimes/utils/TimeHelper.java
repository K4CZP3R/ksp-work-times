package xyz.k4czp3r.worktimes.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {
    public static long convertToUnix(String rfc2822date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
        Date date = format.parse(rfc2822date);
        return date.getTime();
    }
}
