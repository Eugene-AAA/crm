package ru.hr.crm.repository.repositoryService.mappers;

import ru.hr.crm.repository.model.Candidate;

public class CandidateMapper {
    public Candidate toModel(ru.hr.crm.repository.entity.data.Candidate entity) {
        return Candidate.builder()
                .id(entity.getId())
                .age(1)
                .otherContacts(entity.getOtherContacts())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public ru.hr.crm.repository.entity.data.Candidate fromModel(Candidate model) {
        return ru.hr.crm.repository.entity.data.Candidate.builder()
                .id(model.getId())
                .otherContacts(model.getOtherContacts())
                .phone(model.getPhone())
                .email(model.getEmail())
                .name(model.getName())
                .createdAt(model.getCreatedAt())
                .build();
    }
}
