package org.centrale.api.controller;

import lombok.AllArgsConstructor;
import org.centrale.api.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PlayController {


    final GameService gameService;

    @PostMapping("/play")
    public String play(@RequestParam Long player1Id, @RequestParam Long player2Id,@RequestParam String handPlayer1,@RequestParam String handPlayer2){
        return gameService.play(player1Id, player2Id,handPlayer1,handPlayer2);
    }


    @GetMapping("/game-stats")
    public String getStats(@RequestParam Long playerId1){
        return gameService.getStats(playerId1);
    }

}
