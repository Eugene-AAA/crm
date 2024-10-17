package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.repository.entity.meta.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StatusRepositoryTest {

    @Autowired
    StatusRepository repository;

    @Transactional
    @Test
    void saveAndFind() {
        Status expected = Status.builder()
                .code("code")
                .statusName("name")
                .description("desc")
                .build();
        Status save = repository.save(expected);
        assertNotNull(save);
        Status actual = repository.findById(save.getId()).orElse(null);
        assertEquals(expected, actual);
    }

}