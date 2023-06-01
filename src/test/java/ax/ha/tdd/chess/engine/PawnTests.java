package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTests {

    @Test
    public void testMoveMoreThanTwoSquaresAtStartShouldBeIllegal(){
        //Arrange
        Game game = new GameImpl();

        //Act
        game.move("e2-e5"); //if you use real chess notation in your implementation, use simply "e5"

        //Assert
        assertEquals(Color.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e2"));
        assertEquals(Color.WHITE, piece.getColor());
        assertEquals(PieceType.PAWN, piece.getType());


        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(game.getBoard()));

    }

    @Test
    public void testWhitePawnForwardOneStepUnblocked(){

        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Color.WHITE, new Square("e2"));
        assertTrue(e2.canMove(chessboard, new Square("e3")));
    }

    @Test
    public void testWhitePawnForward2StepUnblockedASFristMove(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Pawn e2 = new Pawn(Color.WHITE, new Square("e2"));
        assertTrue(e2.canMove(chessboard, new Square("e4")));
    }

    @Test
    public void testBlackPawnForwardOneStepUnblocked(){

        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Color.BLACK, new Square("e7"));
        assertTrue(e2.canMove(chessboard, new Square("e6")));
    }

    @Test
    public void testBlackPawnForward2StepUnblockedASFristMove(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Pawn e2 = new Pawn(Color.BLACK, new Square("a7"));
        assertTrue(e2.canMove(chessboard, new Square("a5")));
    }
    @Test
    public void testDiagonalMoveNotWorkingIfEmptySquare(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Pawn e2 = new Pawn(Color.WHITE, new Square("e2"));
        assertFalse(e2.canMove(chessboard, new Square("f3")));
    }

    @Test
    public void testPawnCanTakeDiagonally(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Pawn e2 = new Pawn(Color.WHITE, new Square("e6"));
        assertTrue(e2.canMove(chessboard, new Square("f7")));
    }
    @Test
    public void testPawnCanNotTakeDiagonallySameColor(){

        Chessboard chessboard =  ChessboardImpl.startingBoard();
        Pawn e2 = new Pawn(Color.BLACK, new Square("e6"));
        assertFalse(e2.canMove(chessboard, new Square("f7")));
    }
}
