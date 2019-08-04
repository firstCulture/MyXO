package io.learnJava.MyXO;

import io.learnJava.MyXO.model.Board;
import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.Game;
import io.learnJava.MyXO.model.Player;
import io.learnJava.MyXO.model.exceptions.AlreadyOccupiedException;
import io.learnJava.MyXO.model.exceptions.InvalidPointerException;
import io.learnJava.MyXO.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) throws InvalidPointerException {
        final String name1 = "Gleb";
        final String name2 = "Slava";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Board(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }




    }

}
