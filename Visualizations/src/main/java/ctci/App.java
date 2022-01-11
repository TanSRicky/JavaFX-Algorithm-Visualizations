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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
	
	final static MenuBar menuBar = new MenuBar();
	final static Pane pane = new Pane();
	final static Group g = new Group();
	final static ContextMenu contextMenu = new ContextMenu();
	final static BorderPane borderPane = new BorderPane();
	final static Menu squareMenu = new Menu(Messages.getString("TopBar.File")); //$NON-NLS-1$
	final static Menu addItem = new Menu(Messages.getString("TopBar.File.add")); //$NON-NLS-1$
	final static MenuItem pixelGridAdd = new MenuItem(Messages.getString("Add new pixel array"));
	final static MenuItem linkedListAdd = new MenuItem(Messages.getString("Add new linkedlist"));
	final static MenuItem treeAdd = new MenuItem(Messages.getString("Add new tree"));
    final static ArrayList<CollectionTemplate> collectionsList = new ArrayList<>();
	final static ObservableList<Node> pc = null;
	static Scene scene = null;
	static Rectangle2D        primaryScreenBounds;
	final static Pane leftPane = new Pane();
	final static ListView<String> listView = new ListView<String>();
    static BooleanProperty nodeSelected = new SimpleBooleanProperty(false);
    static ListView<String>bottom = new ListView<>();

	/**
     * Start.
     *
     * @param primaryStage the primary stage
     * @throws IOException Signals that an I/O exception has occurred.
     */
	
    @Override
    public void start(Stage primaryStage) throws IOException {

        ScrollPane sp = new ScrollPane();
		bottom.setBackground(new Background(new BackgroundFill(Color.DARKSLATEGREY ,CornerRadii.EMPTY, Insets.EMPTY)));

    	primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		leftPane.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		pane.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE  ,CornerRadii.EMPTY, Insets.EMPTY)));
		borderPane.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        bottom.setPrefSize(1920,150);
        bottom.setEditable(false);
		sp.setContent(pane);

		sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		bottom.setPrefHeight(150);
		bottom.setMinHeight(100);
		
		borderPane.setCenter(sp);
		borderPane.setLeft(leftPane);
		borderPane.setTop(menuBar);
		borderPane.setBottom(bottom);

		pane.getChildren().add(g);
		menuBar.getMenus().addAll(squareMenu);
		squareMenu.getItems().addAll(addItem);
		addItem.getItems().addAll(pixelGridAdd,linkedListAdd,treeAdd);
		leftPane.getChildren().addAll(listView);

		menuBar.setPrefWidth(1600);
		menuBar.setPrefHeight(10);

		 sp.setPrefHeight(750);
		 pane.setPrefHeight(750);

		
		listView.setMinWidth(75);
		listView.prefWidth(100);
		listView.setMinHeight(600);
		leftPane.setMinSize(25,500);
		leftPane.setOpacity(1.0);
	
		scene = new Scene(borderPane,primaryScreenBounds.getMinX(),primaryScreenBounds.getMinY());
	    primaryStage.setScene(scene);
	    primaryStage.show();
	   	 
    }
	
	public static void handles() {
		pane.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			@Override
			public void handle(final ContextMenuEvent event) {
				contextMenu.show(pane, event.getScreenX(), event.getScreenY());
			}
		});
		
		pixelGridAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				DataBoxCollection tmp = new DataBoxCollection(nodeSelected);
				for (int i = 0; i < 100; i++) {	tmp.populate(); }
				collectionsList.add(tmp);
				listView.getItems().addAll(tmp.toString());
				g.getChildren().addAll(tmp.getSquareGroup());
				ArrayList<Integer> valTmp = new ArrayList<>();
				for(DataBoxTemplate db : tmp.getPs()) {
					valTmp.add(db.value);
				}
				bottom.getItems().addAll(valTmp.toString());
				
				
			}
		});
		
		linkedListAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				LLCollection tmp = new LLCollection(nodeSelected);
				for (int i = 0; i < 100; i++) {	tmp.populate(); }
				collectionsList.add(tmp);
				listView.getItems().addAll(tmp.toString());
				g.getChildren().addAll(tmp.getSquareGroup());
				ArrayList<Integer> valTmp = new ArrayList<>();
				for(DataBoxTemplate db : tmp.getPs()) {
					valTmp.add(db.value);
				}
				bottom.getItems().addAll(valTmp.toString());
				
			}
		});
		
		treeAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				TreeNodeCollection tmp = new TreeNodeCollection(nodeSelected);
			    tmp.populate(); 
				collectionsList.add(tmp);
				listView.getItems().addAll(tmp.toString());
				g.getChildren().addAll(tmp.getSquareGroup());
				ArrayList<Integer> valTmp = new ArrayList<>();
				for(DataBoxTemplate db : tmp.getPs()) {
					valTmp.add(db.value);
				}
				bottom.getItems().addAll(valTmp.toString());
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
