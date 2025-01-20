package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class Rook extends ChessPiece {

    public Rook(ChessPieceColor color, Position position) {
        super("chess_rook_" + color.name()
                                   .toLowerCase() + ".png", position);
    }
}
