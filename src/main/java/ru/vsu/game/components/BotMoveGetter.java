package ru.vsu.game.components;

import ru.vsu.game.model.*;
import ru.vsu.game.services.box.*;

import java.util.List;
import java.util.Map;

public class BotMoveGetter implements MoveGetter{
    private final Map<BoxType, BoxService> boxTypeBoxServiceMap;

    public BotMoveGetter() {
        this.boxTypeBoxServiceMap = Map.of(
                BoxType.Main, new MainBoxService(),
                BoxType.Deck, new DeckBoxService(),
                BoxType.Game, new GameBoxService(),
                BoxType.Reserve, new ReserveBoxService());

    }

    @Override
    public Move getMove(Game game) {
        return findFirstPossibleMove(game);
    }

    private Move findFirstPossibleMove(Game game){
        Field f = game.getField();
        for(Box b : f.getGame()){
           Move m = findFirstPossibleMoveFromBox(b,f);
           if(m != null) return m;
        }
        Move m = findFirstPossibleMoveFromBox(f.getReserve(), f);
        if(m != null) return m;
        for(Box b : f.getMain()){
            m = findFirstPossibleMoveFromBox( b, f);
            if(m != null) return m;
        }
        m = findFirstPossibleMoveFromBox(f.getDeck(),f);
        return m;
    }
    private Move findFirstPossibleMoveFromBox(Box b, Field f){
        List<Move> moves = boxTypeBoxServiceMap.get(b.getBoxType()).getAvailableMoves(f, b);
        if(!moves.isEmpty()) return moves.get(0);
        return null;
    }
}
