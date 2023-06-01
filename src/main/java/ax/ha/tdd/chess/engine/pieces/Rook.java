package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;

public class Rook extends ChessPieceBase implements ChessPiece{
    public Rook( Color player, Square location) {
        super(PieceType.ROOK, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        for (Square s : availableMoves(chessboard)
        ) {
            if (s.equals(destination)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Square> availableMoves(Chessboard chessboard){
        ArrayList<Square> availableMoves = new ArrayList<>();
        //Go left
        for (int i = this.location.getX(); i>=0; i--){
            if (chessboard.getPieceAt(new Square(i, location.getY())) == null){
                availableMoves.add(new Square(i, location.getY()));
                continue;
            } else if (!chessboard.getPieceAt(new Square(i, location.getY())).getColor().equals(this.color)) {
                availableMoves.add(new Square(i, location.getY()));
                break;
            }
            break;
        }

        //Go right
        for (int i = this.location.getX(); i<=7; i++){
            if (chessboard.getPieceAt(new Square(i, location.getY())) == null){
                availableMoves.add(new Square(i, location.getY()));
                continue;
            } else if (!chessboard.getPieceAt(new Square(i, location.getY())).getColor().equals(this.color)) {
                availableMoves.add(new Square(i, location.getY()));
                break;
            }
            break;
        }
        //Go upp
        for (int i = this.location.getY(); i>=0; i--){
            if (chessboard.getPieceAt(new Square( location.getX(),i)) == null){
                availableMoves.add(new Square( location.getX(),i));
                continue;
            } else if (!chessboard.getPieceAt(new Square( location.getX(),i)).getColor().equals(this.color)) {
                availableMoves.add(new Square( location.getX(),i));
                break;
            }
            break;
        }
        //Go upp
        for (int i = this.location.getY(); i<=7; i++){
            if (chessboard.getPieceAt(new Square( location.getX(),i)) == null){
                availableMoves.add(new Square( location.getX(),i));
                continue;
            } else if (!chessboard.getPieceAt(new Square( location.getX(),i)).getColor().equals(this.color)) {
                availableMoves.add(new Square( location.getX(),i));
                break;
            }
            break;
        }
        return availableMoves;
    }
}
