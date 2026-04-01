package FinanceDashboard.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "financial_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialRecord {

    @Id
    private String id;

    private Double amount;
    private RecordType type;
    private String category;
    private Date date;
    private String description;

    private String createdBy;
}