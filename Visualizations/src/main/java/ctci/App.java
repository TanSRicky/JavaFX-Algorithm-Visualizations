package ctci;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import java.util.Collections;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * JavaFX App.
 * https://stackoverflow.com/a/53237667 
 * javadoc link; need to fix IDE to generate javadoc 
 */

public class App extends Application {
	

	final static Pane centerPane = new Pane();
	final static Group structureGroup = new Group();
	
	final static ContextMenu contextMenu = new ContextMenu();
	final static BorderPane borderPane = new BorderPane();
	
	final static MenuBar menuBar = new MenuBar();
	final static Menu fileMenu = new Menu(Messages.getString("TopBar.File"));							 //$NON-NLS-1$
	final static Menu addItem = new Menu(Messages.getString("TopBar.File.add")); 						 //$NON-NLS-1$
	final static MenuItem addDataBoxCollection = new MenuItem(Messages.getString("TopBar.File.add.Array")); //$NON-NLS-1$
	final static MenuItem addLinkedList = new MenuItem(Messages.getString("TopBar.File.add.LinkedList"));//$NON-NLS-1$
	final static MenuItem addTree = new MenuItem(Messages.getString("TopBar.File.add.Tree"));		     //$NON-NLS-1$
    final static ArrayList<CollectionTemplate> structures = new ArrayList<>();
    final static Pane leftPane = new Pane();
	final static ListView<String> leftList = new ListView<String>();
	static Scene scene;
	static Rectangle2D        primaryScreenBounds;
    static BooleanProperty nodeSelected = new SimpleBooleanProperty(false);
    static ListView<ListView<Text>> bottomList = new ListView<>();

	/**
     * Start.
     *
     * @param primaryStage the primary stage
     * @throws IOException Signals that an I/O exception has occurred.
     */
	
    @Override
    public void start(Stage primaryStage) throws IOException {
  
        ScrollPane sp = new ScrollPane();
		bottomList.setBackground(new Background(new BackgroundFill(Color.DARKSLATEGREY ,CornerRadii.EMPTY, Insets.EMPTY)));

    	primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		leftPane.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		centerPane.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE  ,CornerRadii.EMPTY, Insets.EMPTY)));
		borderPane.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        bottomList.setEditable(false);
		sp.setContent(centerPane);
		bottomList.setPrefSize(700,1000);
		sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		bottomList.setPrefHeight(150);
		bottomList.setMinHeight(100);
		leftList.setPrefHeight(1000);
		borderPane.setCenter(sp);
		borderPane.setLeft(leftPane);
		borderPane.setTop(menuBar);
		borderPane.setBottom(bottomList);
		leftPane.setPrefHeight(1000);
		centerPane.getChildren().add(structureGroup);
		menuBar.getMenus().addAll(fileMenu);
		fileMenu.getItems().addAll(addItem);
		addItem.getItems().addAll(addDataBoxCollection,addLinkedList,addTree);
		leftPane.getChildren().addAll(leftList);

		menuBar.setPrefWidth(1600);
		menuBar.setPrefHeight(10);

		 sp.setPrefHeight(750);
		 centerPane.setMinHeight(1000);

		centerPane.setMinWidth(1920);
		leftList.setMinWidth(75);
		leftList.prefWidth(100);
		leftList.setMinHeight(600);
		leftPane.setMinSize(25,500);
		leftPane.setOpacity(1.0);
	
		scene = new Scene(borderPane,primaryScreenBounds.getMinX(),primaryScreenBounds.getMinY());
	    primaryStage.setScene(scene);
	    primaryStage.show();
	   	 
    }
	
	public static void handles() {
		centerPane.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			@Override
			public void handle(final ContextMenuEvent event) {
				contextMenu.show(centerPane, event.getScreenX(), event.getScreenY());
			}
		});
		
		addDataBoxCollection.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			      DataBoxCollection tmp = new DataBoxCollection(nodeSelected);
			      tmp.populate();
					structures.add(tmp);
					leftList.getItems().addAll(tmp.toString());
					structureGroup.getChildren().addAll(tmp.getSquareGroup());
					ListView<Text> valTmp = new ListView<>();
					valTmp.setOrientation(Orientation.HORIZONTAL);
					for(DataBoxTemplate db : tmp.getPs()) {
						valTmp.getItems().add(db.getT());
					}
				   valTmp.setPrefHeight(50);
					bottomList.getItems().add(valTmp);
				
			}
		});
		
		addLinkedList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				LLCollection tmp = new LLCollection(nodeSelected);
				for (int i = 0; i < 100; i++) {	tmp.populate(); }
				structures.add(tmp);
				leftList.getItems().addAll(tmp.toString());
				structureGroup.getChildren().addAll(tmp.getSquareGroup());

				ArrayList<Integer> valTmp = new ArrayList<>();
				for(DataBoxTemplate db : tmp.getPs()) {
					valTmp.add(db.value);
				}
			//	bottomList.getItems().add(valTmp.toString());
				
			}
		});
		
		addTree.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				TreeNodeCollection tmp = new TreeNodeCollection(nodeSelected);
			    tmp.populate(); 
				structures.add(tmp);
				leftList.getItems().addAll(tmp.toString());
				structureGroup.getChildren().addAll(tmp.getSquareGroup());
				ArrayList<Integer> valTmp = new ArrayList<>();
				for(DataBoxTemplate db : tmp.getPs()) {
					valTmp.add(db.value);
				}
				//bottomList.getItems().addAll(valTmp.toString());
			
			}
		});
	}
	
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
    	handles();
        launch();
    }
    
    
    
}
