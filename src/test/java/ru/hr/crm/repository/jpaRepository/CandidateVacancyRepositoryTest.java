package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.repository.entity.data.Candidate;
import ru.hr.crm.repository.entity.data.CandidateVacancy;
import ru.hr.crm.repository.entity.data.Vacancy;
import ru.hr.crm.repository.entity.meta.Status;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CandidateVacancyRepositoryTest {

    @Autowired
    CandidateVacancyRepository repository;

    @Transactional
    @Test
    void testSaveAndFind() {
        CandidateVacancy expected = CandidateVacancy.builder()
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
                .currentStatus(Status.builder()
                        .statusName("uniqName")
                        .code("code")
                        .build())
                .createdAt(LocalDateTime.of(2020, 1, 1, 1, 1))
                .updatedAt(LocalDateTime.of(2020, 1, 1, 1, 1))
                .build();
        CandidateVacancy save = repository.save(expected);
        assertNotNull(save);
        CandidateVacancy actual = repository.findById(save.getId()).orElse(null);
        assertNotNull(actual);
        assertEquals(expected.getCandidate().getName(), actual.getCandidate().getName());
        assertEquals(expected.getVacancy().getTitle(), actual.getVacancy().getTitle());
        assertEquals(expected.getCurrentStatus().getStatusName(), actual.getCurrentStatus().getStatusName());
        assertEquals(expected.getCreatedAt(), actual.getCreatedAt());
        assertEquals(expected.getUpdatedAt(), actual.getUpdatedAt());
    }

}