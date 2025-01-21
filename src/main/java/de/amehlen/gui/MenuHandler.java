package de.amehlen.gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuHandler {

    private final Stage stage;

    public MenuHandler(Stage stage) {
        this.stage = stage;
    }

    public MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");

        MenuItem closeMenuItem = new MenuItem("Close");
        closeMenuItem.setOnAction(e -> closeApplication());

        fileMenu.getItems()
                .addAll(closeMenuItem);

        menuBar.getMenus()
               .add(fileMenu);

        return menuBar;
    }

    private void closeApplication() {
        stage.close();
    }
}
