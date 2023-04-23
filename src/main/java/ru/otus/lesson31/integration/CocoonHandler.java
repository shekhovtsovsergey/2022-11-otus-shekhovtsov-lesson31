package ru.otus.lesson31.integration;

import org.springframework.stereotype.Component;
import ru.otus.lesson31.model.Butterfly;
import ru.otus.lesson31.model.Caterpillar;


@Component
public class CocoonHandler {
    public Butterfly transform(Caterpillar caterpillar) {
        System.out.println("Куколка превращается в бабочку");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Butterfly(caterpillar.getName(), caterpillar.getAge());
    }
}


