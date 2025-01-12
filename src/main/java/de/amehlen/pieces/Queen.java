package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class Queen extends ChessPiece {

    public Queen(ChessPieceColor color) {
        super("chess_queen_" + color.name()
                                    .toLowerCase() + ".png");
    }
}
