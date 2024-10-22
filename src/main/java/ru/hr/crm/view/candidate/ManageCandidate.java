package ru.hr.crm.view.candidate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hr.crm.dto.CandidateDto;
import ru.hr.crm.service.CandidatesService;

import java.util.Optional;

@Route("manageCandidate")
public class ManageCandidate extends AppLayout implements HasUrlParameter<Long> {

    Long id;
    FormLayout candidateForm;
    TextField name;
    TextField age;
    TextField email;
    TextField phone;
    TextField otherContacts;
    Button saveContact;

    @Autowired
    CandidatesService candidatesService;

    public ManageCandidate() {

        //Создаем объекты для формы
        candidateForm = new FormLayout();
        name = new TextField("Имя");
        age = new TextField("Возраст");
        email = new TextField("Почта");
        phone = new TextField("Номер телефона");
        otherContacts = new TextField("Другие контакты");
        saveContact = new Button("Сохранить");

        //Добавим все элементы на форму
        candidateForm.add(name, age, email, phone, otherContacts, saveContact);
        setContent(candidateForm);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long contactId) {
        id = contactId;
        if (!id.equals(0L)) {
            addToNavbar(new H3("Редактирование соискателя"));
        } else {
            addToNavbar(new H3("Создание соискателя"));
        }
        fillForm();
    }


    public void fillForm() {

        if (!id.equals(0L)) {
            Optional<CandidateDto> candidateDto = candidatesService.findById(id);
            candidateDto.ifPresent(candidate -> {
                name.setValue(candidate.getName());
                age.setValue(String.valueOf(candidate.getAge()));
                email.setValue(candidate.getEmail());
                phone.setValue(candidate.getPhone());
                otherContacts.setValue(candidate.getOtherContacts());
            });
        }

        saveContact.addClickListener(clickEvent -> {
            //Создадим объект контакта получив значения с формы
            CandidateDto candidateDto = new CandidateDto();
            if (!id.equals(0L)) {
                candidateDto.setId(id);
            }
            candidateDto.setName(name.getValue());
            candidateDto.setAge(Integer.parseInt(age.getValue()));
            candidateDto.setEmail(email.getValue());
            candidateDto.setPhone(phone.getValue());
            candidateDto.setOtherContacts(otherContacts.getValue());
            candidatesService.saveCandidate(candidateDto);

            //Выведем уведомление пользователю и переведем его к списку контактов
            Notification notification = new Notification(id.equals(0L) ? "Соискатель успешно создан" : "Соискатель был изменен", 1000);
            notification.setPosition(Notification.Position.MIDDLE);
            notification.addDetachListener(detachEvent -> UI.getCurrent().navigate(CandidatesView.class));
            candidateForm.setEnabled(false);
            notification.open();
        });
    }
}
