package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.DbTests;
import ru.hr.crm.entity.data.Vacancy;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestRepositoryTest extends DbTests {

    @Autowired
    TestRepository repository;

    @AfterEach
    @Transactional
    void delete() {
        repository.deleteAll();
        assertEquals(repository.findAll().size(), 0);
    }

    @Test
    @Transactional
    void saveAndFind() {
        ru.hr.crm.entity.data.Test expected = ru.hr.crm.entity.data.Test.builder()
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
                .build();
        ru.hr.crm.entity.data.Test save = repository.save(expected);
        assertNotNull(save);
        ru.hr.crm.entity.data.Test actual = repository.findById(save.getId()).orElse(null);
        assertNotNull(actual);
        assertEquals(expected.getVacancy().getTitle(), actual.getVacancy().getTitle());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

}