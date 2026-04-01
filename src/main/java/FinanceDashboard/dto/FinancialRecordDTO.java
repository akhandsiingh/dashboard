package FinanceDashboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Data
public class FinancialRecordDTO {
    @NotNull
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotBlank
    private String type;

    @NotBlank
    private String category;

    @NotNull
    private Date date;

    private String description;
}