package ctci;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LLDataNode{

		DataBox box  = new DataBox();
		DataBox boxTwo  = new DataBox();
		DataBox boxThree= new DataBox();
		Pane combinedPane = new Pane();
		Line line = new Line();
		
		public LLDataNode(){
			line.setStartX(DataBox.xOffSet+(ShapeBuilder.getLength()));
			line.setEndX(DataBox.xOffSet+100);
			line.setStartY(DataBox.yOffSet+25);
			line.setEndY(DataBox.yOffSet+25);
			combinedPane.getChildren().addAll();
		}
	    
	}
	

