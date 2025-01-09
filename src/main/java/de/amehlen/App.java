package de.amehlen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        ChessBoard chessBoard = new ChessBoard();
        Scene scene = new Scene(chessBoard, 640, 640);

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/chess-icon.png")));
        stage.getIcons().add(icon);

        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
