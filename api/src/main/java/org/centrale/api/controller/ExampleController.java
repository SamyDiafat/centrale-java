package org.centrale.api.controller;
import org.centrale.api.controller.service.*;
import org.centrale.domain.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

//http://localhost:8080/
//http://localhost:8080/h2-console
//Deadline 12 fevrier

@RestController
public class ExampleController {


    //Injection de cacheService à travers le constructeur
    final PlayerDBService playerDBService;

    final GameRepository gameRepository;

    final PlayerRepository playerRepository;

    public ExampleController(PlayerDBService playerDBService, GameRepository gameRepository, PlayerRepository playerRepository){
        this.playerDBService = playerDBService;
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    @PostMapping("/test")
    public String jouer(@RequestParam String player1, @RequestParam String player2){
        Game partie = new Game(player1,player2);
        return "Le joueur " + partie.joueur1.getNom() + " a le score " + partie.joueur1.getScore() ;
        // Idée sans regarde la proposition du prof
        // 1
        //Je vérifie s'il existe une entité Players, si non
            // Je créé une entité Players (id-name-score)
        // Je vérifie si les joueurs sont dans la table Players
            // Si non, j'ajoute les joueurs
        // J'actualise le score des joueurs
        // 2
        //Je vérifie s'il existe une entité GameHistory, si non
            // Je créé une entité GameHistory (ID-Joueur1-Joueur2-Résultat)
        // J'ajoute l'ID du match (automatique), les joueurs, et le résultat du match (il faut créer une méthode dans Game)

    }

    @PostMapping("/add")
    public void addPlayer(@RequestParam Integer ID, @RequestParam String name){
        playerDBService.addPlayer(ID,name);
    }


    @PostMapping("/addgame")
    public void addGame(@RequestParam Integer ID, @RequestParam String description){
        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(ID);
        gameEntity.setDescription(description);
        gameRepository.save(gameEntity);
    }


    @PostMapping("/player")
    public void addplayer(@RequestParam String name){
        Players players = new Players();
        players.setName(name);
        Integer newID = Math.toIntExact(playerRepository.count());
        players.setID(newID);
        playerRepository.save(players);
    }

    @GetMapping("/player/{id}")
    public String getPlayerName(@PathVariable Integer id){
        // Utilisez l'ID pour rechercher le joueur dans la base de données
        Players player = playerRepository.findById(id).orElse(null);
        if (player != null){
            return player.getName();
        } else {
            return "Le joueur n'existe pas";
        }
    }



}
