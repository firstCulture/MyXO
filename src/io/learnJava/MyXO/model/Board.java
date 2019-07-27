package io.learnJava.MyXO.model;

import io.learnJava.MyXO.model.exceptions.InvalidPointerException;

import java.awt.*;

public class Board {

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] board;

    private final int boardSize;

    public Board(final int boardSize) {
        this.boardSize = boardSize;
        board = new Figure[boardSize][boardSize];

    }

    public int getSize() {
        return boardSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointerException {
        if (!checkPoint(point)) {
            throw new InvalidPointerException();
        }
        return board[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointerException {

        if (!checkPoint(point)) {
            throw new InvalidPointerException();
        }
        board[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, board.length) && checkCoordinate(point.y, board[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }


}

