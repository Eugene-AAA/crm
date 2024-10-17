package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.IntegrationTests;
import ru.hr.crm.repository.entity.meta.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StatusRepositoryTest extends IntegrationTests {

    @Autowired
    StatusRepository repository;

    @AfterEach
    @Transactional
    void delete() {
        repository.deleteAll();
        assertEquals(repository.findAll().size(), 0);
    }

    @Test
    @Transactional
    void saveAndFind() {
        Status expected = Status.builder()
                .code("code")
                .statusName("name")
                .description("desc")
                .build();
        Status save = repository.save(expected);
        assertNotNull(save);
        Status actual = repository.findById(save.getId()).orElse(null);
        assertNotNull(actual);
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getStatusName(), actual.getStatusName());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

}