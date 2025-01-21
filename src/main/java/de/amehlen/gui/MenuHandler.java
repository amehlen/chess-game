package de.amehlen.gui;

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

    public MenuHandler(Stage stage) {
        this.stage = stage;
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
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            LOGGER.info("File selected: {}", file.getAbsolutePath());
        }
    }

    private void closeApplication() {
        stage.close();
    }
}
