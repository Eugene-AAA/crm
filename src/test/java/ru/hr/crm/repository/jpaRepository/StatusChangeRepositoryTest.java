package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.DbTests;
import ru.hr.crm.repository.entity.data.Candidate;
import ru.hr.crm.repository.entity.data.StatusChange;
import ru.hr.crm.repository.entity.data.Vacancy;
import ru.hr.crm.repository.entity.meta.Status;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StatusChangeRepositoryTest extends DbTests {

    @Autowired
    StatusChangeRepository repository;

    @AfterEach
    @Transactional
    void delete() {
        repository.deleteAll();
        assertEquals(repository.findAll().size(), 0);
    }

    @Test
    @Transactional
    void testSaveAndFind() {
        StatusChange expected = StatusChange.builder()
                .candidate(Candidate.builder()
                        .name("uniqName")
                        .email("email")
                        .phone("phone")
                        .createdAt(LocalDateTime.of(2020, 1, 1, 1, 1))
                        .updatedAt(LocalDateTime.of(2020, 1, 1, 1, 1))
                        .build())
                .vacancy(Vacancy.builder()
                        .title("uniqTitle")
                        .department("dep")
                        .createdAt(LocalDateTime.of(2020, 1, 1, 1, 1))
                        .updatedAt(LocalDateTime.of(2020, 1, 1, 1, 1))
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
        assertEquals(expected.getCandidate().getName(), actual.getCandidate().getName());
        assertEquals(expected.getVacancy().getTitle(), actual.getVacancy().getTitle());
        assertEquals(expected.getChangeDate(), actual.getChangeDate());
        assertEquals(expected.getNewStatus().getCode(), actual.getNewStatus().getCode());
        assertEquals(expected.getOldStatus().getCode(), actual.getOldStatus().getCode());
    }

}