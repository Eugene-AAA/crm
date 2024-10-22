package ru.hr.crm.view.candidate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hr.crm.dto.CandidateDto;
import ru.hr.crm.service.CandidatesService;

import java.util.List;

@Route("candidate")
public class CandidatesView extends AppLayout {

    @Autowired
    private CandidatesService candidatesService;
    VerticalLayout layout;
    Grid<CandidateDto> grid;
    RouterLink linkCreate;


    public CandidatesView(CandidatesService candidatesService) {
        layout = new VerticalLayout();
        grid = new Grid<>();
        linkCreate = new RouterLink("Создать нового соискателя", ManageCandidate.class, 0L);
        layout.add(linkCreate);
        layout.add(grid);
        addToNavbar(new H3("Список соискателей"));
        setContent(layout);
        this.candidatesService = candidatesService;
    }

    @PostConstruct
    public void fillGrid() {
        List<CandidateDto> candidateDtos = candidatesService.getAllCandidates();
        if (!candidateDtos.isEmpty()) {
            grid.addColumn(CandidateDto::getName).setHeader("Имя");
            grid.addColumn(CandidateDto::getAge).setHeader("Возраст");
            grid.addColumn(CandidateDto::getEmail).setHeader("Почта");
            grid.addColumn(CandidateDto::getPhone).setHeader("Телефон");
            grid.addColumn(CandidateDto::getOtherContacts).setHeader("Другие контакты");

            grid.addColumn(new NativeButtonRenderer<>("Редактировать",
                    candidate -> UI.getCurrent().navigate(ManageCandidate.class, candidate.getId())));

            grid.addColumn(new NativeButtonRenderer<>("Удалить", candidateDto -> {
                Dialog dialog = new Dialog();
                Button confirm = new Button("Удалить");
                Button cancel = new Button("Отмена");
                dialog.add("Вы уверены что хотите удалить соискателя? ");
                dialog.add(confirm);
                dialog.add(cancel);

                confirm.addClickListener(clickEvent -> {
                    candidatesService.deleteCandidate(candidateDto);
                    dialog.close();
                    Notification notification = new Notification("Соискатель удален", 1000);
                    notification.setPosition(Notification.Position.MIDDLE);
                    notification.open();

                    grid.setItems(candidatesService.getAllCandidates());
                });

                cancel.addClickListener(clickEvent -> dialog.close());
                dialog.open();

            }));
            grid.setItems(candidateDtos);
        }
    }
}