package io.learnJava.MyXO.model;

import io.learnJava.MyXO.model.exceptions.AlreadyOccupiedException;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testGetSize() {
        final Board board = new Board(3);

        assertEquals(3, board.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Board board = new Board(3);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        board.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = board.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Board board = new Board(3);
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = board.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() {
        final Board board = new Board(3);
        final Point inputPoint = new Point(-1, 0);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch (InvalidPointerException e) {
        }
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() {
        final Board board = new Board(3);
        final Point inputPoint = new Point(board.getSize() + 1, 0);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch (InvalidPointerException e) {
        }
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() {
        final Board board = new Board(3);
        final Point inputPoint = new Point(0, board.getSize() + 1);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch (InvalidPointerException e) {
        }
    }

    @Test
    public void testGetFigureWhenAlreadyAccupied() throws AlreadyOccupiedException, InvalidPointerException {
        final Board board = new Board(3);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        board.setFigure(inputPoint, inputFigure);
        throw new AlreadyOccupiedException();
    }
}