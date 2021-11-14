package ru.vsu.game.services.box;

import ru.vsu.game.model.Box;
import ru.vsu.game.model.Card;
import ru.vsu.game.model.Field;
import ru.vsu.game.model.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainBoxService implements BoxService{
    private final static GameBoxService gameBoxService = new GameBoxService();

    @Override
    public List<Move> getAvailableMoves(Field field, Box box) {
        List<Move> moves = new ArrayList<>();
        if(!box.getCards().empty()){
            field.getGame().forEach(b -> {
                Move m = new Move(box, b, 1);
                if(gameBoxService.isPossible(m)){
                    moves.add(m);
                }
            });
        }
        return moves;
    }

    @Override
    public boolean isPossible(Move move) {
        if(move.numOfCards() > 1) return false;
        Stack<Card> to = move.to().getCards();
        Stack<Card> from = move.from().getCards();
        int currCost = to.isEmpty() ? 0 : to.peek().getCardCost().getCost();
        if(!from.empty()) {
            Card flyingCard = from.peek();
            int flyingCost = flyingCard.getCardCost().getCost();
            Card under = to.empty() ? null : to.peek();
            return flyingCard.isOpen() && flyingCost - 1 == currCost && (under == null || under.getSuit() == flyingCard.getSuit());
        }
        return false;
    }

}
