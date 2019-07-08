import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.exceptions.InvalidePointerException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testGetSize() throws Exception{
        final Board board = new Board();

        assertEquals(3, board.getSize());
    }

    @Test
    public void testSetFigure() throws Exception{
        final Board board = new Board();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        board.setFigure(inputFigure, inputFigure);
        final Figure actualFigure = board.getFigure(inputFigure);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception{
        final Board board = new Board();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = board.getFigure(inputFigure);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception{
        final Board board = new Board();
        final Point inputPoint = new Point(-1, 0);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch(InvalidePointerException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception{
        final Board board = new Board();
        final Point inputPoint = new Point(board.getSize() + 1, 0);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch(InvalidePointerException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception{
        final Board board = new Board();
        final Point inputPoint = new Point(0, board.getSize() + 1);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch(InvalidePointerException e) {}
    }









}
