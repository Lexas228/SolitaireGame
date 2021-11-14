package ru.vsu.game.components;

import ru.vsu.game.model.Game;
import ru.vsu.game.model.Move;

public interface MoveGetter {
    Move getMove(Game game);
}
