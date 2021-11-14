package ru.vsu.game.model;

public class Card {
    private final CardCost cardCost;
    private final Suit suit;
    private boolean open;

    public Card(CardCost cardCost, Suit suit, boolean open) {
        this.cardCost = cardCost;
        this.suit = suit;
        this.open = open;
    }

    public CardCost getCardCost() {
        return cardCost;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString(){
        return cardCost.getName() + ";" + suit;
    }
}
