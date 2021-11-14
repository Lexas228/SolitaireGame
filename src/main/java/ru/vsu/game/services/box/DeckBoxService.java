package ru.vsu.game.services.box;

import ru.vsu.game.model.Box;
import ru.vsu.game.model.Card;
import ru.vsu.game.model.Field;
import ru.vsu.game.model.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeckBoxService implements BoxService{
    @Override
    public List<Move> getAvailableMoves(Field field, Box box) {
        List<Move> moves = new ArrayList<>();
        if(!box.getCards().empty())
            moves.add(new Move(box, field.getReserve(), 1));
        return moves;
    }

    @Override
    public boolean isPossible(Move move) {
        return false;
    }

    @Override
    public Stack<Card> getCards(Box box, int num) {
        Stack<Card> cards = new Stack<>();
        for(int i = 0; i < num; i++){
            Card c = box.getCards().pop();
            c.setOpen(true);
            cards.push(c);
        }
        return cards;
    }

    @Override
    public void putCards(Stack<Card> stack, Box to) {
        while(!stack.empty()){
            stack.peek().setOpen(false);
            to.getCards().push(stack.pop());
        }
    }
}
