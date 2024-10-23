package ru.hr.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;
    private String name;
    private LocalDate searchRequestDate;
    private LocalDate jobClosingDate;
    private int differenceInDays;
    private int howMuchDidWork;
    private String employeeType; // TODO: Сделать enum
    private String status; // TODO: Сделать enum
    private String company; // TODO: Сделать enum
    private int paymentPerEmployee;
}
