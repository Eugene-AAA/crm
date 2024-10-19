package ru.hr.crm.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String otherContacts;
}
