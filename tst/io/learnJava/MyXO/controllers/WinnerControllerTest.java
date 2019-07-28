package io.learnJava.MyXO.controllers;

import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(i, 0), Figure.X);
            board.setFigure(new Point(i, 1), Figure.X);
            board.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(i, 0), Figure.X);
            board.setFigure(new Point(i, 1), Figure.X);
            board.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow2() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(i, 0), Figure.O);
            board.setFigure(new Point(i, 1), Figure.X);
            board.setFigure(new Point(i, 2), Figure.X);
            assertNull(winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(0, i), Figure.X);
            board.setFigure(new Point(1, i), Figure.X);
            board.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(0, i), Figure.X);
            board.setFigure(new Point(1, i), Figure.X);
            board.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
            final Board board = new Board(3);
            board.setFigure(new Point(0, 0), Figure.X);
            board.setFigure(new Point(1, 1), Figure.X);
            board.setFigure(new Point(2, 2), Figure.X);
            assertEquals(Figure.X,  winnerController.getWinner(board));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
            final Board board = new Board(3);
            board.setFigure(new Point(0, 0), Figure.X);
            board.setFigure(new Point(1, 1), Figure.X);
            board.setFigure(new Point(2, 2), Figure.O);
            assertNull( winnerController.getWinner(board));
    }

    @Test
    public void testGetWinnerWhenWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
            final Board board = new Board(3);
            board.setFigure(new Point(0, 2), Figure.X);
            board.setFigure(new Point(1, 1), Figure.X);
            board.setFigure(new Point(2, 0), Figure.X);
            assertEquals(Figure.X,  winnerController.getWinner(board));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
            final Board board = new Board(3);
            board.setFigure(new Point(0, 2), Figure.X);
            board.setFigure(new Point(1, 1), Figure.X);
            board.setFigure(new Point(2, 0), Figure.O);
            assertNull( winnerController.getWinner(board));
    }


}