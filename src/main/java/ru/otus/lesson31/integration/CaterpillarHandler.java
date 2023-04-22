package ru.otus.lesson31.integration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;
import ru.otus.lesson31.model.Caterpillar;
import ru.otus.lesson31.model.Cocoon;


@Component
public class CaterpillarHandler {

    @ServiceActivator(inputChannel = "caterpillarChannel", outputChannel = "cocoonChannel")
    public Cocoon transform(Caterpillar caterpillar) {
        System.out.println("Гусеница превращается в куколку");
        if (caterpillar.getAge() == 0) {
            throw new RuntimeException();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Cocoon(caterpillar.getName(), caterpillar.getAge());
    }

    @ServiceActivator(inputChannel = "errorChannel")
    public void handleRuntimeException(ErrorMessage errorMessage) {
        System.out.println("Произошла ошибка: " + errorMessage.getPayload());
    }
}

