CREATE TABLE IF NOT EXISTS PLAYER (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      NAME VARCHAR(250) NOT NULL
    );

CREATE TABLE IF NOT EXISTS GAME (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    PLAYER1_ID VARCHAR(250) NOT NULL,
    PLAYER2_ID VARCHAR(250) NOT NULL,
    WINNER_ID VARCHAR(250) NOT NULL
    );
