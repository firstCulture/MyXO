package io.learnJava.MyXO.controllers;


import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Board board) throws InvalidPointerException {

        for (int i = 0; i < 3; i++) {
            if (check(board, new Point(i, 0), new Point(i, 1), new Point(i, 2))) {
                return board.getFigure(new Point(i, 0));
            }
        }
        for (int i = 0; i < 3; i++) {
            if (check(board, new Point(0, i), new Point(1, i), new Point(2, i))) {
                return board.getFigure(new Point(0, i));
            }
        }
        if (check(board, new Point(0, 0), new Point(1, 1), new Point(2, 2))) {
            return board.getFigure(new Point(0, 0));
        }
        if (check(board, new Point(0, 2), new Point(1, 1), new Point(2, 0))) {
            return board.getFigure(new Point(1, 1));
        }
        return null;
    }

    private boolean check(Board board, final Point p1, final Point p2, final Point p3) throws InvalidPointerException {

        if (board.getFigure(p1) == null) {
            return false;
        } else if (board.getFigure(p1) == board.getFigure(p2) &&
                board.getFigure(p1) == board.getFigure(p3)) {
            return true;
        }
        return false;
    }

}
