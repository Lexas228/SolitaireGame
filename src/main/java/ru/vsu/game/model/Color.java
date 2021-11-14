package ru.vsu.game.model;

public enum Color {
    Black("\033[0;30m"),
    Red("\033[0;31m");

    private final String color;
    private final String reset;

    Color(String color) {
        this.color = color;
        this.reset =  "\033[0m";
    }

    public String getColor() {
        return color;
    }

    public String getReset() {
        return reset;
    }
}
