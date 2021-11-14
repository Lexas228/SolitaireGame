package ru.vsu.game.services.box;

import ru.vsu.game.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class ReserveBoxService implements BoxService{
    private final static GameBoxService gameBoxService = new GameBoxService();
    private final static MainBoxService mainBoxService = new MainBoxService();

    @Override
    public List<Move> getAvailableMoves(Field field, Box box) {
        List<Move> moves = new ArrayList<>();
        if(!box.getCards().empty()){
            Stream<Box> boxes = Stream.concat(field.getMain().stream(), field.getGame().stream());
            boxes.forEach(b ->{
                BoxService need = b.getBoxType() == BoxType.Game ? gameBoxService : mainBoxService;
                Move m = new Move(box, b, 1);
                if(need.isPossible(m)){
                    moves.add(m);
                }
            });
       }
        if(field.getDeck().getCards().empty()){
            moves.add(new Move(box, field.getDeck(), box.getCards().size()));
        }
        return moves;
    }


    @Override
    public boolean isPossible(Move move) {
        if(move.from().getBoxType() != BoxType.Deck) return false;
        return move.numOfCards() == 1;
    }

}
