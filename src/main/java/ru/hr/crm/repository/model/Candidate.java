package ru.hr.crm.repository.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Candidate {
    //TODO: Добавить соцсети
    //TODO: Добавить дату рождения и фильтр, чтобы видеть кого поздравить
    //TODO: Добавить ссылку на резюме
    private Long id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String otherContacts;
    private LocalDateTime createdAt;
}
