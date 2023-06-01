package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;

public class Bishop extends ChessPieceBase implements ChessPiece {
    public Bishop(Color player, Square location) {
        super(PieceType.BISHOP, player, location);
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
        if (this.location.getX() <= 6 && this.location.getY() <= 6) {
            int x = this.location.getX();
            int y = this.location.getY();
            Square nextMoveRightDown = new Square(x, y);
            while (chessboard.getPieceAt(nextMoveRightDown) == null) {
                x++;
                y++;
                if (x < 8 && y < 8) {
                    if (chessboard.getPieceAt(new Square(x, y)) == null || chessboard.getPieceAt(new Square(x, y)).getColor() != this.getColor()) {
                        nextMoveRightDown = new Square(x, y);
                        availableMoves.add(nextMoveRightDown);
                    }

                } else break;
            }
        }
        if (this.location.getX() <= 6 && this.location.getY() >= 1) {
            int x = this.location.getX();
            int y = this.location.getY();
            Square nextMoveRightUp = new Square(x, y);
            while (chessboard.getPieceAt(nextMoveRightUp) == null) {
                x++;
                y--;
                if (x < 8 && y >= 0) {
                    if (chessboard.getPieceAt(new Square(x, y)) == null || chessboard.getPieceAt(new Square(x, y)).getColor() != this.getColor()) {
                        nextMoveRightUp = new Square(x, y);
                        availableMoves.add(nextMoveRightUp);
                    }

                } else break;
            }
        }
        if (this.location.getX() >= 1 && this.location.getY() >= 1) {
            int x = this.location.getX();
            int y = this.location.getY();
            Square nextMoveLeftUp = new Square(x, y);
            while (chessboard.getPieceAt(nextMoveLeftUp) == null) {
                x--;
                y--;
                if (x >= 0 && y >= 0) {
                    if (chessboard.getPieceAt(new Square(x, y)) == null || chessboard.getPieceAt(new Square(x, y)).getColor() != this.getColor()) {
                        nextMoveLeftUp = new Square(x, y);
                        availableMoves.add(nextMoveLeftUp);
                    }

                } else break;
            }
        }
        if (this.location.getX() >= 1 && this.location.getY() <= 6) {
            int x = this.location.getX();
            int y = this.location.getY();
            Square nextMoveLeftDown = new Square(x, y);
            while (chessboard.getPieceAt(nextMoveLeftDown) == null) {
                x--;
                y++;
                if (x >= 0 && y < 8) {
                    if (chessboard.getPieceAt(new Square(x, y)) == null || chessboard.getPieceAt(new Square(x, y)).getColor() != this.getColor()) {
                        nextMoveLeftDown = new Square(x, y);
                        availableMoves.add(nextMoveLeftDown);
                    }

                } else break;
            }
        }
        return availableMoves;
    }
}
