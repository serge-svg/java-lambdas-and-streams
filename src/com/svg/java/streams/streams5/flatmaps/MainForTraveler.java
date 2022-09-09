package com.svg.java.streams.streams5.flatmaps;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainForTraveler {
    /*
        Print travellers' trips without using streams
        Print travellers' trips using stream
     */
    public static void main(String[] args) {
        Trip tripPortugal = new Trip("Portugal");
        Trip tripItaly = new Trip("Italy");
        Trip tripFrance = new Trip("France");

        Traveler traveler1 = new Traveler("traveler1");
        traveler1.addTrip(tripFrance);

        Traveler traveler2 = new Traveler("traveler2");
        traveler2.addTrip(tripItaly);
        traveler2.addTrip(tripFrance);

        Traveler traveler3 = new Traveler("traveler3");
        traveler3.addTrip(tripItaly);
        traveler3.addTrip(tripFrance);
        traveler3.addTrip(tripPortugal);

        List<Traveler> travelerList = new ArrayList<>();
        travelerList.add(traveler1);
        travelerList.add(traveler2);
        travelerList.add(traveler3);

        // Print all trips per person without using streams
        for (Traveler traveler : travelerList) {
            for (Trip trip : traveler.getTrips()) {
                System.out.printf("The traveler %s has been in %s %n", traveler.getName(), trip.getCountry());
            }
        }

        // Print all trips per person using streams
        System.out.println("Streams option 1");
        travelerList.stream()
                .flatMap(traveler -> traveler.getTrips().stream())
                .map(trip -> trip.getCountry())
                .forEach(System.out::println);

        // Print all trips per person using streams
        System.out.println("Streams option 2");
        travelerList.stream()
                .map(Traveler::getTrips)
                .flatMap(trips -> trips.stream())
                .map(trip -> trip.getCountry())
                .forEach(System.out::println);
    }
}
