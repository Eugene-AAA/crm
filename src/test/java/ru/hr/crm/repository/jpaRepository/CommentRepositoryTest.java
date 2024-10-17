package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.DbTests;
import ru.hr.crm.repository.entity.data.Candidate;
import ru.hr.crm.repository.entity.data.Comment;
import ru.hr.crm.repository.entity.data.Vacancy;
import ru.hr.crm.repository.entity.meta.Status;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CommentRepositoryTest extends DbTests {

    @Autowired
    CommentRepository repository;

    @AfterEach
    @Transactional
    void delete() {
        repository.deleteAll();
        assertEquals(repository.findAll().size(), 0);
    }

    @Test
    @Transactional
    void testSaveAndFind() {
        Comment expected = Comment.builder()
                .commentText("comment")
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
                .status(Status.builder()
                        .statusName("uniqName")
                        .code("code")
                        .build())
                .createdAt(LocalDateTime.now())
                .build();
        Comment save = repository.save(expected);
        assertNotNull(save);
        Comment actual = repository.findById(save.getId()).orElse(null);
        assertNotNull(actual);
        assertEquals(expected.getVacancy().getTitle(), actual.getVacancy().getTitle());
        assertEquals(expected.getCommentText(), actual.getCommentText());
        assertEquals(expected.getCandidate().getName(), actual.getCandidate().getName());
        assertEquals(expected.getStatus().getCode(), actual.getStatus().getCode());
    }

}