package com.ftc.logsreader.service;

import com.ftc.logsreader.configuration.Config;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogReaderServiceImpl implements LogReaderService {

    private final Config config;

    public LogReaderServiceImpl(Config config) {
        this.config = config;
    }

    @Override
    public List<String> getLogFilesName() {
        List<String> filesName = new ArrayList<>();
        try {
            filesName = Files.list(config.getLogsDirectory()).map(file -> file.getFileName().toString()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filesName;
    }

    @Override
    public List<String> getLogsFromFile(String fileName) {
        List<String> logs = new ArrayList<>();
        Path logFilePath = getPathToFile(fileName);
        try {
            logs = Files.readAllLines(logFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }

    @Override
    public void cleanLogsFromFile(String fileName) {
        File logFile = getPathToFile(fileName).toFile();
        try (PrintWriter printWriter = new PrintWriter(logFile)) {
            printWriter.write("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Path getPathToFile(String fileName) {
        Path logFilePath = config.getLogsDirectory().resolve(fileName);
        if (!logFilePath.toFile().exists()) {
            throw new IllegalArgumentException("File not found");
        }
        return logFilePath;
    }
}
