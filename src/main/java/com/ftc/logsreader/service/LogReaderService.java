package com.ftc.logsreader.service;

import java.util.List;

public interface LogReaderService {

    List<String> getLogFilesName();

    List<String> getLogsFromFile(String fileName);

    void cleanLogsFromFile(String fileName);
}
