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
class TestRepositoryTest {

    @Autowired
    TestRepository repository;

    @Transactional
    @Test
    void saveAndFind() {
        ru.hr.crm.repository.entity.data.Test expected = ru.hr.crm.repository.entity.data.Test.builder()
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
        ru.hr.crm.repository.entity.data.Test save = repository.save(expected);
        assertNotNull(save);
        ru.hr.crm.repository.entity.data.Test actual = repository.findById(save.getId()).orElse(null);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

}