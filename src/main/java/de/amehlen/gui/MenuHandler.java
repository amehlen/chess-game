package de.amehlen.gui;

import de.amehlen.ChessBoard;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MenuHandler {

    private static final Logger LOGGER = LogManager.getLogger(MenuHandler.class);

    private final Stage stage;
    private final ChessBoard chessBoard;

    public MenuHandler(Stage stage, ChessBoard chessBoard) {
        this.stage = stage;
        this.chessBoard = chessBoard;
    }

    public MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");

        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setOnAction(e -> openFile());

        MenuItem closeMenuItem = new MenuItem("Close");
        closeMenuItem.setOnAction(e -> closeApplication());

        fileMenu.getItems()
                .addAll(openMenuItem, closeMenuItem);

        menuBar.getMenus()
               .add(fileMenu);

        return menuBar;
    }

    private void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                   .add(new FileChooser.ExtensionFilter("Chess Files", "*.chess"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            LOGGER.info("File selected: {}", selectedFile.getAbsolutePath());
            chessBoard.loadFenFromFile(selectedFile);
        }
    }

    private void closeApplication() {
        stage.close();
    }
}
