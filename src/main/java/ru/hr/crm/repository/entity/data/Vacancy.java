package ru.hr.crm.repository.entity.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.hr.crm.repository.entity.BasicEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "vacancies")
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class Vacancy extends BasicEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}