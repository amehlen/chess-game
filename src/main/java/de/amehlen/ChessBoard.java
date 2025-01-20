package de.amehlen;

import de.amehlen.pieces.ChessPiece;
import de.amehlen.pieces.ChessPieceFactory;
import de.amehlen.pieces.Position;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends GridPane {

    private static final int TILE_SIZE = 80;
    private static final int BOARD_WIDTH = 8;
    private static final int BOARD_HEIGHT = 8;
    private static final Color SANDCASTLE_DARK = Color.rgb(184, 140, 75);
    private static final Color SANDCASTLE_LIGHT = Color.rgb(228, 193, 112);
    private static final String FEN_STRING = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
    private static final int STROKE_WIDTH = 1;
    private static final Color STROKE_COLOR = Color.BLACK;

    public ChessBoard() {
        drawChessBoard();
        placePieces();
    }

    public int getChessBoardWidth() {
        return BOARD_WIDTH * (TILE_SIZE + STROKE_WIDTH);
    }

    public int getChessBoardHeight() {
        return BOARD_HEIGHT * (TILE_SIZE + STROKE_WIDTH);
    }

    private void drawChessBoard() {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_HEIGHT; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                tile.setFill((row + col) % 2 == 0 ? SANDCASTLE_LIGHT : SANDCASTLE_DARK);
                tile.setStroke(STROKE_COLOR);
                tile.setStrokeWidth(STROKE_WIDTH);
                this.add(tile, row, col);
            }
        }
    }

    private void placePieces() {
        String[] rows = FEN_STRING.split("/");
        for (int row = 0; row < BOARD_WIDTH; row++) {
            int col = 0;
            for (char c : rows[row].toCharArray()) {
                if (Character.isDigit(c)) {
                    col += Character.getNumericValue(c);
                } else {
                    Position position = new Position(row, col);
                    ChessPiece piece = ChessPieceFactory.createPiece(c, position);
                    setRowIndex(piece, row);
                    setColumnIndex(piece, col);
                    this.add(piece, col, row);
                    col++;
                }
            }
        }
    }

}
