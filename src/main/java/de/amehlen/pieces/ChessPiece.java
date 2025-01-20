package de.amehlen.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public abstract class ChessPiece extends StackPane {

    protected ImageView imageView;
    private Position position;

    protected ChessPiece(String filename, Position position) {
        this.position = position;
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/pieces/" + filename)));

        if (image.isError()) {
            throw new IllegalArgumentException("Image not found: " + filename);
        }

        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(60);
        this.imageView.setFitHeight(60);
        this.getChildren()
            .add(imageView);

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
}
