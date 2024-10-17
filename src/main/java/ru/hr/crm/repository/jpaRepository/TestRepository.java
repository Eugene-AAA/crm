package ru.hr.crm.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hr.crm.repository.entity.data.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
