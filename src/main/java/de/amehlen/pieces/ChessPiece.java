package de.amehlen.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public abstract class ChessPiece extends StackPane {

    private final Image image;
    private Position position;

    protected ChessPiece(Image image, Position position) {
        this.position = position;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
