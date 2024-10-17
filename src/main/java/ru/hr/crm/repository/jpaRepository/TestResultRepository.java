package ru.hr.crm.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hr.crm.repository.entity.data.TestResult;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}
