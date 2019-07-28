package io.learnJava.MyXO.controllers;

import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenNextMoveIsO() throws InvalidPointerException {
        final CurrentMoveController currentMoveController= new CurrentMoveController();

        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(i, 0), Figure.X);
            board.setFigure(new Point(i, 1), Figure.O);
            board.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(board));
        }
    }

    @Test
    public void testCurrentMoveWhenNextMoveIsX() throws InvalidPointerException {
        final CurrentMoveController currentMoveController= new CurrentMoveController();

        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(i, 1), Figure.O);
            board.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, currentMoveController.currentMove(board));
        }
    }

    @Test
    public void testCurrentMoveWhenNoNextMove() throws InvalidPointerException {
        final CurrentMoveController currentMoveController= new CurrentMoveController();
            final Board board = new Board(3);
        board.setFigure(new Point(0, 0), Figure.X);
        board.setFigure(new Point(0, 1), Figure.O);
        board.setFigure(new Point(0, 2), Figure.X);
        board.setFigure(new Point(1, 0), Figure.X);
        board.setFigure(new Point(1, 1), Figure.O);
        board.setFigure(new Point(1, 2), Figure.X);
        board.setFigure(new Point(2, 0), Figure.X);
        board.setFigure(new Point(2, 1), Figure.O);
        board.setFigure(new Point(2, 2), Figure.X);
            assertNull(currentMoveController.currentMove(board));
    }
}