package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnimalThatCanBeGroomed extends AbstractAnimal implements Animal{
    private LocalDateTime lastGroomed;
    private String name;

    protected AnimalThatCanBeGroomed(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    protected AnimalThatCanBeGroomed(LocalDate dateOfBirth, String name) {
        super(dateOfBirth, name);
    }

    public void groom() {
        lastGroomed = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}; Last Groomed {1}", super.toString(), lastGroomed);
    }

}
