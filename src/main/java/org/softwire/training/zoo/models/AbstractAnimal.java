package org.softwire.training.zoo.models;

import org.softwire.training.zoo.Config;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public abstract class AbstractAnimal implements Animal {
    private LocalDate dateOfBirth;
    private LocalDateTime lastFed;
    private String name;

    protected AbstractAnimal(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    protected AbstractAnimal(LocalDate dateOfBirth, String name) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    public Duration age() {
        return Duration.between(LocalDate.now(), dateOfBirth);
    }

    @Override
    public void feed() {
        lastFed = LocalDateTime.now();
    }

    @Override
    public boolean isHungry() {
        // Obviously an animal wouldn't get hungry in a matter of seconds.
        // But it means we can see activity in real time when we run the code...
        return Duration.between(LocalDateTime.now(), lastFed).compareTo(Config.getFeedingFrequency()) > 0;
    }

    @Override
    public void doesSomething() {

        double probability = Math.random();
        if (probability < 0.3) {
            System.out.println(getClass().getSimpleName() + ", " + this.name + ", attacked keeper!");
        } else {
            System.out.println(getClass().getSimpleName() + ", " + this.name + ", became docile!");
        }

    }

    @Override
    public String toString() {
        if (name == null) {
            name = "no name given";
        }

        return MessageFormat.format("{0}, name: {1}, last fed {2}", getClass().getSimpleName(), this.name, lastFed);
    }

    public void setName(String name) {
        this.name = name;
    };
}
