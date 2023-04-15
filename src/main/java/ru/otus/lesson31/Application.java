package ru.otus.lesson31;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.otus.lesson31.integration.CaterpillarHandler;
import ru.otus.lesson31.integration.CocoonHandler;
import ru.otus.lesson31.integration.TransformationGateway;
import ru.otus.lesson31.model.Butterfly;
import ru.otus.lesson31.model.Caterpillar;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        TransformationGateway gateway = context.getBean(TransformationGateway.class);
        Caterpillar caterpillar = new Caterpillar("Гусеница", 1);
        Butterfly butterfly = gateway.transform(caterpillar);
        System.out.println("Бабочка " + butterfly.getName() + " создана");
    }
}







