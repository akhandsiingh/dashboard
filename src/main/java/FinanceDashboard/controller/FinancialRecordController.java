package FinanceDashboard.controller;

import FinanceDashboard.dto.FinancialRecordDTO;
import FinanceDashboard.model.FinancialRecord;
import FinanceDashboard.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService service;

    @PostMapping
    public FinancialRecord create(@Valid @RequestBody FinancialRecordDTO dto) {
        return service.createRecord(dto, "user1");
    }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAllRecords();
    }

    @GetMapping("/type/{type}")
    public List<FinancialRecord> getByType(@PathVariable String type) {
        return service.filterByType(type);
    }

    @GetMapping("/category/{category}")
    public List<FinancialRecord> getByCategory(@PathVariable String category) {
        return service.filterByCategory(category);
    }
}