package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTests {
    @Test
    public void testWhiteRookMoveUnblocked(){

        Chessboard chessboard = new ChessboardImpl();
        Rook e2 = new Rook(Color.WHITE, new Square("d5"));
        assertTrue(e2.canMove(chessboard, new Square("d6")));
        assertTrue(e2.canMove(chessboard, new Square("a5")));
        assertTrue(e2.canMove(chessboard, new Square("h5")));
        assertTrue(e2.canMove(chessboard, new Square("d3")));
    }

    @Test
    public void testWhiteRookCanTakeOtherPiecesOfDifferentColor(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Rook d5 = new Rook(Color.WHITE, new Square("d5"));
        assertTrue(d5.canMove(chessboard, new Square("d7")));
        assertFalse(d5.canMove(chessboard, new Square("d2")));
    }
    @Test
    public void testRookCanNotJumpOverSameColorPieces(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Rook a1 = (Rook) chessboard.getPieceAt(new Square("a1"));
        assertFalse(a1.canMove(chessboard, new Square("a3")));
    }
}
