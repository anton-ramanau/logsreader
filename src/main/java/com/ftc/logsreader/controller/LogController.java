package com.ftc.logsreader.controller;

import com.ftc.logsreader.service.LogReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LogController {
    private final LogReaderService logReaderService;

    public LogController(LogReaderService logReaderService) {
        this.logReaderService = logReaderService;
    }

    @GetMapping("/")
    public String getLogsFiles(Model model) {
        model.addAttribute("files", logReaderService.getLogFilesName());
        return "logFilesPage";
    }

    @GetMapping("/logs/{logFile}")
    public String getLogsView(@PathVariable String logFile, Model model) {
        model.addAttribute("logs", logReaderService.getLogsFromFile(logFile));
        return "logsView";
    }
}
