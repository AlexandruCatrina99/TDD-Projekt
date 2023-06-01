package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.King;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchackTests {
    @Test
    public void testSchack() {

        GameImpl game = new GameImpl();
        game.move("d2-d3");
        game.move("e7-e6");
        game.move("e2-e3");
        game.move("h2-h3");
        game.move("f8-b4");
        assertTrue(game.isSchack());

    }
    @Test
    public void testSchackMatt() {

        GameImpl game = new GameImpl();
        game.move("d2-d3");
        game.move("e7-e6");
        game.move("h2-h3");
        game.move("f8-b4");
        assertTrue(game.isSchack());
        assertTrue(game.isSchackMatt(game.getBoard(), new King(Color.WHITE,new Square("e1"))));
        game.move("e2-e3");
        assertTrue(game.isGameDone);
        assertEquals(game.getLastMoveResult(),"SCHACKMATT: " + Color.BLACK.name() + " WON!");

    }


}
