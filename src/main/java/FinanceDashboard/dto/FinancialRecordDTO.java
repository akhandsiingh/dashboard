package FinanceDashboard.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FinancialRecordDTO {
    private Double amount;
    private String type;
    private String category;
    private Date date;
    private String description;
}