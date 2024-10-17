package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.IntegrationTests;
import ru.hr.crm.repository.entity.data.Vacancy;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VacancyRepositoryTest extends IntegrationTests {

    @Autowired
    VacancyRepository repository;

    @AfterEach
    @Transactional
    void delete() {
        repository.deleteAll();
        assertEquals(repository.findAll().size(), 0);
    }

    @Test
    @Transactional
    void saveAndFind() {
        Vacancy expected = Vacancy.builder()
                .title("title")
                .description("desc")
                .department("department")
                .createdAt(LocalDateTime.of(2020, 1, 1, 1, 1))
                .updatedAt(LocalDateTime.of(2020, 1, 1, 1, 1))
                .build();
        Vacancy save = repository.save(expected);
        assertNotNull(save);
        Vacancy actual = repository.findById(save.getId()).orElse(null);
        assertNotNull(actual);
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getDepartment(), actual.getDepartment());
    }

}