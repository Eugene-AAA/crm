package ru.hr.crm.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hr.crm.entity.data.CandidateVacancy;

@Repository
public interface CandidateVacancyRepository extends JpaRepository<CandidateVacancy, Long> {
}
