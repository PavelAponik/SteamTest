package framework.webdriver;

import org.testng.Reporter;

import java.util.ResourceBundle;

public class Logger {

    public enum Locale {
        EN,
        RU
    }

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);
    private static Logger instance = null;
    private static final boolean logSteps = true;
    protected static ResourceBundle resourceBundle;

    public static synchronized Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    protected static String getLoc(final String key) {
        return resourceBundle.getString(key);
    }

    public void step(final int step) {
        logDelimMsg(getLoc("loc.logger.step") + String.valueOf(step));
    }

    private void logDelimMsg(final String msg) {
        if (logSteps) {
            info(String.format("--------==[ %1$s ]==--------", msg));
        }
    }

    public void info(final String message){
        logger.info(message);
        Reporter.log(message + "<br>");
    }

}
