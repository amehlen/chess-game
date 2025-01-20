package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class ChessPieceFactory {

    private ChessPieceFactory() {
    }

    public static ChessPiece createPiece(char pieceSymbol, Position position) {
        ChessPieceColor color = Character.isUpperCase(pieceSymbol) ? ChessPieceColor.WHITE : ChessPieceColor.BLACK;
        return switch (Character.toLowerCase(pieceSymbol)) {
            case 'b' -> new Bishop(color, position);
            case 'k' -> new King(color, position);
            case 'n' -> new Knight(color, position);
            case 'p' -> new Pawn(color, position);
            case 'q' -> new Queen(color, position);
            case 'r' -> new Rook(color, position);
            default -> throw new IllegalArgumentException("Unknown chess piece: " + pieceSymbol);
        };
    }
}