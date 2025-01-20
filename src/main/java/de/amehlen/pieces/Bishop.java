package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class Bishop extends ChessPiece {

    public Bishop(ChessPieceColor color, Position position) {
        super("chess_bishop_" + color.name()
                                     .toLowerCase() + ".png", position);
    }
}
