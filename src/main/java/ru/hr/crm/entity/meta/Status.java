package ru.hr.crm.entity.meta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.hr.crm.entity.BasicEntity;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@Entity
@Table(name = "statuses")
public class Status extends BasicEntity {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "status_name", nullable = false, unique = true)
    private String statusName;

    @Column(name = "description")
    private String description;

}