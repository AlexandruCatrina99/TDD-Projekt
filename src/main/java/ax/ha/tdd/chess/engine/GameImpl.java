package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;

import java.util.ArrayList;
import java.util.Objects;

public class GameImpl implements Game {

    final ChessboardImpl board = ChessboardImpl.startingBoard();

    boolean isGameDone = false;
    String lastMove = "New game";
    Color turn = Color.WHITE;
    boolean hasRightWhiteRookMoved = false;
    boolean hasLeftWhiteRookMoved = false;
    boolean hasWhiteKingMoved = false;
    boolean hasRightBlackRookMoved = false;
    boolean hasLeftBlackRookMoved = false;
    boolean hasBlackKingMoved = false;


    @Override
    public Color getPlayerToMove() {
        return this.turn;
    }

    @Override
    public Chessboard getBoard() {
        return board;
    }

    @Override
    public String getLastMoveResult() {
        return this.lastMove;
    }

    @Override
    public void move(String move) {
        if (!isGameDone) {
            if (Objects.equals(move, "O-O")) {
                if (this.turn == Color.WHITE && !hasWhiteKingMoved && !hasRightWhiteRookMoved) {
                    King king = new King(Color.WHITE, new Square(7, 7));
                    Rook rook = new Rook(Color.WHITE, new Square(4, 7));
                    this.board.addPiece(king);
                    this.board.addPiece(rook);
                    hasWhiteKingMoved = true;
                    hasRightWhiteRookMoved = true;
                    lastMove = move + " right castling";
                    endTurn();
                } else if (this.turn == Color.BLACK && !hasBlackKingMoved && !hasRightBlackRookMoved) {
                    King king = new King(Color.BLACK, new Square(7, 0));
                    Rook rook = new Rook(Color.BLACK, new Square(4, 0));
                    this.board.addPiece(king);
                    this.board.addPiece(rook);
                    hasBlackKingMoved = true;
                    hasRightBlackRookMoved = true;
                    lastMove = move + " right castling";
                    endTurn();
                } else {
                    lastMove = move + " right castling can not be done";
                }

            } else if (Objects.equals(move, "O-O-O")) {
                if (this.turn == Color.WHITE && !hasWhiteKingMoved && !hasLeftWhiteRookMoved) {
                    King king = new King(Color.WHITE, new Square(0, 7));
                    Rook rook = new Rook(Color.WHITE, new Square(4, 7));
                    this.board.addPiece(king);
                    this.board.addPiece(rook);
                    hasWhiteKingMoved = true;
                    hasLeftWhiteRookMoved = true;
                    lastMove = move + " left castling";
                    endTurn();

                } else if (this.turn == Color.BLACK && !hasBlackKingMoved && !hasLeftBlackRookMoved) {
                    King king = new King(Color.BLACK, new Square(0, 0));
                    Rook rook = new Rook(Color.BLACK, new Square(4, 0));
                    this.board.addPiece(king);
                    this.board.addPiece(rook);
                    hasBlackKingMoved = true;
                    hasLeftBlackRookMoved = true;
                    lastMove = move + " left castling";
                    endTurn();
                } else {
                    lastMove = move + " left castling can not be done";
                }

            } else if (move.matches("[a-z][1-9]-[a-z][1-9]")) {
                String position = move.substring(0, 2);
                String destination = move.substring(3);
                Square piecePosition = new Square(position);
                Square destinationPosition = new Square(destination);
                if (position.equals(destination)) {
                    this.lastMove = "Destination can not be the same as the piece";
                } else if (board.getPieceAt(piecePosition) != null && isOwnPiece(piecePosition)) {

                    ChessPiece pieceToMove = board.getPieceAt(piecePosition);
                    if (isSchack()) {
                        if (isSchackMatt(board, (King) board.getPieceAt(Objects.requireNonNull(findMyKing())))) {
                            endTurn();
                            this.lastMove = "SCHACKMATT: " + this.turn.name() + " WON!";
                            this.isGameDone = true;
                        } else if (pieceToMove.getType() != PieceType.KING) {
                            this.lastMove = "You need to move your King out of the way";
                        } else if (pieceToMove.getType() == PieceType.KING && pieceToMove.canMove(board, destinationPosition)) {
                            if (canOpponentTakeHere(destinationPosition)) {
                                this.lastMove = "Not a good choice, think again! Don't lose the KING";
                            } else {
                                switch (this.turn) {
                                    case WHITE -> hasWhiteKingMoved = true;
                                    case BLACK -> hasBlackKingMoved = true;

                                }
                                board.addPiece(new King(this.turn, destinationPosition));
                                board.removePieceAt(piecePosition);
                                endTurn();
                            }
                        }

                    } else {
                        if (pieceToMove.canMove(board, destinationPosition)) {
                            if (board.getPieceAt(destinationPosition) != null && board.getPieceAt(destinationPosition).getType() == PieceType.KING) {
                                this.lastMove = "Cant take the King at: " + destination;
                            } else if (board.getPieceAt(piecePosition).getType() == PieceType.ROOK) {
                                if (pieceToMove.getLocation().getX() == 0) {
                                    switch (this.turn) {
                                        case WHITE -> hasLeftWhiteRookMoved = true;
                                        case BLACK -> hasLeftBlackRookMoved = true;
                                    }
                                } else if (pieceToMove.getLocation().getX() == 7) {
                                    switch (this.turn) {
                                        case WHITE -> hasRightWhiteRookMoved = true;
                                        case BLACK -> hasRightBlackRookMoved = true;
                                    }
                                }
                                board.addPiece(new Rook(this.turn, destinationPosition));
                                board.removePieceAt(piecePosition);
                                endTurn();
                            } else if (board.getPieceAt(piecePosition).getType() == PieceType.KING) {
                                if (!canOpponentTakeHere(destinationPosition)) {
                                    switch (this.turn) {
                                        case WHITE -> hasWhiteKingMoved = true;
                                        case BLACK -> hasBlackKingMoved = true;
                                    }
                                    board.addPiece(new King(this.turn, destinationPosition));
                                    board.removePieceAt(piecePosition);
                                    endTurn();
                                } else {
                                    this.lastMove = "Can't go there with the KING, think again!";
                                }
                            } else {
                                switch (board.getPieceAt(piecePosition).getType()) {
                                    case QUEEN -> board.addPiece(new Queen(this.turn, destinationPosition));
                                    case BISHOP -> board.addPiece(new Bishop(this.turn, destinationPosition));
                                    case KNIGHT -> board.addPiece(new Knight(this.turn, destinationPosition));
                                    case PAWN -> board.addPiece(new Pawn(this.turn, destinationPosition));
                                }
                                board.removePieceAt(piecePosition);
                                this.lastMove = move;
                                endTurn();
                            }

                        } else {
                            this.lastMove = "Can't move there";
                        }
                    }


                } else {
                    this.lastMove = "Can't move that";
                }

            } else {
                this.lastMove = "Invalid input";
            }

        }
    }

