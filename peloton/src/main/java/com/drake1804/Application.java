package com.drake1804;

import com.drake1804.utils.MyLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Pavel.Shkaran on 8/2/2016.
 */
@SpringBootApplication
@EnableScheduling
public class Application {
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
        MyLogger.setup();
    }
}
