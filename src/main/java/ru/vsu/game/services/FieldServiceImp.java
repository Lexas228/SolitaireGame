package ru.vsu.game.services;

import ru.vsu.game.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FieldServiceImp implements FieldService{
    @Override
    public Field createField() {
        List<Card> card = generateCards();
        Collections.shuffle(card);
        Field f = new Field();
        f.setDeck(new Box(BoxType.Deck));
        f.setReserve(new Box(BoxType.Reserve));
        List<Box> forMain = new ArrayList<>();
        List<Box> forGame = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            forMain.add(new Box(BoxType.Main));
        }
        for(int i = 0; i < 7; i++){
            forGame.add(new Box(BoxType.Game));
        }
        f.setGame(forGame);
        f.setMain(forMain);
        for(Card c : card){
            f.getDeck().getCards().push(c);
        }
        start(f);
        return f;
    }

    private List<Card> generateCards(){
        CardCost[] costs = CardCost.values();
        Suit[] suits = Suit.values();
        List<Card> cards = new ArrayList<>();
        for(Suit c : suits){
            for(CardCost s : costs){
                cards.add(new Card(s, c, false));
            }
        }
        return cards;
    }

    private void start(Field f){
        List<Box> game = f.getGame();
        for(int i = 0; i < game.size(); i++){
            for(int j = 0; j <= i; j++){
                Card c = f.getDeck().getCards().pop();
                c.setOpen(j==i);
                game.get(i).getCards().push(c);
            }
        }
    }
}
