package app.exception;

import java.lang.Exception;

/**
 * Stringexeptions
 */
public class Stringexceptions{
    private static String expmsg;
    public Stringexceptions(String e) {
        expmsg = e;
    }
    public static String getMsg() {
        return expmsg;
    }
}
