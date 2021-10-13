package ctci;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public  class PaneBuilder {
    static AnchorPane pane = new AnchorPane();
    ObservableList<Node> pc = pane.getChildren();
	static Group g = new Group();
 
    BackgroundFill background_fill = new BackgroundFill(Color.WHITESMOKE, 
    CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill);
    boolean bubbleSortOn = false;

    Pane leftPane = new Pane();
    
    Separator separator = new Separator(Orientation.HORIZONTAL);
	Separator vSeparator = new Separator(Orientation.VERTICAL);
	
	static VBox vBox;
	

	MenuItem item = new MenuItem("add");

    DataBoxCollection dbc = new DataBoxCollection();
    LinkedListDataBoxCollection ldb = new LinkedListDataBoxCollection();
    Integer x = 0;
	BorderPane bp = new BorderPane();
	static MenuBar menuBar;
	
	Label label = new Label();
	Button label1 = new Button("sq+");
	Button swap = new Button("Bubblesort");
    Button label2 = new Button("sq-");
	ButtonBase label3 = new  Button("Stop");
	Button llLabel = new Button("LL+");
	Button partition = new Button("partition");
	Button panDown = new Button("goDown");
	Button panUp = new Button("goUp");
	
	{
	
		menuBar = menuBar();
	    pane.setMinWidth(1900);
		pane.setMinHeight(1000);
		pane.setTranslateX(100);
		pane.setBackground(background);
		pane.getChildren().addAll(dbc.getSquareGroup());
		pane.getChildren().addAll( ldb.getSquareGroup());
	   	vSeparator.relocate(100,100);
		bp.getChildren().add(menuBar);
	
	
		Pane bigPane = new Pane();
	
		
		buttons();
		bigPane.setBackground(new Background(new BackgroundFill(Color.DARKGREY,  CornerRadii.EMPTY, Insets.EMPTY )));

		vBox = new VBox(label1,label2,swap,label3,llLabel,partition,panDown,panUp);

		vBox.setTranslateY(25);
		bigPane.getChildren().addAll(vBox,pane,menuBar);
	
		g.getChildren().addAll(bigPane);
		
	} 
	  
	  
	 static Group extracted()
     {
		return g;
	 }
	 
    private MenuBar menuBar()
    {
    	    MenuBar menuBar = new MenuBar();
    	    item.setOnAction(new EventHandler<ActionEvent>() 
    	    {
    		@Override
            public void handle(ActionEvent event) {
                label.setText("Select Menu Item 1");
             }
            });
    	    Menu squareMenu = new Menu("Menu");
            squareMenu.getItems().addAll(item);
    	  
    	    menuBar.getMenus().addAll(squareMenu);
    		menuBar.setPrefWidth(2500);
    		menuBar.setPrefHeight(10);
    		return menuBar;
    }
    
    
    
    private void buttons() 
    {
	      panUp.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
	  	  {
	  	  @Override public void handle(ActionEvent e) 
	  	  {
	  			dbc.panup();
	  	  }
	  	  });
	  	  
      	  panDown.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
    	  {
    	  @Override public void handle(ActionEvent e) 
    	  {
    			dbc.pandown();
    	  }
    	  });
    	  
      	
    	  
    	  label1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
    	  {
    	  @Override public void handle(ActionEvent e) 
    	  {
    			dbc.populate();
    	  }
    	  });
    	  
    	  label2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
{
    	  @Override public void handle(ActionEvent e) 
    	  {
    		      
    		  dbc.increaseRate();
    	  }});
    	  
   
		 label3.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
	    {
    	  @Override 
    	  public void handle(ActionEvent e) 
    	  {
    		  dbc.c();
    		 
    	  }});
		 
		 llLabel.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		    {
	    	  @Override 
	    	  public void handle(ActionEvent e) 
	    	  {
	    		 ldb.populate();
	    		 
	    	  }});
		 
		 partition.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		    {
	    	  @Override 
	    	  public void handle(ActionEvent e) 
	    	  {
					dbc.sorts.QuickSort(0, dbc.sorts.ps.size()-1);
	    		 
	    	  }});
    	  swap.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
    	  {
    	  @Override public void handle(ActionEvent e) 
    	  {
    		  
    		  dbc.bubbleSort();
    		 
    	  }});
    }
    
    
}
