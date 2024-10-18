package ru.hr.crm.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hr.crm.repository.entity.meta.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