    private void endTurn() {
        if (Objects.requireNonNull(this.turn) == Color.WHITE) {
            this.turn = Color.BLACK;
        } else {
            this.turn = Color.WHITE;
        }
    }

    private boolean isOwnPiece(Square position) {
        return board.getPieceAt(position).getColor() == this.turn;
    }

    private ArrayList<ChessPiece> getAllOpponentPieces() {
        ArrayList<ChessPiece> pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.board.getPieceAt(new Square(i, j)) != null && this.board.getPieceAt(new Square(i, j)).getColor() != this.turn) {
                    pieces.add(this.board.getPieceAt(new Square(i, j)));
                }
            }
        }
        return pieces;
    }

    private boolean canOpponentTakeHere(Square square) {
        ArrayList<ChessPiece> pieces = getAllOpponentPieces();
        for (ChessPiece p : pieces
        ) {
            if (p.canMove(this.board, square)) {
                return true;
            }

        }
        return false;
    }

    public Square findMyKing() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.board.getPieceAt(new Square(i, j)) != null && this.board.getPieceAt(new Square(i, j)).getColor() == this.turn && this.board.getPieceAt(new Square(i, j)).getType() == PieceType.KING) {
                    return new Square(i, j);
                }
            }
        }
        return null;
    }

    public boolean isSchack() {
        Square kingPosition = findMyKing();
        return canOpponentTakeHere(kingPosition);
    }

    boolean isSchackMatt(Chessboard board, King king) {

        ArrayList<Square> whereCanKingMove = king.availableMoves(board);
        for (Square s : whereCanKingMove
        ) {
            if (!canOpponentTakeHere(s)) return false;

        }
        return true;
    }
}
