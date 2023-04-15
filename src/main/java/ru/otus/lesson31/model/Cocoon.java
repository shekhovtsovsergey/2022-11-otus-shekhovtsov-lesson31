package ru.otus.lesson31.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cocoon extends Caterpillar {

    public Cocoon(String name, int age) {
        super(name, age);
    }
}
