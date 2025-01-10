package de.amehlen.pieces;

public class ChessPieceFactory {

    private static final String WHITE_PIECE = "white";
    private static final String BLACK_PIECE = "black";

    private ChessPieceFactory() {
    }

    public static ChessPiece createPiece(char pieceSymbol) {
        String color = Character.isUpperCase(pieceSymbol) ? WHITE_PIECE : BLACK_PIECE;
        return switch (Character.toLowerCase(pieceSymbol)) {
            case 'b' -> new Bishop(color);
            case 'k' -> new King(color);
            case 'n' -> new Knight(color);
            case 'p' -> new Pawn(color);
            case 'q' -> new Queen(color);
            case 'r' -> new Rook(color);
            default -> throw new IllegalArgumentException("Unknown chess piece: " + pieceSymbol);
        };
    }
}