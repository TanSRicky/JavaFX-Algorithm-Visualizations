package ctci;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class LinkedListDataBox extends DataBoxCollection
{  
	public class LLDataNode
	{
		
		DataBox box  = new DataBox();
		DataBox boxTwo  = new DataBox();
		DataBox boxThree= new DataBox();
		Pane combinedPane = new Pane();
		Line line = new Line();
		
		LLDataNode(){
			line.setStartX(DataBox.xOffSet+(ShapeBuilder.getLength()));
			line.setEndX(DataBox.xOffSet+100);
			line.setStartY(DataBox.yOffSet+25);
			line.setEndY(DataBox.yOffSet+25);
			combinedPane.getChildren().addAll();
		}
	    
	}
	
	public LinkedListDataBox() 
	{
	  super();
	  LLDataNode node = new LLDataNode();
      DataBoxCollection.ps.add(node.box);
      DataBoxCollection.ps.add(node.boxTwo);
      DataBoxCollection.ps.add(node.boxThree);
      squareGroup.getChildren().addAll(node.combinedPane);
     
	}

   
}
