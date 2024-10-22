package ru.hr.crm.view.employee;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hr.crm.dto.EmployeeDto;
import ru.hr.crm.service.EmployeeService;
import ru.hr.crm.view.candidate.ManageCandidate;

import java.util.List;

@Route("employee")
public class EmployeeView extends AppLayout {

    @Autowired
    private EmployeeService employeeService;
    VerticalLayout layout;
    Grid<EmployeeDto> grid;
    RouterLink linkCreate;

    public EmployeeView(EmployeeService employeeService) {
        layout = new VerticalLayout();
        grid = new Grid<>();
        linkCreate = new RouterLink("Новый сотрудник", ManageCandidate.class, 0L);
        //layout.add(linkCreate);
        layout.add(grid);
        addToNavbar(new H3("Список сотрудников, которых наняли"));
        setContent(layout);
        this.employeeService = employeeService;
    }

    @PostConstruct
    public void fillGrid() {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        if (!employeeDtos.isEmpty()) {
            grid.addColumn(EmployeeDto::getName).setHeader("ФИО сотрудника");
            grid.addColumn(EmployeeDto::getSearchRequestDate).setHeader("Дата заявки на поиск");
            grid.addColumn(EmployeeDto::getJobClosingDate).setHeader("Дата закрытия вакансии");
            grid.addColumn(EmployeeDto::getDifferenceInDays).setHeader("Разница дней от заявки до закрытия");
            grid.addColumn(EmployeeDto::getHowMuchDidWork).setHeader("Сколько отработал");
            grid.addColumn(EmployeeDto::getEmployeeType).setHeader("Тип сотрудника");
            grid.addColumn(EmployeeDto::getStatus).setHeader("Статус");
            grid.addColumn(EmployeeDto::getCompany).setHeader("Компания");
            grid.addColumn(EmployeeDto::getPaymentPerEmployee).setHeader("Оплата за сотрудника");

            // TODO: Манипуляции с данными (удалить, добавить, редактировать)
            grid.setItems(employeeDtos);
        }
    }
}
