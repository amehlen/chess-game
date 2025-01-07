package de.amehlen;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends GridPane {

    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;
    private static final Color SANDCASTLE_DARK = Color.rgb(184, 140, 75);
    private static final Color SANDCASTLE_LIGHT = Color.rgb(228, 193, 112);

    public ChessBoard() {
        drawChessBoard();
    }

    private void drawChessBoard() {
        for (int col = 0; col < BOARD_SIZE; col++) {
            for (int row = 0; row < BOARD_SIZE; row++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                tile.setFill((col + row) % 2 == 0 ? SANDCASTLE_LIGHT : SANDCASTLE_DARK);
                this.add(tile, col, row);
            }
        }
    }

}
