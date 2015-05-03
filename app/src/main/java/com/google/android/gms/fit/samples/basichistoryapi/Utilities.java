package com.google.android.gms.fit.samples.basichistoryapi;

import android.graphics.Color;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by chris.black on 5/2/15.
 */
public class Utilities {

    /**
     * Lightens a color by a given factor.
     *
     * @param color
     *            The color to lighten
     * @param factor
     *            The factor to lighten the color. 0 will make the color unchanged. 1 will make the
     *            color white.
     * @return lighter version of the specified color.
     */
    public static int lighter(int color, float factor) {
        int red = (int) ((Color.red(color) * (1 - factor) / 255 + factor) * 255);
        int green = (int) ((Color.green(color) * (1 - factor) / 255 + factor) * 255);
        int blue = (int) ((Color.blue(color) * (1 - factor) / 255 + factor) * 255);
        return Color.argb(Color.alpha(color), red, green, blue);
    }

    public enum TimeFrame {
        BEGINNING_OF_DAY,
        BEGINNING_OF_WEEK,
        BEGINNING_OF_MONTH;
        private static TimeFrame[] vals = values();
        public TimeFrame next()
        {
            return vals[(this.ordinal()+1) % vals.length];
        }
    }

    public static String getTimeFrameText(TimeFrame timeFrame) {
        String result = "";
        switch (timeFrame) {
            case BEGINNING_OF_DAY: // 1 day
                result = "Today";
                break;
            case BEGINNING_OF_WEEK: // 1 week
                result = "This Week";
                break;
            case BEGINNING_OF_MONTH: // 1 month
                result = "This Month";
                break;
        }
        return result;
    }

    public static long getTimeFrameStamp(TimeFrame timeFrame) {

        Calendar cal = Calendar.getInstance();
        Date now = new Date();
        cal.setTime(now);
        switch (timeFrame) {
            case BEGINNING_OF_DAY: // 1 day
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                break;
            case BEGINNING_OF_WEEK: // 1 week
                cal.set(Calendar.DAY_OF_WEEK, 1);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                break;
            case BEGINNING_OF_MONTH: // 1 month
                cal.set(Calendar.DAY_OF_MONTH, 0);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                break;
        }
        return cal.getTimeInMillis();
    }
}
