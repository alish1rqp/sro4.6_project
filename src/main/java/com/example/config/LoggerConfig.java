package com.example.config;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import java.net.URL;

public class LoggerConfig {
    static {
        try {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            context.reset();
            URL configFile = LoggerConfig.class.getClassLoader().getResource("logback.xml");
            if (configFile != null) {
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(context);
                configurator.doConfigure(configFile);
            } else {
                throw new RuntimeException("Файл logback.xml не найден");
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);
        } catch (JoranException e) {
            throw new RuntimeException("Ошибка загрузки конфигурации логирования", e);
        }
    }
}
