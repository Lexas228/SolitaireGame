package ru.vsu.game.model;

import java.util.Stack;

public class Box {
    private final BoxType boxType;
    private final Stack<Card> cards;

    public Box(BoxType boxType) {
        this.boxType = boxType;
        cards = new Stack<>();
    }

    public BoxType getBoxType() {
        return boxType;
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
