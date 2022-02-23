package framework.webdriver;

import org.testng.Reporter;

public class Logger {

    public enum Locale {
        EN,
        RU
    }

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);
    private static Logger instance = null;


    public static synchronized Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }



    public void info(final String message){
        logger.info(message);
        Reporter.log(message + "<br>");
    }

}
