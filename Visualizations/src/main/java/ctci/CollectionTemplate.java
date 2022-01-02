package ctci;

import java.util.ArrayList;

import javafx.event.ActionEvent;
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
	double rate = .1;
	double xOffSet = ShapeBuilder.getLength();
	double yOffSet = ShapeBuilder.getLength();
	final ContextMenu contextMenu = new ContextMenu();
	
	MenuItem item = new MenuItem(Messages.getString("PrimaryPane.0")); //$NON-NLS-1$
	MenuItem label1 = new MenuItem(Messages.getString("PrimaryPane.1")); //$NON-NLS-1$
	MenuItem swap = new MenuItem(Messages.getString("PrimaryPane.2")); //$NON-NLS-1$
	MenuItem label2 = new MenuItem(Messages.getString("PrimaryPane.3")); //$NON-NLS-1$
	MenuItem label3 = new MenuItem(Messages.getString("PrimaryPane.4")); //$NON-NLS-1$
	MenuItem llLabel = new MenuItem(Messages.getString("PrimaryPane.5")); //$NON-NLS-1$
	MenuItem tn = new MenuItem(Messages.getString("PrimaryPane.6")); //$NON-NLS-1$
	MenuItem partition = new MenuItem(Messages.getString("PrimaryPane.7")); //$NON-NLS-1$
	MenuItem panDown = new MenuItem(Messages.getString("PrimaryPane.8")); //$NON-NLS-1$
	MenuItem panUp = new MenuItem(Messages.getString("PrimaryPane.9")); //$NON-NLS-1$
	MenuItem play = new MenuItem(Messages.getString("PrimaryPane.10")); //$NON-NLS-1$

	public CollectionTemplate() {

		contextMenu.getItems().addAll(label2, swap, label3, llLabel, partition, panDown, panUp, tn);

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

	public void increaseRate() {
		rate++;
	}

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
