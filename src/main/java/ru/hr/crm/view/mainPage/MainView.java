package ru.hr.crm.view.mainPage;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import ru.hr.crm.view.candidate.CandidatesView;
import ru.hr.crm.view.employee.EmployeeView;

@Route("")
public class MainView extends AppLayout {

    VerticalLayout layout;
    RouterLink linkCandidates;
    RouterLink linkHiringEmployees;

    public MainView() {
        layout = new VerticalLayout();
        linkCandidates = new RouterLink("Соискатели", CandidatesView.class);
        linkHiringEmployees = new RouterLink("Найм сотрудников", EmployeeView.class);
        layout.add(linkCandidates);
        layout.add(linkHiringEmployees);
        addToNavbar(new H3("HR CRM"));
        setContent(layout);
    }
}
