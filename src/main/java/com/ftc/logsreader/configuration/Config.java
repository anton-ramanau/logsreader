package com.ftc.logsreader.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class Config {

    private final Environment environment;

    public Config(Environment environment) {
        this.environment = environment;
    }

    public Path getPathToLogFile() {
        return Paths.get("logs/", environment.getProperty("LOG_FILE"));
    }
}
