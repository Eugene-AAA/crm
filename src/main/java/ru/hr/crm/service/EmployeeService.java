package ru.hr.crm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.hr.crm.dto.EmployeeDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    public List<EmployeeDto> getAllEmployees() {
        //TODO: репо под это
        //List<EmployeeDto> employees = employeeRepository.findAll();
        List<EmployeeDto> employees = new ArrayList<>();
        employees.add(EmployeeDto
                .builder()
                .name("Мордвинов Павел Евгеньевич")
                .searchRequestDate(LocalDate.of(2024, 10, 22))
                .jobClosingDate(LocalDate.of(2024, 10, 24))
                .differenceInDays(2)
                .howMuchDidWork(10)
                .employeeType("Менеджер")
                .status("Принят на работу")
                .company("Лавиро")
                .paymentPerEmployee(4500)
                .build());
        return employees;
    }
}
