package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class ChessPieceFactory {

    private ChessPieceFactory() {
    }

    public static ChessPiece createPiece(char pieceSymbol) {
        ChessPieceColor color = Character.isUpperCase(pieceSymbol) ? ChessPieceColor.WHITE : ChessPieceColor.BLACK;
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