package ctci;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public abstract class CollectionTemplate extends Pane {

	Group squareGroup = new Group();
	ArrayList<DataBoxTemplate> ps = new ArrayList<>();
	FXSorts sorts = new FXSorts(ps);
	protected double xOffSet = ShapeBuilder.getLength();
	protected double yOffSet = ShapeBuilder.getLength();
	final ContextMenu contextMenu = new ContextMenu();
	
	MenuItem sort = new MenuItem(Messages.getString("Collection.sort")); //$NON-NLS-1$
	MenuItem edit = new MenuItem(Messages.getString("Collection.edit")); //$NON-NLS-1$


	public CollectionTemplate() {

		contextMenu.getItems().addAll(sort,edit);

		squareGroup.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent event) {

			}
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

	public Group getSquareGroup() {
		return squareGroup;
	}

	public void setSquareGroup(Group squareGroup) {
		this.squareGroup = squareGroup;
	}

	public ArrayList<DataBoxTemplate> getPs() {
		return ps;
	}

	public void setPs(ArrayList<DataBoxTemplate> ps) {
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

	public abstract void buttons();

}
