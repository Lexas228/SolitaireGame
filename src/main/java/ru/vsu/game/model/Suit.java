package ru.vsu.game.model;

public enum Suit {
    Clubs(Color.Black, '\u2663'),
    Diamonds(Color.Red, '\u2666'),
    Hearts(Color.Red, '\u2764'),
    Spades(Color.Black, '\u2660');

    private final Color color;
    private final char ch;

    Suit(Color color, char ch) {
        this.color = color;
        this.ch = ch;
    }

    public Color getColor() {
        return color;
    }

    public char getCh() {
        return ch;
    }

    @Override
    public String toString(){
        return getColor().getColor() + getCh()  + getColor().getReset();
    }
}
