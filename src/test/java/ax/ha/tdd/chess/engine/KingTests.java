package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTests {
    @Test
    public void testWhiteKingMoves(){

        Chessboard chessboard = new ChessboardImpl();
        King d5 = new King(Color.WHITE, new Square("d5"));
        assertTrue(d5.canMove(chessboard, new Square("d6")));
        assertTrue(d5.canMove(chessboard, new Square("d4")));
        assertTrue(d5.canMove(chessboard, new Square("e5")));
        assertTrue(d5.canMove(chessboard, new Square("c5")));
        assertTrue(d5.canMove(chessboard, new Square("e4")));
        assertTrue(d5.canMove(chessboard, new Square("e6")));
        assertTrue(d5.canMove(chessboard, new Square("c4")));
        assertTrue(d5.canMove(chessboard, new Square("c6")));

    }

    @Test
    public void testWhiteKingCanTakeOtherPiecesOfDifferentColor(){
        Chessboard chessboard =  ChessboardImpl.startingBoard();
        King d6 = new King(Color.WHITE, new Square("d6"));
        King d3 = new King(Color.WHITE, new Square("d3"));
        assertTrue(d6.canMove(chessboard, new Square("d7")));
        assertTrue(d6.canMove(chessboard, new Square("c7")));
        assertTrue(d6.canMove(chessboard, new Square("e7")));
        assertFalse(d3.canMove(chessboard, new Square("d2")));
        assertFalse(d3.canMove(chessboard, new Square("e2")));
        assertFalse(d3.canMove(chessboard, new Square("c2")));
    }
}
