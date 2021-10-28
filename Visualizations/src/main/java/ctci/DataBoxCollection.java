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
//which provides a time line to it.

public class DataBoxCollection extends CollectionTemplate
{
	
	
	
    public DataBoxCollection()
    {
    	
  
     	
		 
    }
    

	public void show() {
		// TODO Auto-generated method stub
		for (DataBoxTemplate d : ps) {
			squareGroup.getChildren().addAll(d.getStackPane());
		}
		
	}
       

	@Override
	public void populate() {
		// TODO Auto-generated method stub
		 for(int i = 0; i < 1000; i++) {
		   	    DataBox d = new DataBox();
		   		squareGroup.getChildren().addAll(d.getStackPane());
		   		ps.add(d);
		}
	}
}
