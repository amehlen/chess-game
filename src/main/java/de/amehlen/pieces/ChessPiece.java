package de.amehlen.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public abstract class ChessPiece extends StackPane {

    private final Image image;
    private final ChessPieceType type;
    private Position position;

    protected ChessPiece(ChessPieceType type, Image image, Position position) {
        this.position = position;
        this.type = type;
        this.image = image;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
