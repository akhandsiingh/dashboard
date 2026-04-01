package FinanceDashboard.controller;

import FinanceDashboard.dto.DashboardResponseDTO;
import FinanceDashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping
    public DashboardResponseDTO getSummary() {
        return service.getSummary();
    }
}