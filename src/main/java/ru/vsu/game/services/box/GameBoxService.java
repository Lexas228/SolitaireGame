package ru.vsu.game.services.box;

import ru.vsu.game.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameBoxService implements BoxService{
    private final static MainBoxService mainBoxService = new MainBoxService();


    @Override
    public List<Move> getAvailableMoves(Field field, Box box) {
        List<Move> moves = new ArrayList<>();
        if(!box.getCards().empty()) {
            field.getMain().forEach(b -> {
                Move m = new Move(box, b, 1);
                if (mainBoxService.isPossible(m)) {
                    moves.add(m);
                }
            });

            field.getGame().stream().filter(b -> b != box).forEach(b -> {
                int num = 1;
                while(num-1 < box.getCards().size() && box.getCards().get(num-1).isOpen()){
                    Move m = new Move(box, b, num);
                    if(isPossible(m)){
                        moves.add(m);
                    }
                    num++;
                }
            });
        }
        return moves;
    }

    @Override
    public boolean isPossible(Move move) {
        Stack<Card> my = move.to().getCards();
        BoxType fromBox = move.from().getBoxType();
        if(fromBox == BoxType.Deck) return false;
        if(fromBox == BoxType.Main || fromBox == BoxType.Reserve){
            if(move.numOfCards() > 1) return false;
        }
        if(my.empty() && move.numOfCards() > 1) return false;
        Card under = my.empty() ? null : my.peek();
        int currCost = under == null ? 14 : under.getCardCost().getCost();
        Card flying = move.from().getCards().get(move.numOfCards() - 1);
        return flying.isOpen() && flying.getCardCost().getCost() + 1 == currCost && (under == null || flying.getSuit().getColor() != under.getSuit().getColor());
    }

    @Override
    public Stack<Card> getCards(Box box, int num) {
        Stack<Card> cards = new Stack<>();
        for(int i = 0; i < num; i++){
            cards.push(box.getCards().pop());
        }
        if(!box.getCards().empty() && !box.getCards().peek().isOpen()){
            box.getCards().peek().setOpen(true);
        }
        return cards;
    }
}
