package io.learnJava.MyXO.view;

import io.learnJava.MyXO.controllers.CurrentMoveController;
import io.learnJava.MyXO.controllers.MoveController;
import io.learnJava.MyXO.controllers.WinnerController;
import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.Game;
import io.learnJava.MyXO.model.exceptions.AlreadyOccupiedException;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;

import java.awt.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();

    private WinnerController winnerController = new WinnerController();

    private MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getGameName());
        final Board board = game.getBoard();
        for (int x = 0; x < board.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(board, x);
        }
    }

    public void printLine(final Board board, final int x) {

        for (int y = 0; y < board.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = board.getFigure(new Point(y, x));
            } catch (final InvalidPointerException e) {
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    public void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

    public boolean move(final Game game) throws InvalidPointerException {
        final Board board = game.getBoard();
        final Figure winner = winnerController.getWinner(board);
       if (winner != null) {
           System.out.format("Winner is: %s\n", winner);
           return false;
       }
        final Figure currentFigure = currentMoveController.currentMove(board);
            if (currentFigure == null) {
                System.out.println("No winner and moves left!");
                return false;
            }
        System.out.format("Please enter move poit for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(board, point, currentFigure);
        } catch (final InvalidPointerException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String cordinateName) {

        Scanner scan = new Scanner(System.in);
        System.out.format("Please input %s: ", cordinateName);

        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("0_0 In an integer please!!!!");
            return askCoordinate(cordinateName);
        }
    }


}
