package io.learnJava.MyXO.controllers;

import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Board board) throws InvalidPointerException {
        int countFigures = 0;
        for (int x = 0; x < board.getSize(); x++) {
            countFigures += countFigureInTheRow(board, x);
        }

        if (countFigures == board.getSize() * board.getSize())
            return null;

        if (countFigures % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFigureInTheRow(final Board board, final int row) throws InvalidPointerException {
        int countFigures = 0;
        for (int x = 0; x < board.getSize(); x++) {
            if (board.getFigure(new Point(x, row)) != null) {
                countFigures++;
            }
        }
        return countFigures;
    }

}
