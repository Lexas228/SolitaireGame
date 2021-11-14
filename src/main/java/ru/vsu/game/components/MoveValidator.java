package ru.vsu.game.components;

import ru.vsu.game.model.Move;

public interface MoveValidator {
    boolean isPossibleMove(Move move);
}
