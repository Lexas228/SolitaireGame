package ru.vsu.game.model;

public enum CardCost {
    Jack("J", 11),
    Queen("Q", 12),
    King("K", 13),
    Ace("T", 1),
    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Fife("5", 5),
    Six("6", 6),
    Seven("7", 7),
    Eight("8", 8),
    Nine("9", 9),
    Ten("10", 10);

    private final String name;
    private final int cost;

    CardCost(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
