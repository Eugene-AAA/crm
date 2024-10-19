package ru.hr.crm.view;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hr.crm.entity.meta.Status;
import ru.hr.crm.repository.repositoryService.RepositoryService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TestController {
    RepositoryService service;

    @GetMapping("/test")
    public ResponseEntity<List<Status>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
