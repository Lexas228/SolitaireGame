package ru.vsu.game.services;

import ru.vsu.game.components.MoveGetter;
import ru.vsu.game.components.MoveValidator;
import ru.vsu.game.model.*;
import ru.vsu.game.services.box.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GameServiceImp implements GameService{
    private final FieldService fieldService;
    private final PrintService printService;
    private final Map<BoxType, BoxService> boxServiceMap;
    public GameServiceImp(){
        this.fieldService = new FieldServiceImp();
        this.printService = new PrintServiceImp();
        boxServiceMap = Map.of(BoxType.Main, new MainBoxService(),
                BoxType.Deck, new DeckBoxService(),
                BoxType.Reserve, new ReserveBoxService(),
                BoxType.Game, new GameBoxService()
                );
    }
    @Override
    public Game createGame(Player player, MoveGetter moveGetter, MoveValidator moveValidator) {
        Game g = new Game();
        g.setPlayer(player);
        g.setMoveGetter(moveGetter);
        g.setMoveValidator(moveValidator);
        g.setField(fieldService.createField());
        g.setMoveList(new ArrayList<>());
        return g;
    }

    @Override
    public void startGame(Game game, int numOfMoves) {
        printService.print(game.getField());
        int k = 0;
        while(game.getGameStatus() != GameStatus.End && k < numOfMoves){
            Move m = game.getMoveGetter().getMove(game);
            if(game.getMoveValidator().isPossibleMove(m)){
                doMove(m, game);
                updateStatus(game);
                printService.print(game.getField());
                k++;
            }
        }
    }
    private void doMove(Move m, Game game){
        BoxService from = boxServiceMap.get(m.from().getBoxType());
        BoxService to = boxServiceMap.get(m.to().getBoxType());
        Stack<Card> stack = from.getCards(m.from(), m.numOfCards());
        to.putCards(stack, m.to());
        game.getMoveList().add(m);
    }

    private void updateStatus(Game game){
        Field f = game.getField();
        long res = f.getMain().stream().filter(box -> box.getCards().size() >= CardCost.values().length).count();
        game.setGameStatus(res >= f.getGame().size() ? GameStatus.End: GameStatus.Ok);
    }
}
