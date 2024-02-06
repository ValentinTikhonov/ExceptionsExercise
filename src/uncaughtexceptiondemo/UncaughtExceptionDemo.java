package uncaughtexceptiondemo;

import java.util.logging.Logger;

public class UncaughtExceptionDemo {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(String.valueOf(UncaughtExceptionDemo.class));
        Utils util = new Utils();

        String result = null;  //Error puting 0 or 5.5 because isn't int
        try {
            result = util.doThis("8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        logger.info(result);
    }
}