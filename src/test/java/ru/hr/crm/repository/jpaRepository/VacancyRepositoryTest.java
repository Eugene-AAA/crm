package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.repository.entity.data.Vacancy;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class VacancyRepositoryTest {

    @Autowired
    VacancyRepository repository;

    @Transactional
    @Test
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
        assertEquals(expected, actual);

    }

}