package ru.hr.crm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.dto.CandidateDto;
import ru.hr.crm.repository.entity.data.Candidate;
import ru.hr.crm.mapper.CandidateMapper;
import ru.hr.crm.repository.jpaRepository.CandidateRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandidatesService {
    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;

    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();

        return candidates.stream()
                .map(candidateMapper::toCandidateDto).toList();
    }

    public Optional<CandidateDto> findById(Long id) {
        return Optional.of(candidateMapper.toCandidateDto(candidateRepository.findById(id).orElseThrow()));
    }

    @Transactional
    public void saveCandidate(CandidateDto candidateDto) {
        candidateRepository.save(candidateMapper.toCandidate(candidateDto));
    }

    @Transactional
    public void deleteCandidate(CandidateDto candidateDto) {
        candidateRepository.delete(candidateMapper.toCandidate(candidateDto));
    }
}
