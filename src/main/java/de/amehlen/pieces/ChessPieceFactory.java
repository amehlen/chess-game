package de.amehlen.pieces;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceFactory {

    private static final Map<String, Image> imageCache = new HashMap<>();

    private ChessPieceFactory() {
    }

    public static ChessPiece createPiece(char piece, Position position) {
        ChessPieceColor color = Character.isUpperCase(piece) ? ChessPieceColor.WHITE : ChessPieceColor.BLACK;
        String key = generateCacheKey(piece, color);
        Image image = imageCache.computeIfAbsent(key, k -> new Image(
                ChessPieceFactory.class.getResourceAsStream("/pieces/chess_" + key + ".png")));

        return switch (Character.toLowerCase(piece)) {
            case 'b' -> new Bishop(image, position);
            case 'k' -> new King(image, position);
            case 'n' -> new Knight(image, position);
            case 'p' -> new Pawn(image, position);
            case 'q' -> new Queen(image, position);
            case 'r' -> new Rook(image, position);
            default -> throw new IllegalArgumentException("Unknown chess piece: " + piece);
        };
    }

    private static String generateCacheKey(char piece, ChessPieceColor color) {
        String chessPiece = switch (Character.toLowerCase(piece)) {
            case 'b' -> "bishop";
            case 'k' -> "king";
            case 'n' -> "knight";
            case 'p' -> "pawn";
            case 'q' -> "queen";
            case 'r' -> "rook";
            default -> throw new IllegalArgumentException("Unknown chess piece: " + piece);
        };
        return chessPiece + "_" + color.name()
                                       .toLowerCase();
    }

}