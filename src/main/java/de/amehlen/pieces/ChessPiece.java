package de.amehlen.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public abstract class ChessPiece extends StackPane {

    protected ImageView imageView;

    protected ChessPiece(String filename) {
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
}
