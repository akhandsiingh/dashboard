package FinanceDashboard.service;

import FinanceDashboard.dto.DashboardResponseDTO;
import FinanceDashboard.model.FinancialRecord;
import FinanceDashboard.model.RecordType;
import FinanceDashboard.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DashboardService {

    @Autowired
    private FinancialRecordRepository repository;

    public DashboardResponseDTO getSummary() {

        List<FinancialRecord> records = repository.findAll();

        double income = 0;
        double expense = 0;

        Map<String, Double> categoryTotals = new HashMap<>();

        for (FinancialRecord r : records) {

            if (r.getType() == RecordType.INCOME) {
                income += r.getAmount();
            } else {
                expense += r.getAmount();
            }

            categoryTotals.put(
                    r.getCategory(),
                    categoryTotals.getOrDefault(r.getCategory(), 0.0) + r.getAmount()
            );
        }

        double net = income - expense;

        return new DashboardResponseDTO(income, expense, net, categoryTotals);
    }
}