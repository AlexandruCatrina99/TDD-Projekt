package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTests {
    @Test
    public void testWhiteRookMoveUnblocked(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard = new ChessboardImpl();
        Rook e2 = new Rook(Color.WHITE, new Square("d5"));
        assertTrue(e2.canMove(chessboard, new Square("d6")));
        assertTrue(e2.canMove(chessboard, new Square("a5")));
        assertTrue(e2.canMove(chessboard, new Square("h5")));
        assertTrue(e2.canMove(chessboard, new Square("d3")));
    }

    @Test
    public void testWhiteRookCanTakeOtherPiecesOfDifferentColor(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Rook e2 = new Rook(Color.WHITE, new Square("d5"));
        assertTrue(e2.canMove(chessboard, new Square("d7")));
        assertFalse(e2.canMove(chessboard, new Square("d2")));
    }
}
