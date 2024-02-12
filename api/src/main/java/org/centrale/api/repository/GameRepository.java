package org.centrale.api.repository;

import org.centrale.api.entity.GameEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<GameEntity, Long> {


    @Query("SELECT g FROM GameEntity g WHERE g.player1.id = :playerId OR g.player2.id = :playerId")
    List<GameEntity> findAllGamesWithPlayerId(@Param("playerId") Long playerId);
    @Query("SELECT g FROM GameEntity g WHERE g.winner.id = :winnerId")
    List<GameEntity> findAllGamesWithWinnerId(@Param("winnerId") Long winnerId);

    @Query("SELECT g.winner.id, COUNT(g.winner.id) AS count FROM GameEntity g WHERE g.winner.id != :winnerIdParam GROUP BY g.winner.id ORDER BY count DESC")
    List<Object[]> findMostFrequentWinnerIdExceptOne(@Param("winnerIdParam") Long winnerIdParam);


}
