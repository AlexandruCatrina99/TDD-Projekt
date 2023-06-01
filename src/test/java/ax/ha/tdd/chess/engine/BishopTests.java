package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Bishop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTests {
    @Test
    public void testBishopsMoves() {

        Chessboard chessboard = new ChessboardImpl();
        Bishop e4 = new Bishop(Color.WHITE, new Square("d5"));
        assertTrue(e4.canMove(chessboard, new Square("c6")));
        assertTrue(e4.canMove(chessboard, new Square("c4")));
        assertTrue(e4.canMove(chessboard, new Square("e6")));
    }

    @Test
    public void testBishopsTakeMoves() {
        Chessboard chessboard = ChessboardImpl.startingBoard();
        Bishop d5 = new Bishop(Color.WHITE, new Square("d5"));
        assertTrue(d5.canMove(chessboard, new Square("f7")));
        assertTrue(d5.canMove(chessboard, new Square("b7")));
        Bishop d3 = new Bishop(Color.WHITE, new Square("d3"));
        assertTrue(d3.canMove(chessboard, new Square("c4")));
        assertFalse(d3.canMove(chessboard, new Square("c1")));
    }
}
