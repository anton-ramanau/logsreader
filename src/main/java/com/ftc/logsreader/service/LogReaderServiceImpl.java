package com.ftc.logsreader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class LogReaderServiceImpl implements LogReaderService {

    @Value("${PATH_TO_LOG_FILE}")
    private String pathToLogFile;

    @Override
    public List<String> getLogsAsLines() {
        Path logPath = Paths.get(pathToLogFile);
        try {
            return Files.readAllLines(logPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
