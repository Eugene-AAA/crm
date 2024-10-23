package ru.hr.crm.repository.repositoryService.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ru.hr.crm.repository.jpaRepository.CandidateRepository;
import ru.hr.crm.repository.model.Candidate;
import ru.hr.crm.repository.repositoryService.CandidateRepositoryService;
import ru.hr.crm.repository.repositoryService.mappers.CandidateMapper;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateRepositoryServiceImpl implements CandidateRepositoryService {
    private CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper = new CandidateMapper();
    public List<Candidate> findAll() {
        List<ru.hr.crm.repository.entity.data.Candidate> candidates = candidateRepository.findAll();
        return candidates.stream().map(candidateMapper::toModel).toList();
    }

    public Optional<Candidate> findById(Long id) {
        ru.hr.crm.repository.entity.data.Candidate candidate = candidateRepository.findById(id).orElseThrow(IllegalStateException::new);
        return Optional.of(candidateMapper.toModel(candidate));
    }

    public Candidate save(Candidate candidate) {
        return candidateMapper.toModel(candidateRepository.saveAndFlush(candidateMapper.fromModel(candidate)));
    }
    public Boolean delete(Candidate candidate) {
        candidateRepository.delete(candidateMapper.fromModel(candidate));
        return candidateRepository.findById(candidate.getId()).isEmpty();
    }
}
