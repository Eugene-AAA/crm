package ru.hr.crm;

import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CrmApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }
}
