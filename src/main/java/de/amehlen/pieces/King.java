package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class King extends ChessPiece {

    public King(ChessPieceColor color) {
        super("chess_king_" + color.name()
                                   .toLowerCase() + ".png");
    }
}
