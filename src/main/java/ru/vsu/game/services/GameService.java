package ru.vsu.game.services;

import ru.vsu.game.components.MoveGetter;
import ru.vsu.game.components.MoveValidator;
import ru.vsu.game.model.Game;
import ru.vsu.game.model.Player;

public interface GameService {
    Game createGame(Player player, MoveGetter moveGetter, MoveValidator moveValidator);
    void startGame(Game game, int numOfMoves);
}
