package de.amehlen.pieces;

import javafx.scene.image.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceFactory {

    private static final Logger LOGGER = LogManager.getLogger(ChessPieceFactory.class);

    private static final Map<String, Image> imageCache = new HashMap<>();

    private ChessPieceFactory() {
    }

    public static ChessPiece createPiece(char piece, Position position) {
        ChessPieceColor color = Character.isUpperCase(piece) ? ChessPieceColor.WHITE : ChessPieceColor.BLACK;
        ChessPieceType type = mapToType(piece);
        String key = type.getDisplayName() + "_" + color.name()
                                                        .toLowerCase();
        LOGGER.info("Load image with the following key: {}", key);

        Image image = imageCache.computeIfAbsent(key, k -> new Image(
                ChessPieceFactory.class.getResourceAsStream("/pieces/chess_" + key + ".png")));

        return switch (Character.toLowerCase(piece)) {
            case 'b' -> new Bishop(type, color, image, position);
            case 'k' -> new King(type, color, image, position);
            case 'n' -> new Knight(type, color, image, position);
            case 'p' -> new Pawn(type, color, image, position);
            case 'q' -> new Queen(type, color, image, position);
            case 'r' -> new Rook(type, color, image, position);
            default -> throw new IllegalArgumentException("Unknown chess piece: " + piece);
        };
    }

    private static ChessPieceType mapToType(char c) {
        return switch (Character.toLowerCase(c)) {
            case 'b' -> ChessPieceType.BISHOP;
            case 'k' -> ChessPieceType.KING;
            case 'n' -> ChessPieceType.KNIGHT;
            case 'p' -> ChessPieceType.PAWN;
            case 'q' -> ChessPieceType.QUEEN;
            case 'r' -> ChessPieceType.ROOK;
            default -> throw new IllegalArgumentException("Unknown piece type: " + c);
        };
    }

}