# Mancala GAME
[Mancala](https://en.wikipedia.org/wiki/Mancala) is a 2-player, turn-based strategy board game based on small stones on a board. The objective is to capture more stones than your opponent. There are many varieties of the game depending on the region. THIS IS ONE.

This project implements the game logic.

## Game Play
Players can choose any hole located on their side of the board. Stones are then dropped into following cells, however skipping the opponent's score cell. Game ends when a player scores 24 or more points.

                  -   -   -   -   -   -
                | 4 | 4 | 4 | 4 | 4 | 4 |   <-P2
                  -   -   -   -   -   -
             (*)                         (*)
              0          MANCALA          0
             (*)                         (*)
                  -   -   -   -   -   -
         P1->   | 4 | 4 | 4 | 4 | 4 | 4 |
                  -   -   -   -   -   -
