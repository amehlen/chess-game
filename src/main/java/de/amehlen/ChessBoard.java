package de.amehlen;

import de.amehlen.pieces.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends GridPane {

    private static final int TILE_SIZE = 80;
    private static final int BOARD_WIDTH = 8;
    private static final int BOARD_HEIGHT = 8;
    private static final Color SANDCASTLE_DARK = Color.rgb(184, 140, 75);
    private static final Color SANDCASTLE_LIGHT = Color.rgb(228, 193, 112);
    private static final String WHITE_PIECE = "white";
    private static final String BLACK_PIECE = "black";
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
                    ChessPiece piece = getPiece(c);
                    setRowIndex(piece, row);
                    setColumnIndex(piece, col);
                    this.add(piece, col, row);
                    col++;
                }
            }
        }
    }

    private ChessPiece getPiece(char pieceSymbol) {
        ChessPiece result;
        if (Character.isUpperCase(pieceSymbol)) {
            result = switch (pieceSymbol) {
                case 'B' -> new Bishop(WHITE_PIECE);
                case 'K' -> new King(WHITE_PIECE);
                case 'N' -> new Knight(WHITE_PIECE);
                case 'P' -> new Pawn(WHITE_PIECE);
                case 'Q' -> new Queen(WHITE_PIECE);
                case 'R' -> new Rook(WHITE_PIECE);
                default -> null;
            };
        } else {
            result = switch (pieceSymbol) {
                case 'b' -> new Bishop(BLACK_PIECE);
                case 'k' -> new King(BLACK_PIECE);
                case 'n' -> new Knight(BLACK_PIECE);
                case 'p' -> new Pawn(BLACK_PIECE);
                case 'q' -> new Queen(BLACK_PIECE);
                case 'r' -> new Rook(BLACK_PIECE);
                default -> null;
            };
        }
        return result;
    }

}
