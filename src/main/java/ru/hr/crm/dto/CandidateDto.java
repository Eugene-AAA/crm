package ru.hr.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateDto {
    //TODO: Добавить соцсети
    //TODO: Добавить дату рождения и фильтр, чтобы видеть кого поздравить
    //TODO: Добавить ссылку на резюме
    private Long id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String otherContacts;
}
