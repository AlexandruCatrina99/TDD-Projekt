package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;

public class Pawn extends ChessPieceBase implements ChessPiece {

    public Pawn(Color player, Square location) {
        super(PieceType.PAWN, player, location);
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

    private ArrayList<Square> availableMoves(Chessboard chessboard) {
        ArrayList<Square> availableMoves = new ArrayList<>();
        if (noMovesWasDoneForThisPawn(this.color)) {
            if (this.color == Color.BLACK) {
                availableMoves.add(new Square(this.location.getX(), this.location.getY() + 2));
            }
            if (this.color == Color.WHITE) {
                availableMoves.add(new Square(this.location.getX(), this.location.getY() - 2));
            }
        }
        if (this.color == Color.BLACK) {
            // Check if pawn can take something at left
            if (this.location.getX() != 0 && chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() + 1)) != null && chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() + 1)).getColor() == Color.WHITE) {
                availableMoves.add(new Square(this.location.getX() - 1, this.location.getY() + 1));
            }
            // Check if pawn can take something at right
            if (this.location.getX() != 7 && chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() + 1)) != null && chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() + 1)).getColor() == Color.WHITE) {
                availableMoves.add(new Square(this.location.getX() + 1, this.location.getY() + 1));
            }
            if (this.location.getY() != 7 && chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() + 1)) == null) {
                availableMoves.add(new Square(this.location.getX(), this.location.getY() + 1));
            }
        }
        if (this.color == Color.WHITE) {
            // Check if pawn can take something at left
            if (this.location.getX() != 0 && chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() - 1)) != null && chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() - 1)).getColor() == Color.BLACK) {
                availableMoves.add(new Square(this.location.getX() - 1, this.location.getY() - 1));
            }
            // Check if pawn can take something at right
            if (this.location.getX() != 7 && chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() - 1)) != null && chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() - 1)).getColor() == Color.BLACK) {
                availableMoves.add(new Square(this.location.getX() + 1, this.location.getY() - 1));
            }
            if (this.location.getY() != 0 && chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() - 1)) == null) {
                availableMoves.add(new Square(this.location.getX(), this.location.getY() - 1));
            }
        }
        return availableMoves;
    }

    private boolean noMovesWasDoneForThisPawn(Color color) {
        if (color.equals(Color.BLACK) && this.location.getY() == 1) {
            return true;
        } else return color.equals(Color.WHITE) && this.location.getY() == 6;
    }
}
