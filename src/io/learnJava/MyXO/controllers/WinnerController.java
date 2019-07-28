package io.learnJava.MyXO.controllers;


import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Board board) throws InvalidPointerException {

        for (int i = 0; i < 3; i++) {
            if (check(board, new Point(i,0), p -> new Point(p.x, p.y + 1))) {
                return board.getFigure(new Point(i, 0));
            }
        }
        for (int i = 0; i < 3; i++) {
            if (check(board, new Point(0, i),  p -> new Point(p.x + 1, p.y))) {
                return board.getFigure(new Point(0, i));
            }
        }
        if (check(board, new Point(0, 0),  p -> new Point(p.x + 1, p.y + 1))) {
            return board.getFigure(new Point(0, 0));
        }
        if (check(board, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))) {
            return board.getFigure(new Point(0, 2));
        }
        return null;
    }

    private boolean check(final Board board,
                          final Point currentPoint,
                          final IPointerGenerator pointerGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointerGenerator.next(currentPoint);
        try {
            currentFigure = board.getFigure(currentPoint);

            if (currentFigure == null)
                return false;

            nextFigure = board.getFigure(nextPoint);
        } catch (final InvalidPointerException e) {
            return true;
        }

        if (currentFigure != nextFigure) return false;

        return check(board, nextPoint, pointerGenerator);
    }

    private interface IPointerGenerator {

        Point next(final Point point);
    }

}
