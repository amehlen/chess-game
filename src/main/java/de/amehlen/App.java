package de.amehlen;

import de.amehlen.gui.MenuHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        ChessBoard chessBoard = new ChessBoard();

        MenuHandler menuHandler = new MenuHandler(stage);
        MenuBar menuBar = menuHandler.createMenuBar();

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(chessBoard);

        Scene scene = new Scene(root, chessBoard.getChessBoardWidth(), chessBoard.getChessBoardHeight());

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
