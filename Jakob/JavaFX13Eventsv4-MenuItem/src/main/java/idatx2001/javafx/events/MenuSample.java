package idatx2001.javafx.events;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * Demonstrates the use of menus in JavaFX, and 
 * how to handle events from the menu items.
 */
public class MenuSample extends Application
{

    // Place the textCentre variable as a field so that it can be reached
    // from all methods int the class.
    Text textCentre;

    /**
     * The start-method is called by the JavaFX platform upon starting the
     * JavaFX-platform. The method is abstract and must be overridden by
     * any subclass of Application.
     * The main window is setup in this method, including menus, toolboxes etc.
     *
     * @param primaryStage The main stage making up the main window.
     */
    @Override
    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane(); // Create the root node. The Menu will be placed at the top
        VBox topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        MenuBar mainMenu = createMenus();  //Creates our main menu to hold our Sub-Menus.

        // Place the menubar in the topContainer
        topContainer.getChildren().add(mainMenu);

        // Place the topcontainer in the top-section of the BorderPane
        root.setTop(topContainer);

        // Add a Text-component in the centre
        this.textCentre = new Text("Click a menu item");
        root.setCenter(textCentre);

        // Create the scene, adding the rootNode and setting the size
        Scene scene = new Scene(root, 300, 250);
        // Set title of the stage (window) and add the scene
        primaryStage.setTitle("Menu Sample");
        primaryStage.setScene(scene);
        // Finally, make the stage (window) visible
        primaryStage.show();
    }

    /**
     * The stop() method is being called by the JavaFX-platform when the
     * platform stops, are being terminated. This would typically happen
     * as a result of the last open window being closed.
     * Override this method to make sure that the application is terminated.
     */
    @Override
    public void stop()
    {
        System.exit(0);
    }

    /**
     * The entry-point to start the application.
     * @param args Command-line arguments supplied during startup
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * Creates and returns the menus to be displayed.
     * Notice how anonomous classes are being used to add
     * event listeners/handlers to the menu items.
     * Also note how we delegate the handling/processing
     * of the events to separate methods like <code>doFileOpen()</code>
     * and <code>doFilePrint()</code>.
     * 
     * @return The MenuBar to be displayed.
     */
    private MenuBar createMenus()
    {
        // Create the Menu Bar to hold all the menus
        MenuBar menuBar = new MenuBar();

        // The File-menu
        Menu menuFile = new Menu("File");

        MenuItem openFile = new MenuItem("Open");
        openFile.setOnAction( event ->
                    doFileOpen()
                    );
                    
        MenuItem printFile = new MenuItem("Print");
        printFile.setOnAction( event ->
                    doFilePrint()
                    );

        MenuItem exitApp = new MenuItem("Exit");
        exitApp.setOnAction( event ->
                    doFileExit()
                    );        
                    
        menuFile.getItems().addAll(openFile, printFile);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(exitApp);

        // The Edit-menu
        Menu menuEdit = new Menu("Edit");
        // The View-menu
        Menu menuView = new Menu("View");

        // Add all the menues to the menubar
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        return menuBar;
    }

    private void doFileOpen()
    {
        textCentre.setText("You clicked File->Open");        
    }

    private void doFilePrint()
    {
        textCentre.setText("You clicked File->Print");        
    }
    
    private void doFileExit()
    {
        textCentre.setText("You clicked File->Exit");        
    }
}
