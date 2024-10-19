package ru.hr.crm.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hr.crm.entity.data.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
