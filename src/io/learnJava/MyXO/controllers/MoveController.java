package io.learnJava.MyXO.controllers;


import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.exceptions.AlreadyOccupiedException;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Board board,
                            final Point point,
                            final Figure figure) throws InvalidPointerException, AlreadyOccupiedException {

        if (board.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        } else {
            board.setFigure(point, figure);
        }
    }

}
