package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;

public class Knight extends ChessPieceBase implements ChessPiece {

    public Knight(Color player, Square location) {
        super(PieceType.KNIGHT, player, location);
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
        if (this.location.getY() >= 2) {
            if (this.location.getX() <= 6 &&
                    (chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() - 2)) == null ||
                            chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() - 2)).getColor() != this.getColor())) {
                availableMoves.add(new Square(this.location.getX() + 1, this.location.getY() - 2));
            }
            if (this.location.getX() >= 1 &&
                    (chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() - 2)) == null ||
                            chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() - 2)).getColor() != this.getColor())) {
                availableMoves.add(new Square(this.location.getX() - 1, this.location.getY() - 2));
            }
        }
        if (this.location.getY() <= 5) {
            if (this.location.getX() <= 6 &&
                    (chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() + 2)) == null ||
                            chessboard.getPieceAt(new Square(this.location.getX() + 1, this.location.getY() + 2)).getColor() != this.getColor())) {
                availableMoves.add(new Square(this.location.getX() + 1, this.location.getY() + 2));
            }
            if (this.location.getX() >= 1 &&
                    (chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() + 2)) == null ||
                            chessboard.getPieceAt(new Square(this.location.getX() - 1, this.location.getY() + 2)).getColor() != this.getColor())) {
                availableMoves.add(new Square(this.location.getX() - 1, this.location.getY() + 2));
            }
        }
        if (this.location.getX() <= 5) {
            if (this.location.getY() <= 6 &&
                    (chessboard.getPieceAt(new Square(this.location.getX() + 2, this.location.getY() + 1)) == null ||
                            chessboard.getPieceAt(new Square(this.location.getX() + 2, this.location.getY() + 1)).getColor() != this.getColor())) {
                availableMoves.add(new Square(this.location.getX() + 2, this.location.getY() + 1));
            }
            if (this.location.getY() >= 1 &&
                    (chessboard.getPieceAt(new Square(this.location.getX() + 2, this.location.getY() - 1)) == null ||
                            chessboard.getPieceAt(new Square(this.location.getX() + 2, this.location.getY() - 1)).getColor() != this.getColor())) {
                availableMoves.add(new Square(this.location.getX() + 2, this.location.getY() - 1));
            }
        }
        if (this.location.getX() >= 2) {
            if (this.location.getY() <= 6 &&
                    (chessboard.getPieceAt(new Square(this.location.getX() - 2, this.location.getY() + 1)) == null ||
                            chessboard.getPieceAt(new Square(this.location.getX() - 2, this.location.getY() + 1)).getColor() != this.getColor())) {
                availableMoves.add(new Square(this.location.getX() - 2, this.location.getY() + 1));
            }
            if (this.location.getY() >= 1 &&
                    (chessboard.getPieceAt(new Square(this.location.getX() - 2, this.location.getY() - 1)) == null ||
                            chessboard.getPieceAt(new Square(this.location.getX() - 2, this.location.getY() - 1)).getColor() != this.getColor())) {
                availableMoves.add(new Square(this.location.getX() - 2, this.location.getY() - 1));

            }
        }
        return availableMoves;
    }
}
