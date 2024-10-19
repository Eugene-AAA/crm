package ru.hr.crm.repository.repositoryService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hr.crm.entity.meta.Status;
import ru.hr.crm.repository.jpaRepository.StatusRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RepositoryService {
    private StatusRepository repository;

    @Transactional
    public List<Status> findAll() {
        return repository.findAll();
    }
}
