package ru.hr.crm.mapper;

import org.springframework.stereotype.Component;
import ru.hr.crm.dto.CandidateDto;
import ru.hr.crm.entity.data.Candidate;

import java.time.LocalDateTime;

@Component
public class CandidateMapper {

    public CandidateDto toCandidateDto(Candidate candidate) {
        return new CandidateDto(
                candidate.getId(),
                candidate.getName(),
                //TODO: доавить возвраст к Candidate
                20,
                candidate.getPhone(),
                candidate.getEmail(),
                candidate.getOtherContacts()
        );
    }

    public Candidate toCandidate(CandidateDto candidateDto) {
        return new Candidate().builder()
                .id(candidateDto.getId())
                .name(candidateDto.getName())
                .phone(candidateDto.getPhone())
                .email(candidateDto.getEmail())
                .otherContacts(candidateDto.getOtherContacts())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
