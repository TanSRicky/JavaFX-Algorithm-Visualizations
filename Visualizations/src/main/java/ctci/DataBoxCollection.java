package ctci;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
//Each data box collection has an FX sorts
//which provides a timeline to it.

public class DataBoxCollection 
{
    Group squareGroup = new Group();
    ArrayList<DataBox> ps = new ArrayList<>();
	FXSorts sorts = new FXSorts(ps);
	double rate = .1;
    public DataBoxCollection()
    {
    	
     	
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
	
	public ArrayList<DataBox> getPs() 
	{
		return ps;
	}
	
	public void setPs(ArrayList<DataBox> ps) 
	{
		this.ps = ps;
	}

    
    public void populate() 
    {
     for(int i = 0; i < 1000; i++) {
	    DataBox d = new DataBox();
		squareGroup.getChildren().addAll(d.getStackPane());
		ps.add(d);
     }
		
    }
    
    public void increaseRate() 
    {
    	rate++;
    }
    
    public void c() 
    {
    	
    	 sorts.stop();
		  
    }
    public void panup() 
    {
    	  squareGroup.setLayoutY(squareGroup.getLayoutY()+500);
        
	   
	    
    }
    public void pandown() 
    {
    	  squareGroup.setLayoutY(squareGroup.getLayoutY()-500);
	   
    }
    public void bubbleSort() 
    {
    	
	     sorts.bubbleSort();
	    
    }
    
  
    

}
