package ctci;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PrimaryPane extends AnchorPane {

	static MenuBar menuBar;
	static PrimaryPane pane;
	static Group g = new Group();
	
	final ContextMenu contextMenu = new ContextMenu();
	final Pane bigPane = new Pane();
	
	boolean bubbleSortOn = false;
	Label label = new Label();
	BackgroundFill background_fill = new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY);
	Background background = new Background(background_fill);
	
	Pane leftPane = new Pane();


	Separator separator = new Separator(Orientation.HORIZONTAL);
	Separator vSeparator = new Separator(Orientation.VERTICAL);
    ArrayList<CollectionTemplate> c = new ArrayList<>();
	DataBoxCollection dbc = new DataBoxCollection();
	LLCollection ldb = new LLCollection();
	TreeNodeCollection tnc = new TreeNodeCollection();

	

	ObservableList<Node> pc;
	BorderPane bp = new BorderPane();

	
	

	PrimaryPane() {
		c.add(dbc);
		c.add(ldb);
		c.add(tnc);
		
		PrimaryPane.pane = this;
		
		MenuBar menuBar = new MenuBar();
		MenuItem item = new MenuItem(Messages.getString("TopBar.File.add")); //$NON-NLS-1$
		item.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {
				label.setText(Messages.getString("PrimaryPane.11")); //$NON-NLS-1$
			}
		});

		final Menu squareMenu = new Menu(Messages.getString("TopBar.File")); //$NON-NLS-1$

		squareMenu.getItems().addAll(item);
		menuBar.getMenus().addAll(squareMenu);
		menuBar.setPrefWidth(2500);
		menuBar.setPrefHeight(10);

		pane.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			@Override
			public void handle(final ContextMenuEvent event) {
				contextMenu.show(pane, event.getScreenX(), event.getScreenY());
			}

		});

		for (int i = 0; i < 1000; i++) {
			dbc.populate();
		}

		pane.setMinWidth(1900);
		pane.setMinHeight(1000);
		pane.setBackground(background);
		pane.getChildren().addAll(dbc.getSquareGroup(), tnc.getSquareGroup());
		pane.getChildren().addAll(ldb.getSquareGroup());

		vSeparator.relocate(100, 100);
		bp.getChildren().add(menuBar);
		pc = pane.getChildren();



		bigPane.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));

		bigPane.getChildren().addAll(pane, menuBar);
		g.getChildren().addAll(bigPane);

	}
    public Group getGroup() {
    	return PrimaryPane.g;
    } 
	

}
