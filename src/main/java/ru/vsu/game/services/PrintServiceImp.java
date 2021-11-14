package ru.vsu.game.services;

import ru.vsu.game.model.Box;
import ru.vsu.game.model.Card;
import ru.vsu.game.model.Field;

import java.util.Stack;

public class PrintServiceImp implements PrintService{
    @Override
    public void print(Field field) {
        System.out.println("---------------------------------------------------------");
        System.out.println("In deck:" + (field.getDeck().getCards().size()) + " cards");
        System.out.println("In reserve:" + (field.getReserve().getCards().empty() ? "empty" : field.getReserve().getCards().peek()));
        System.out.println("Main");
        int k = 1;
        for(Box b : field.getMain()){
            System.out.print(k + ") ");
            System.out.println(b.getCards().empty() ? "empty" : b.getCards().peek());
            k++;
        }
        k = 1;
        System.out.println("Game");
        for(Box b : field.getGame()){
            System.out.print(k + " ");
            printCards(b.getCards());
            k++;
        }
        System.out.println("---------------------------------------------------------");
    }

    private void printCards(Stack<Card> cards){
        for(Card c : cards){
            System.out.print("|");
            if(c.isOpen())
                System.out.print(c);
            else
                System.out.print("cl");
            System.out.print("|");
        }
        System.out.println();
    }
}
