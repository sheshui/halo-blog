package neuqsoft.sheshui.haloblog.utils;

import org.springframework.lang.NonNull;

import java.util.Date;

public class DateUtils {
    private DateUtils(){

    }

    /**
     * Gets current date.
     *
     * @return current date
     */
    @NonNull
    public static Date now() {
        return new Date();
    }
}
