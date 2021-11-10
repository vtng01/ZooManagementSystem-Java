package org.softwire.training.zoo;

import org.softwire.training.zoo.models.*;
import org.softwire.training.zoo.services.FeedingScheduler;
import org.softwire.training.zoo.services.GroomingScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<LargeAnimal> largeAnimals = Arrays.asList(
                new Lion(LocalDate.of(2010, 4, 28)),
                new Lion(LocalDate.of(2012, 5, 11)),
                new Zebra(LocalDate.of(2008, 12, 1))
        );
        List<SmallAnimal> smallAnimals = Collections.singletonList(
                new Rabbit(LocalDate.of(2014, 1, 1))
        );

        List<SmallAnimal> smallAnimals2 = Arrays.asList(
                new GuineaFowl(LocalDate.of(2016, 1, 1))
        );

        List<Animal> animals = new ArrayList<>();
        animals.addAll(largeAnimals);
        animals.addAll(smallAnimals);
        animals.addAll(smallAnimals2);

        Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
        Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);
        Keeper<SmallAnimal> smallAnimalKeeper2 = new Keeper<>(smallAnimals2);

        List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper, smallAnimalKeeper2);

        Rabbit babyRabbit = new Rabbit(LocalDate.now());
        smallAnimalKeeper.startLookingAfter(babyRabbit);

        FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
        GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();

        feedingScheduler.assignFeedingJobs(keepers);
        groomingScheduler.assignGroomingJobs(keepers);
        animals.forEach(System.out::println);
    }
}
