package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTests {

    @Test
    public void testKnightsMoves(){

        Chessboard chessboard = new ChessboardImpl();
        Knight e4 = new Knight(Color.WHITE, new Square("e4"));
        assertTrue(e4.canMove(chessboard, new Square("c5")));
        assertTrue(e4.canMove(chessboard, new Square("c3")));
        assertTrue(e4.canMove(chessboard, new Square("d6")));
        assertTrue(e4.canMove(chessboard, new Square("d2")));
        assertTrue(e4.canMove(chessboard, new Square("f6")));
        assertTrue(e4.canMove(chessboard, new Square("f2")));
        assertTrue(e4.canMove(chessboard, new Square("g5")));
        assertTrue(e4.canMove(chessboard, new Square("g3")));
        assertFalse(e4.canMove(chessboard, new Square("c4")));
        assertFalse(e4.canMove(chessboard, new Square("d3")));
        assertFalse(e4.canMove(chessboard, new Square("e2")));
        assertFalse(e4.canMove(chessboard, new Square("g4")));
    }
    @Test
    public void testKnightsTakeMove(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Knight e4 = new Knight(Color.WHITE, new Square("e5"));
        assertTrue(e4.canMove(chessboard, new Square("f7")));
        assertTrue(e4.canMove(chessboard, new Square("d7")));

    }
}
