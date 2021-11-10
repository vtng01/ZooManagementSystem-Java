package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rabbit extends AnimalThatCanBeGroomed implements SmallAnimal {
    private String name;

    public Rabbit(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void feed() {
        System.out.println("Munch Munch (Rabbit)");
        super.feed();
    }
    public Rabbit(LocalDate dateOfBirth, String name) {
        super(dateOfBirth, name);
    }

}
