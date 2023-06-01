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
        if (noMovesWasDoneForThisColor(this.color, chessboard)) {
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

    private boolean noMovesWasDoneForThisColor(Color color, Chessboard chessboard) {
        if (color.equals(Color.BLACK)) {
            if (chessboard.getPieceAt(new Square(0, 0)) == null || chessboard.getPieceAt(new Square(0, 0)).getType() != (PieceType.ROOK) || chessboard.getPieceAt(new Square(0, 0)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(1, 0)) == null || chessboard.getPieceAt(new Square(1, 0)).getType() != (PieceType.KNIGHT) || chessboard.getPieceAt(new Square(1, 0)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(2, 0)) == null || chessboard.getPieceAt(new Square(2, 0)).getType() != (PieceType.BISHOP) || chessboard.getPieceAt(new Square(2, 0)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(3, 0)) == null || chessboard.getPieceAt(new Square(3, 0)).getType() != (PieceType.QUEEN) || chessboard.getPieceAt(new Square(3, 0)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(4, 0)) == null || chessboard.getPieceAt(new Square(4, 0)).getType() != (PieceType.KING) || chessboard.getPieceAt(new Square(4, 0)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(5, 0)) == null || chessboard.getPieceAt(new Square(5, 0)).getType() != (PieceType.BISHOP) || chessboard.getPieceAt(new Square(5, 0)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(6, 0)) == null || chessboard.getPieceAt(new Square(6, 0)).getType() != (PieceType.KNIGHT) || chessboard.getPieceAt(new Square(6, 0)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(7, 0)) == null || chessboard.getPieceAt(new Square(7, 0)).getType() != (PieceType.ROOK) || chessboard.getPieceAt(new Square(7, 0)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(0, 1)) == null || chessboard.getPieceAt(new Square(0, 1)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(0, 1)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(1, 1)) == null || chessboard.getPieceAt(new Square(1, 1)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(1, 1)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(2, 1)) == null || chessboard.getPieceAt(new Square(2, 1)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(2, 1)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(3, 1)) == null || chessboard.getPieceAt(new Square(3, 1)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(3, 1)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(4, 1)) == null || chessboard.getPieceAt(new Square(4, 1)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(4, 1)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(5, 1)) == null || chessboard.getPieceAt(new Square(5, 1)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(5, 1)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(6, 1)) == null || chessboard.getPieceAt(new Square(6, 1)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(6, 1)).getColor() != Color.BLACK) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(7, 1)) == null || chessboard.getPieceAt(new Square(7, 1)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(7, 1)).getColor() != Color.BLACK) {
                return false;
            }

        } else {
            if (chessboard.getPieceAt(new Square(0, 7)) == null || chessboard.getPieceAt(new Square(0, 7)).getType() != (PieceType.ROOK) || chessboard.getPieceAt(new Square(0, 7)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(1, 7)) == null || chessboard.getPieceAt(new Square(1, 7)).getType() != (PieceType.KNIGHT) || chessboard.getPieceAt(new Square(1, 7)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(2, 7)) == null || chessboard.getPieceAt(new Square(2, 7)).getType() != (PieceType.BISHOP) || chessboard.getPieceAt(new Square(2, 7)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(3, 7)) == null || chessboard.getPieceAt(new Square(3, 7)).getType() != (PieceType.QUEEN) || chessboard.getPieceAt(new Square(3, 7)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(4, 7)) == null || chessboard.getPieceAt(new Square(4, 7)).getType() != (PieceType.KING) || chessboard.getPieceAt(new Square(4, 7)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(5, 7)) == null || chessboard.getPieceAt(new Square(5, 7)).getType() != (PieceType.BISHOP) || chessboard.getPieceAt(new Square(5, 7)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(6, 7)) == null || chessboard.getPieceAt(new Square(6, 7)).getType() != (PieceType.KNIGHT) || chessboard.getPieceAt(new Square(6, 7)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(7, 7)) == null || chessboard.getPieceAt(new Square(7, 7)).getType() != (PieceType.ROOK) || chessboard.getPieceAt(new Square(7, 7)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(0, 6)) == null || chessboard.getPieceAt(new Square(0, 6)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(0, 6)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(1, 6)) == null || chessboard.getPieceAt(new Square(1, 6)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(1, 6)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(2, 6)) == null || chessboard.getPieceAt(new Square(2, 6)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(2, 6)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(3, 6)) == null || chessboard.getPieceAt(new Square(3, 6)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(3, 6)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(4, 6)) == null || chessboard.getPieceAt(new Square(4, 6)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(4, 6)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(5, 6)) == null || chessboard.getPieceAt(new Square(5, 6)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(5, 6)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(6, 6)) == null || chessboard.getPieceAt(new Square(6, 6)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(6, 6)).getColor() != Color.WHITE) {
                return false;
            }
            if (chessboard.getPieceAt(new Square(7, 6)) == null || chessboard.getPieceAt(new Square(7, 6)).getType() != (PieceType.PAWN) || chessboard.getPieceAt(new Square(7, 6)).getColor() != Color.WHITE) {
                return false;
            }
        }
        return true;
    }
}
