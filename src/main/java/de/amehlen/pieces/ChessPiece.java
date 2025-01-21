package de.amehlen.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public abstract class ChessPiece extends StackPane {

    private final Image image;
    private final ChessPieceType type;
    private final ChessPieceColor color;
    private Position position;

    protected ChessPiece(ChessPieceType type, ChessPieceColor color, Image image, Position position) {
        this.type = type;
        this.color = color;
        this.image = image;
        this.position = position;

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);

        this.getChildren()
            .add(imageView);

    }

    public Image getImage() {
        return image;
    }

    public ChessPieceType getType() {
        return type;
    }

    public ChessPieceColor getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "type=" + type +
                ", color=" + color +
                ", position=" + position +
                '}';
    }

}
