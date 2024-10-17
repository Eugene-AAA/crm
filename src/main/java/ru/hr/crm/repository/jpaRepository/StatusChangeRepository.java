package ru.hr.crm.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hr.crm.repository.entity.data.StatusChange;

@Repository
public interface StatusChangeRepository extends JpaRepository<StatusChange, Long> {
}