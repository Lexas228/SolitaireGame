package ru.vsu.game.services.box;

import ru.vsu.game.model.Box;
import ru.vsu.game.model.Card;
import ru.vsu.game.model.Field;
import ru.vsu.game.model.Move;

import java.util.List;
import java.util.Stack;

public interface BoxService {
    List<Move> getAvailableMoves(Field field, Box box);
    boolean isPossible(Move move);
    default Stack<Card> getCards(Box box, int num){
        Stack<Card> cards = new Stack<>();
        for(int i = 0; i < num; i++){
            cards.push(box.getCards().pop());
        }
        return cards;
    }
    default void putCards(Stack<Card> stack, Box to){
        while(!stack.empty()){
            to.getCards().push(stack.pop());
        }
    }
}
