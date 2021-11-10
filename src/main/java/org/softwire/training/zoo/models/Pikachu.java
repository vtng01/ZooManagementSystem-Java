package org.softwire.training.zoo.models;

import java.time.LocalDate;

public class Pikachu extends AnimalThatCanBeGroomed implements SmallAnimal{

    protected Pikachu(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    protected Pikachu(LocalDate dateOfBirth, String name) {
        super(dateOfBirth, name);
    }
}
