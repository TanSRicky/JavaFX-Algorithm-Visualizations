package ctci;

import java.util.ArrayList;


import javafx.scene.shape.Rectangle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class CollectionTemplate extends Pane {

	protected Pane squareGroup = new Pane();
	protected ObservableList<DataBoxTemplate> ps = FXCollections.observableArrayList();
	protected FXSorts sorts = new FXSorts(ps);
	protected double xOffSet = ShapeBuilder.getLength();
	protected double yOffSet = ShapeBuilder.getLength();
	final ContextMenu contextMenu = new ContextMenu();
	final Rectangle redBorder = new Rectangle(0, 0, Color.TRANSPARENT);
	protected Menu sort = new Menu(Messages.getString("Collection.sort")); //$NON-NLS-1$
	protected MenuItem edit = new MenuItem(Messages.getString("Collection.edit")); //$NON-NLS-1$
	protected MenuItem bubbleSort = new MenuItem(Messages.getString("Collection.bubbleSort")); //$NON-NLS-1$
	protected MenuItem quickSort = new MenuItem(Messages.getString("Collection.quickSort")); //$NON-NLS-1$
    protected BooleanProperty selected = null;
   
	public CollectionTemplate(BooleanProperty s) {
		this.selected = s;

	    Border border = new Border(new BorderStroke(Color.RED, 
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		contextMenu.getItems().addAll(sort,edit);
		sort.getItems().addAll(bubbleSort,quickSort);
		bubbleSort.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				sorts.bubbleSort();
				
				
			}
		});
		
		quickSort.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				sorts.QuickSort(0,ps.size()-1);
				
				
			}
		});
		
		
		squareGroup.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)){
		            if(event.getClickCount() == 2){
		
						selected.setValue(!selected.getValue());
						if(selected.getValue() == false) {
							squareGroup.setBorder(border);
						} else {
							squareGroup.setBorder(Border.EMPTY);
						}
			}
		}}
		});
	

		squareGroup.setOnMouseDragged(new EventHandler<MouseEvent>()
		{	
			@Override
			public void handle(final MouseEvent event)
			{
				squareGroup.setTranslateX(squareGroup.getTranslateX() + event.getX() - 200);
				squareGroup.setTranslateY(squareGroup.getTranslateY() + event.getY() - 50);
			}
		});		
		squareGroup.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			@Override
			public void handle(final ContextMenuEvent event) {
				contextMenu.show(squareGroup ,event.getScreenX(), event.getScreenY());
			}

		});


	}

	public abstract void OffSet();

	public Pane getSquareGroup() {
		return squareGroup;
	}

	public void setSquareGroup(BorderPane squareGroup) {
		this.squareGroup = squareGroup;
	}

	public ObservableList<DataBoxTemplate> getPs() {
		return ps;
	}

	public void setPs( ObservableList<DataBoxTemplate> ps) {
		this.ps = ps;
	}

	public void toggleVisibility() {
		this.squareGroup.setVisible(!this.squareGroup.isVisible());
	}

	public abstract void populate();

	public void panup() {
		squareGroup.setLayoutY(squareGroup.getLayoutY() + 500);

	}

	public void pandown() {
		squareGroup.setLayoutY(squareGroup.getLayoutY() - 500);

	}

	public void bubbleSort() throws InterruptedException {
		sorts.bubbleSort();
	}
	public ArrayList<Integer> getIntegerList() {
		ArrayList<Integer> tmp = new ArrayList<>();
		for(DataBoxTemplate db : this.ps) {
			tmp.add(db.value);
		}
		return tmp;
	}
	public abstract void buttons();

}
