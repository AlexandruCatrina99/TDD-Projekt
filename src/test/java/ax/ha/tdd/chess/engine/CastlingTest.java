package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.Queen;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CastlingTest {
    @Test
    public void testCastling(){

        GameImpl game = new GameImpl();
        game.move("O-O-O");
        //pieces in between
        assertEquals(game.getLastMoveResult(),"O-O-O" + " left castling can not be done");
        game.getBoard().removePieceAt(new Square("b1"));
        game.getBoard().removePieceAt(new Square("c1"));
        game.getBoard().removePieceAt(new Square("d1"));
        game.move("O-O-O");
        //pieces in between
        assertEquals(game.getLastMoveResult(),"O-O-O" + " left castling");

    }
    @Test
    public void testCastlingIfKingCanBeTakenInBetweenSpacesItTravels(){

        GameImpl game = new GameImpl();
        game.move("O-O");
        //pieces in between
        assertEquals(game.getLastMoveResult(),"O-O" + " right castling can not be done");
        game.getBoard().removePieceAt(new Square("f1"));
        game.getBoard().removePieceAt(new Square("g1"));
        game.getBoard().addPiece(new Knight(Color.BLACK,new Square("e3")));


        game.move("O-O");
        //King kan be taken by the new knight at square f1 witch it will pass threw
        assertEquals(game.getLastMoveResult(),"O-O" + " right castling can not be done");

    }
}
