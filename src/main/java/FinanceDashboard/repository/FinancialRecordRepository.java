package FinanceDashboard.repository;

import FinanceDashboard.model.FinancialRecord;
import FinanceDashboard.model.RecordType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface FinancialRecordRepository extends MongoRepository<FinancialRecord, String> {

    List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(Date startDate, Date endDate);
}