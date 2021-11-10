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
                new Lion(LocalDate.of(2010, 4, 28), "Snoop Lion"),
                new Lion(LocalDate.of(2012, 5, 11)),
                new Zebra(LocalDate.of(2008, 12, 1))
        );
        List<SmallAnimal> smallAnimals = Collections.singletonList(
                new Rabbit(LocalDate.of(2014, 1, 1), "Peter")
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
        babyRabbit.setName("John Smith");

        GuineaFowl babyGuineaFowl = new GuineaFowl(LocalDate.now(), "Spearrow");
        animals.add(babyGuineaFowl);
        animals.add(babyRabbit);
        smallAnimalKeeper.startLookingAfter(babyRabbit);


        FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
        GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();

        System.out.println("===============");
        System.out.println("Feeding animal");
        feedingScheduler.assignFeedingJobs(keepers);
        groomingScheduler.assignGroomingJobs(keepers);

        System.out.println("================");
        System.out.println("List of animals in Zoo");
        animals.forEach(System.out::println);
//        keepers.forEach(keeper -> {
//            keeper.getResponsibleAnimals().forEach(System.out::println);
//        });

        System.out.println("================");
        System.out.println("Attempting to pet animal");
        animals.forEach(animal -> {animal.doesSomething();});
    }
}
