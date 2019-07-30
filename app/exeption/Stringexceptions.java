package app.exception;

import java.lang.Exception;

/**
 * Stringexeptions
 */
public class Stringexeptions{
    private static String expmsg;
    public Stringexeptions(String e) {
        expmsg = e;
    }
    public static String getMsg() {
        return expmsg;
    }
}
