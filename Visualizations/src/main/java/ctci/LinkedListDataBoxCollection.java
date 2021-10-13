package ctci;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class LinkedListDataBoxCollection extends DataBoxCollection
{  

	public LinkedListDataBoxCollection() 
	{
	  super();
	  LLDataNode node = new LLDataNode();
      ps.add(node.box);
      ps.add(node.boxTwo);
      ps.add(node.boxThree);
      squareGroup.getChildren().addAll(node.combinedPane);
     
	}
	
	@Override
    public void populate() 
    {
    
	    LLDataNode d  = new LLDataNode();
		squareGroup.getChildren().addAll(d.getStackPane());
		ps.add(d);
     
		
    }
    

   
}
