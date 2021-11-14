package ru.vsu.game.model;

import java.util.List;

public class Field {
    private Box deck;
    private Box reserve;

    private List<Box> main;

    private List<Box> game;

    public Box getDeck() {
        return deck;
    }

    public void setDeck(Box deck) {
        this.deck = deck;
    }

    public Box getReserve() {
        return reserve;
    }

    public void setReserve(Box reserve) {
        this.reserve = reserve;
    }

    public List<Box> getMain() {
        return main;
    }

    public void setMain(List<Box> main) {
        this.main = main;
    }

    public List<Box> getGame() {
        return game;
    }

    public void setGame(List<Box> game) {
        this.game = game;
    }
}
