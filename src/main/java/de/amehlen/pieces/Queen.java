package de.amehlen.pieces;

import de.amehlen.ChessPieceColor;

public class Queen extends ChessPiece {

    public Queen(ChessPieceColor color, Position position) {
        super("chess_queen_" + color.name()
                                    .toLowerCase() + ".png", position);
    }
}
