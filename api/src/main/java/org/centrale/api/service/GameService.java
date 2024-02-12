package org.centrale.api.service;

import lombok.AllArgsConstructor;
import org.centrale.api.entity.GameEntity;
import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.repository.GameRepository;
import org.centrale.domain.PierreFeuilleCiseaux.Hand;
import org.centrale.domain.PierreFeuilleCiseaux.HandFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    final GameRepository gameRepository;
    final PlayerDBService playerDBService;


    public String play(Long playerId1, Long playerId2,String Hand1,String Hand2) {
        PlayerEntity player1 = playerDBService.getPlayerEntity(playerId1);
        PlayerEntity player2 = playerDBService.getPlayerEntity(playerId2);

        GameEntity game = new GameEntity();
        game.setPlayer1(player1);
        game.setPlayer2(player2);


        Hand1 = Hand1.substring(0, 1).toUpperCase() + Hand1.substring(1).toLowerCase();
        Hand2 = Hand2.substring(0, 1).toUpperCase() + Hand2.substring(1).toLowerCase();

        Hand main1 = HandFactory.from(Hand1);

        Hand main2 = HandFactory.from(Hand2);

        switch (main1.playWith(main2)){
            case 0:
                game.setWinner(null);
                break;
            case 1:
                game.setWinner(player2);
                break;
            case -1:
                game.setWinner(player1);
                break;
        }
        gameRepository.save(game);
        if(game.getWinner() != null){
            return "Victoire de ID " + game.getWinner().getId() + " c'est à dire victoire de " + game.getWinner().getName();
        }else{
            return "Egalité !";
        }
    }


    public String getStats(Long playerId1){


        int numberOfGames = gameRepository.findAllGamesWithPlayerId(playerId1).size();
        int numberOfWin = gameRepository.findAllGamesWithWinnerId(playerId1).size();
        List<Object[]> resultList = gameRepository.findMostFrequentWinnerIdExceptOne(playerId1);

        return "Le nombre de parties du joueur ayant l'ID : " + playerId1 + " cest à dire de " + playerDBService.getPlayerById(playerId1).getName() +  " est " + numberOfGames +
                " et son nombre de victoires total est " + numberOfWin + ".\nSa bête noire est " + playerDBService.getPlayerById((long) resultList.get(0)[0]).getName()  +
                " car il a perdu " + resultList.get(0)[1] + " fois contre lui !";


    }

}
