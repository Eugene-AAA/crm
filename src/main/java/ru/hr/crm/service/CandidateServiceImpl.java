package ru.hr.crm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.dto.CandidateDto;
import ru.hr.crm.mapper.CandidateMapper;
import ru.hr.crm.repository.model.Candidate;
import ru.hr.crm.repository.repositoryService.RepositoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandidateServiceImpl implements CandidateService {
    private final RepositoryService<Candidate> repositoryService;
    private final CandidateMapper candidateMapper;

    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = repositoryService.findAll();

        return candidates.stream()
                .map(candidateMapper::toCandidateDto).toList();
    }

    public Optional<CandidateDto> findById(Long id) {
        return Optional.of(candidateMapper.toCandidateDto(repositoryService.findById(id).orElseThrow()));
    }

    @Transactional
    public void saveCandidate(CandidateDto candidateDto) {
        repositoryService.save(candidateMapper.toCandidate(candidateDto));
    }

    @Transactional
    public void deleteCandidate(CandidateDto candidateDto) {
        repositoryService.delete(candidateMapper.toCandidate(candidateDto));
    }
}
