package com.ftc.logsreader.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class Config {

    private final Environment environment;

    public Config(Environment environment) {
        this.environment = environment;
    }

    public Path getLogsDirectory() {
        Path path = Paths.get(environment.getProperty("LOGS_DIRECTORY"));
        File directory = path.toFile();
        if (!directory.exists()) {
            throw new IllegalArgumentException("LOGS_DIRECTORY doesn't exist");
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Env LOGS_DIRECTORY is not directory");
        }
        return path;
    }
}
