package ru.hr.crm.service;

import ru.hr.crm.dto.CandidateDto;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    List<CandidateDto> getAllCandidates();
    Optional<CandidateDto> findById(Long id);
    void saveCandidate(CandidateDto candidateDto);
    void deleteCandidate(CandidateDto candidateDto);
}
