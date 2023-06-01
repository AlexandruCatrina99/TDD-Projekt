package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurnTests {
    @Test
    public void testTurns() {

        GameImpl game = new GameImpl();
        assertEquals(game.turn,Color.WHITE);
        game.move("a2-a4");
        assertEquals(game.turn,Color.BLACK);

    }
}
