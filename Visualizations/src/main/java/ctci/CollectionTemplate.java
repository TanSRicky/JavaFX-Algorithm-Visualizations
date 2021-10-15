package ctci;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;


public abstract class CollectionTemplate {
	Group squareGroup = new Group();
	ArrayList<DataBoxTemplate> ps = new ArrayList<>();
	FXSorts sorts = new FXSorts(ps);
	double rate = .1;

    public CollectionTemplate() {
    	
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
    			squareGroup.setLayoutX(squareGroup.getLayoutX()+ event.getX());
    			squareGroup.setLayoutY(squareGroup.getLayoutY()+event.getY() );
    		}
    	});
    }
    public Group getSquareGroup()
    {
		return squareGroup;
	}
    
	public void setSquareGroup(Group squareGroup) 
	{
		this.squareGroup = squareGroup;
	}
	
	public ArrayList<DataBoxTemplate> getPs() 
	{
		return ps;
	}
	
	public void setPs(ArrayList<DataBoxTemplate> ps) 
	{
		this.ps = ps;
	}

    
    public abstract void populate();
  
    
    public void increaseRate(){
    	rate++;
    }
    
  
    public void panup() {
    	  squareGroup.setLayoutY(squareGroup.getLayoutY()+500);
        
	   
	    
    }
    
    public void pandown() {
    	  squareGroup.setLayoutY(squareGroup.getLayoutY()-500);
	   
    }
    
    public void bubbleSort() throws InterruptedException {
	      sorts.bubbleSort();
    }
    
	
	
}
