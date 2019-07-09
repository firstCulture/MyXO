package io.learnJava.MyXO.model;


public class Game {

    private final Player[] player;

    private final Board board;

    private final String name;

    public Game(final Player[] player,
                final Board board,
                final String name) {
        this.player = player;
        this.board = board;
        this.name = name;
    }

    public Player[] getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

}
