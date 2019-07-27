package io.learnJava.MyXO.model;


public class Game {

    private final Player[] player;

    private final Board board;

    private final String gameName;

    public Game(final Player[] player,
                final Board board,
                final String gameName) {
        this.player = player;
        this.board = board;
        this.gameName = gameName;
    }

    public Player[] getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

    public String getGameName() {
        return gameName;
    }

}
