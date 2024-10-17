package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.IntegrationTests;
import ru.hr.crm.repository.entity.data.Candidate;
import ru.hr.crm.repository.entity.data.TestResult;
import ru.hr.crm.repository.entity.data.Vacancy;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestResultRepositoryTest extends IntegrationTests {

    @Autowired
    TestResultRepository repository;

    @AfterEach
    @Transactional
    void delete() {
        repository.deleteAll();
        assertEquals(repository.findAll().size(), 0);
    }

    @Test
    @Transactional
    void testSaveAndFind() {
        TestResult expected = TestResult.builder()
                .test(ru.hr.crm.repository.entity.data.Test.builder()
                        .maxScore(10)
                        .title("title")
                        .vacancy(Vacancy.builder()
                                .title("uniqTitle")
                                .department("dep")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build())
                        .description("desc")
                        .createdAt(LocalDateTime.of(2020, 1, 1, 1, 1))
                        .build())
                .score(1)
                .candidate(Candidate.builder()
                        .name("uniqName")
                        .email("email")
                        .phone("phone")
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .resultDate(LocalDateTime.of(2020, 1, 1, 1, 1))
                .build();
        TestResult save = repository.save(expected);
        assertNotNull(save);
        TestResult actual = repository.findById(save.getId()).orElse(null);
        assertNotNull(actual);
        assertEquals(expected.getTest().getTitle(), actual.getTest().getTitle());
        assertEquals(expected.getCandidate().getName(), actual.getCandidate().getName());
        assertEquals(expected.getScore(), actual.getScore());
        assertEquals(expected.getResultDate(), actual.getResultDate());
    }
}