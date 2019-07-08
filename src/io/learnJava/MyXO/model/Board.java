package io.learnJava.MyXO.model;

import io.learnJava.MyXO.model.exceptions.AlreadyOccupiedException;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;

import java.awt.*;

public class Board {

    private static final int FIELD_SIZE = 3;

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] board = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointerException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointerException();
        }
        if (board[point.x][point.y] != null) {
            throw new AlreadyOccupiedException();
        }
        return board[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) {
        board[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }


}

