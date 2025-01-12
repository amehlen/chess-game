package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class Pawn extends ChessPiece {

    public Pawn(ChessPieceColor color) {
        super("chess_pawn_" + color.name()
                                   .toLowerCase() + ".png");
    }
}
