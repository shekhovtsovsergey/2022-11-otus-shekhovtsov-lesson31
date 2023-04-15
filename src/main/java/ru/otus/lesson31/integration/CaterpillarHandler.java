package ru.otus.lesson31.integration;

import org.springframework.stereotype.Component;
import ru.otus.lesson31.model.Caterpillar;
import ru.otus.lesson31.model.Cocoon;


@Component
public class CaterpillarHandler {

    public Cocoon transform(Caterpillar caterpillar) {
        System.out.println("Гусеница превращается в куколку");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Cocoon(caterpillar.getName(), caterpillar.getAge());
    }

}

