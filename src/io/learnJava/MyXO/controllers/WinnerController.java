package io.learnJava.MyXO.controllers;


import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Board board) throws InvalidPointerException {

        if (board.getFigure(new Point(0, 0)) == board.getFigure(new Point(0, 1)) &&
                board.getFigure(new Point(0, 0)) == board.getFigure(new Point(0, 2))) {
            return board.getFigure(new Point(0, 0));

        } else if (board.getFigure(new Point(1, 0)) == board.getFigure(new Point(1, 1)) &&
                board.getFigure(new Point(1, 0)) == board.getFigure(new Point(1, 2))) {
            return board.getFigure(new Point(1, 0));

        }  else if (board.getFigure(new Point(2, 0)) == board.getFigure(new Point(2, 1)) &&
                board.getFigure(new Point(2, 0)) == board.getFigure(new Point(2, 2))) {
            return board.getFigure(new Point(2, 0));

        } else  if (board.getFigure(new Point(0, 0)) == board.getFigure(new Point(1, 1)) &&
                board.getFigure(new Point(0, 0)) == board.getFigure(new Point(2, 2))){
            return board.getFigure(new Point(0, 0));

        } else  if (board.getFigure(new Point(2, 0)) == board.getFigure(new Point(1, 1)) &&
                board.getFigure(new Point(2, 0)) == board.getFigure(new Point(0, 2))) {
            return board.getFigure(new Point(2, 0));
        }

        return null;
    }

    private boolean check(Board boadr, final Point p1, final Point p2,  final Point p3) throws InvalidPointerException {

        if (boadr.getFigure(p1) == null) return false;


        
    }




}
