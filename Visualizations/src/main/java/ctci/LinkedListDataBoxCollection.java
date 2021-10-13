package ctci;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class LinkedListDataBoxCollection implements CollectionTemplate 
{  
	Group squareGroup = new Group();
	ArrayList<LLDataNode> ps = new ArrayList<>();
	
	public LinkedListDataBoxCollection() 
	{
	 
	  LLDataNode node = new LLDataNode();
      squareGroup.getChildren().addAll(node.combinedPane);
      ps.add(node);
	}
	
	
	@Override
    public void populate() 
    {
    
	    LLDataNode d  = new LLDataNode();
		squareGroup.getChildren().addAll(d.getStackPane());
		ps.add(d);
     
		
    }


	public Group getSquareGroup() {
		// TODO Auto-generated method stub
		return this.squareGroup;
	}
    

   
}
