package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.repository.entity.data.Candidate;
import ru.hr.crm.repository.entity.data.StatusChange;
import ru.hr.crm.repository.entity.data.Vacancy;
import ru.hr.crm.repository.entity.meta.Status;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StatusChangeRepositoryTest {

    @Autowired
    StatusChangeRepository repository;

    @Transactional
    @Test
    void testSaveAndFind() {
        StatusChange expected = StatusChange.builder()
                .candidate(Candidate.builder()
                        .name("uniqName")
                        .email("email")
                        .phone("phone")
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .vacancy(Vacancy.builder()
                        .title("uniqTitle")
                        .department("dep")
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .newStatus(Status.builder()
                        .statusName("uniqName")
                        .code("code")
                        .build())
                .oldStatus(Status.builder()
                        .statusName("uniqName2")
                        .code("code2")
                        .build())
                .changeDate(LocalDateTime.of(2020, 1, 1, 1, 1))
                .build();
        StatusChange save = repository.save(expected);
        assertNotNull(save);
        StatusChange actual = repository.findById(save.getId()).orElse(null);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

}