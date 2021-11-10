package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Zebra extends AnimalThatCanBeGroomed implements LargeAnimal{
    private String name;

    private LocalDateTime lastGroomed;

    public Zebra(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }
    public Zebra(LocalDate dateOfBirth, String name) {
        super(dateOfBirth, name);
    }

    @Override
    public void feed() {
        System.out.println("Neigh!!!  (Zebra)");
        super.feed();
    }
}
