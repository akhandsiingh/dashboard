package FinanceDashboard.service;

import FinanceDashboard.dto.FinancialRecordDTO;
import FinanceDashboard.model.FinancialRecord;
import FinanceDashboard.model.RecordType;
import FinanceDashboard.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository repository;

    public FinancialRecord createRecord(FinancialRecordDTO dto, String userId) {

        FinancialRecord record = FinancialRecord.builder()
                .amount(dto.getAmount())
                .type(RecordType.valueOf(dto.getType()))
                .category(dto.getCategory())
                .date(dto.getDate())
                .description(dto.getDescription())
                .createdBy(userId)
                .build();

        return repository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return repository.findAll();
    }

    public List<FinancialRecord> filterByType(String type) {
        return repository.findByType(RecordType.valueOf(type));
    }

    public List<FinancialRecord> filterByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<FinancialRecord> filterByDate(Date start, Date end) {
        return repository.findByDateBetween(start, end);
    }
}