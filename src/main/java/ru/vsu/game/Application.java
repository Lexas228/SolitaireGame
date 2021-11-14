package ru.vsu.game;

import ru.vsu.game.components.BotMoveGetter;
import ru.vsu.game.components.BotMoveValidator;
import ru.vsu.game.model.Bot;
import ru.vsu.game.model.Game;
import ru.vsu.game.services.GameServiceImp;

public class Application {
    public static void main(String[] args){
        GameServiceImp gameServiceImp = new GameServiceImp();
        Game g = gameServiceImp.createGame(new Bot(), new BotMoveGetter(), new BotMoveValidator());
        gameServiceImp.startGame(g, 50);

    }
}
