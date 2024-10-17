package ru.hr.crm.repository.jpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.repository.entity.data.Candidate;
import ru.hr.crm.repository.entity.data.Comment;
import ru.hr.crm.repository.entity.data.Vacancy;
import ru.hr.crm.repository.entity.meta.Status;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository repository;

    @Transactional
    @Test
    void testSaveAndFind() {
        Comment expected = Comment.builder()
                .commentText("comment")
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
        assertEquals(expected.getVacancy(), actual.getVacancy());
        assertEquals(expected.getCommentText(), actual.getCommentText());
        assertEquals(expected.getCandidate(), actual.getCandidate());
        assertEquals(expected.getStatus(), actual.getStatus());
    }

}