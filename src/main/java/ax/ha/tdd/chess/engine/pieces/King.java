package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;

public class King extends ChessPieceBase implements ChessPiece {
    public King(Color player, Square location) {
        super(PieceType.KING, player, location);
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
        if (this.location.getX() > 0) {
            if (this.location.getY() < 7 && (chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() + 1)) == null || chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() + 1)).getColor() != this.color)) {
                availableMoves.add(new Square(this.location.getX() - 1, this.location.getY() + 1));
            }
            if (chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY())) == null || chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY())).getColor() != this.color) {
                availableMoves.add(new Square(this.location.getX() - 1, this.location.getY()));
            }
            if (this.location.getY() > 0 && (chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() - 1)) == null || chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() - 1)).getColor() != this.color)) {
                availableMoves.add(new Square(this.location.getX() - 1, this.location.getY() - 1));
            }
        }
        if (this.location.getX() < 7) {
            if (this.location.getY() < 7 && (chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() + 1)) == null || chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() + 1)).getColor() != this.color)) {
                availableMoves.add(new Square(this.location.getX() + 1, this.location.getY() + 1));
            }
            if (chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY())) == null || chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY())).getColor() != this.color) {
                availableMoves.add(new Square(this.location.getX() + 1, this.location.getY()));
            }
            if (this.location.getY() > 0 && (chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() - 1)) == null || chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() - 1)).getColor() != this.color)) {
                availableMoves.add(new Square(this.location.getX() + 1, this.location.getY() - 1));
            }
        }
        if (this.location.getY() < 7 && (chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() + 1)) == null || chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() + 1)).getColor() != this.color)) {
            availableMoves.add(new Square(this.location.getX(), this.location.getY() + 1));
        }
        if (this.location.getY() > 0 && (chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() - 1)) == null || chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() - 1)).getColor() != this.color)) {
            availableMoves.add(new Square(this.location.getX(), this.location.getY() - 1));
        }
        return availableMoves;
    }
}
