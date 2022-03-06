package framework.webdriver;

import org.testng.Reporter;

public class Logger {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    public void info(final String message){
        logger.info(message);
        Reporter.log(message + "<br>");
    }

}
