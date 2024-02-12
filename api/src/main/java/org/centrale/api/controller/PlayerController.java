package org.centrale.api.controller;

import lombok.AllArgsConstructor;
import org.centrale.api.service.PlayerDBService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PlayerController {

    final PlayerDBService playerDBService;

    @PostMapping("/player")
    public String addPlayer(@RequestParam String name){
        return playerDBService.addNewPlayer(name);
    }

    @GetMapping("/player/{id}")
    public String getPlayerbyID(@PathVariable Long id){
        return "Le joueur ayant l'ID " + id + " est " + playerDBService.getPlayerById(id).getName();
    }




}
