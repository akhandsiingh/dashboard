package FinanceDashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class DashboardResponseDTO {

    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;

    private Map<String, Double> categoryTotals;
}