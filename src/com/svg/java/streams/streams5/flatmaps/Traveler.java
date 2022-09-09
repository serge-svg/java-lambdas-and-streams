package com.svg.java.streams.streams5.flatmaps;

import java.util.ArrayList;
import java.util.List;

public class Traveler {
    private final String name;
    private List<Trip> trips = new ArrayList<>();

    public Traveler(String name){
        this.name = name;
    }

    protected List<Trip> getTrips(){
        return trips;
    }

    public String getName() {
        return name;
    }

    protected void addTrip(Trip trip) {
        trips.add(trip);
    }
}
