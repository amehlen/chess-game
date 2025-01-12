package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class Rook extends ChessPiece {

    public Rook(ChessPieceColor color) {
        super("chess_rook_" + color.name()
                                   .toLowerCase() + ".png");
    }
}
