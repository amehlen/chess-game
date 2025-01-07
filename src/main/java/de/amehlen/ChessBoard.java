package de.amehlen;

import de.amehlen.pieces.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends GridPane {

    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;
    private static final Color SANDCASTLE_DARK = Color.rgb(184, 140, 75);
    private static final Color SANDCASTLE_LIGHT = Color.rgb(228, 193, 112);
    private static final String WHITE_PIECE = "white";
    private static final String BLACK_PIECE = "black";

    public ChessBoard() {
        drawChessBoard();
        placePieces();
    }

    private void drawChessBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                tile.setFill((row + col) % 2 == 0 ? SANDCASTLE_LIGHT : SANDCASTLE_DARK);
                this.add(tile, row, col);
            }
        }
    }

    private void placePieces() {
        for (int col = 0; col < BOARD_SIZE; col++) {
            this.add(new Pawn(WHITE_PIECE), col, 6); // White pawns
            this.add(new Pawn(BLACK_PIECE), col, 1); // Black pawns
        }

        // Rooks
        this.add(new Rook(BLACK_PIECE), 0,0);
        this.add(new Rook(WHITE_PIECE), 0,7);
        this.add(new Rook(BLACK_PIECE), 7,0);
        this.add(new Rook(WHITE_PIECE), 7,7);

        // Knight
        this.add(new Knight(BLACK_PIECE), 1,0);
        this.add(new Knight(WHITE_PIECE), 1,7);
        this.add(new Knight(BLACK_PIECE), 6,0);
        this.add(new Knight(WHITE_PIECE), 6,7);

        // Bishop
        this.add(new Bishop(BLACK_PIECE), 2,0);
        this.add(new Bishop(WHITE_PIECE), 2,7);
        this.add(new Bishop(BLACK_PIECE), 5,0);
        this.add(new Bishop(WHITE_PIECE), 5,7);

        // King
        this.add(new King(BLACK_PIECE), 4,0);
        this.add(new King(WHITE_PIECE), 4,7);

        // Queen
        this.add(new Queen(BLACK_PIECE), 3,0);
        this.add(new Queen(WHITE_PIECE), 3,7);
    }

}
