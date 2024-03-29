import io.learnJava.MyXO.model.Figure;
import io.learnJava.MyXO.model.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlyerTest {

        @Test
        public void getName() {
            final String inputValue = "Alex";
            final String expectedValue = inputValue;

            final Player player = new Player(inputValue, null);

            final String actualValue = player.getName();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        public void getFigure() {
            final Figure inputValue = Figure.X;
            final Figure expectedValue = inputValue;

            final Player player = new Player(null , inputValue);

            final Figure actualValue = player.getFigure();

            assertEquals(expectedValue, actualValue);
        }
}
