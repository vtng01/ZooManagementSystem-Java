package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Lion extends AbstractAnimal implements LargeAnimal {

    private String name;
    public Lion(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    public Lion(LocalDate dateOfBirth, String name) {
        super(dateOfBirth, name);
    }

    @Override
    public void feed() {
        System.out.println("RAWR!!!!  (Lion)");
        super.feed();
    }

}
