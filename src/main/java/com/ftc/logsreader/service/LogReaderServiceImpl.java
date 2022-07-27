package com.ftc.logsreader.service;

import com.ftc.logsreader.configuration.Config;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class LogReaderServiceImpl implements LogReaderService {

    private final Config config;

    public LogReaderServiceImpl(Config config) {
        this.config = config;
    }

    @Override
    public List<String> getLogsAsLines() {
        try {
            return Files.readAllLines(config.getPathToLogFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
