package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class Knight extends ChessPiece {

    public Knight(ChessPieceColor color, Position position) {
        super("chess_knight_" + color.name()
                                     .toLowerCase() + ".png", position);
    }
}
