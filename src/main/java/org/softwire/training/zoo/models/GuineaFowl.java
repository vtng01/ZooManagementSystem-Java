package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GuineaFowl extends AnimalThatCanBeGroomed implements SmallAnimal{
    private LocalDateTime lastGroomed;

    public GuineaFowl(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    public GuineaFowl(LocalDate dateOfBirth, String name) {
        super(dateOfBirth, name);
    }

    @Override
    public void feed() {
        System.out.println("Peck Peck (GuineaFowl)");
        super.feed();
    }

    public void setName(String name) {
        super.setName(name);
    }

//    @Override
//    public void groom() {
//        lastGroomed = LocalDateTime.now();
//    }

}
