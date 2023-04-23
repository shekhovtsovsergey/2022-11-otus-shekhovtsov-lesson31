package ru.otus.lesson31;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.lesson31.integration.TransformationGateway;
import ru.otus.lesson31.model.Caterpillar;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        TransformationGateway gateway = context.getBean(TransformationGateway.class);
        gateway.transform(new Caterpillar("Гусеница", 0));
    }
}







