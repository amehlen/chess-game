package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class King extends ChessPiece {

    public King(ChessPieceColor color, Position position) {
        super("chess_king_" + color.name()
                                   .toLowerCase() + ".png", position);
    }
}
