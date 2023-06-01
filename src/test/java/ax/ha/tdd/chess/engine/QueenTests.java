package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Queen;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTests {
    @Test
    public void testWhiteQueenMoveUnblocked(){

        Chessboard chessboard = new ChessboardImpl();
        Queen d5 = new Queen(Color.WHITE, new Square("d5"));
        assertTrue(d5.canMove(chessboard, new Square("d6")));
        assertTrue(d5.canMove(chessboard, new Square("a5")));
        assertTrue(d5.canMove(chessboard, new Square("h5")));
        assertTrue(d5.canMove(chessboard, new Square("d3")));
        assertTrue(d5.canMove(chessboard, new Square("c6")));
        assertTrue(d5.canMove(chessboard, new Square("c4")));
        assertTrue(d5.canMove(chessboard, new Square("e6")));
    }
    @Test
    public void testWhiteQueenCanTakeOtherPiecesOfDifferentColor(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Queen d5 = new Queen(Color.WHITE, new Square("d5"));
        assertTrue(d5.canMove(chessboard, new Square("d7")));
        assertFalse(d5.canMove(chessboard, new Square("d2")));
        assertTrue(d5.canMove(chessboard, new Square("f7")));
        assertFalse(d5.canMove(chessboard, new Square("e7")));
    }
}

