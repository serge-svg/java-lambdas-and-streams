package com.svg.java.streams.repository;

import com.svg.java.streams.domain.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportRepository {

    static List<Sport> sportList = new ArrayList<>();

    static {
        sportList.add(new Sport("Padel", 4.5));
        sportList.add(new Sport("Soccer", 1.5));
        sportList.add(new Sport("Running", 2));
        sportList.add(new Sport("Ciclyng", 3));
    }

    public List<Sport> getAll() {
        return sportList;
    }

}
