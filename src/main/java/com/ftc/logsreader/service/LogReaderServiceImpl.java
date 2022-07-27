package com.ftc.logsreader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class LogReaderServiceImpl implements LogReaderService {

    public static String ENV_NAME_PATH_TO_LOG_FILE = "PATH_TO_LOG_FILE";
    private final Environment environment;

    public LogReaderServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public List<String> getLogsAsLines() {
        Path logPath = Paths.get(environment.getProperty(ENV_NAME_PATH_TO_LOG_FILE));
        try {
            return Files.readAllLines(logPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
