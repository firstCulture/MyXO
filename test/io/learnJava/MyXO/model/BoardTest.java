import io.learnJava.MyXO.model.Figure;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void getSize() {
        final Board board = new Board();

        assertEquals(3, board.getSize());
    }

    @Test
    public void setFigure() {
        final Boadr board = new Board();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        board.setFigure(inputFigure, inputFigure);
        final Figure actualFigure = board.getFigure(inputFigure);

        assertEquals(inputFigure, actualFigure);

    }
}