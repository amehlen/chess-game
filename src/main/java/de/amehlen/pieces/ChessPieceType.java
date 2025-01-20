package de.amehlen.pieces;

public enum ChessPieceType {

    BISHOP("bishop"),
    KING("king"),
    KNIGHT("knight"),
    PAWN("pawn"),
    QUEEN("queen"),
    ROOK("rook");

    private final String displayName;

    ChessPieceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
