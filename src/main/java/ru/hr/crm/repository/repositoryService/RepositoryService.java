package ru.hr.crm.repository.repositoryService;

import java.util.List;
import java.util.Optional;

public interface RepositoryService<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T dto);
    Boolean delete(T dto);
}
