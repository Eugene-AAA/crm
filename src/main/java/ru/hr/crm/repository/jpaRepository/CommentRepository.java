package ru.hr.crm.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hr.crm.entity.data.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
