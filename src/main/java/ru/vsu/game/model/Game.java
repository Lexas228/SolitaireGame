package ru.vsu.game.model;

import ru.vsu.game.components.MoveGetter;
import ru.vsu.game.components.MoveValidator;

import java.util.List;
import java.util.Map;

public class Game {
    private Player player;
    private MoveValidator moveValidator;
    private MoveGetter moveGetter;
    private Field field;
    private GameStatus gameStatus;
    private List<Move> moveList;

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MoveValidator getMoveValidator() {
        return moveValidator;
    }

    public void setMoveValidator(MoveValidator moveValidator) {
        this.moveValidator = moveValidator;
    }

    public MoveGetter getMoveGetter() {
        return moveGetter;
    }

    public void setMoveGetter(MoveGetter moveGetter) {
        this.moveGetter = moveGetter;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
