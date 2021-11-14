package ru.vsu.game.components;

import ru.vsu.game.model.Move;

public class BotMoveValidator implements MoveValidator{
    @Override
    public boolean isPossibleMove(Move move) {
        return true;
    }
}
