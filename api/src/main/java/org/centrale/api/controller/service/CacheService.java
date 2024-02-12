package org.centrale.api.controller.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;


import org.centrale.domain.Game;

@Component
public class CacheService {

    final private List<Game> myList;


    public CacheService(){
        myList = new ArrayList<Game>();
    }

    public List<Game> getMyList() {
        return myList;
    }

    public void add(Game partie) {
        myList.add(partie);
    }
}
