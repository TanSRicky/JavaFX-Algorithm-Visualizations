package ctci;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class LinkedListDataBoxCollection extends DataBoxCollection {
	LLDataNode sentinel;

	public LinkedListDataBoxCollection() {

		sentinel = new LLDataNode(xOffSet,yOffSet);
		sentinel.sentinel();
		squareGroup.getChildren().addAll(sentinel.combinedPane);
		ps.add(sentinel);


	}

	public void populate() {
	
		LLDataNode node = new LLDataNode(xOffSet,yOffSet);
		node.combinedPane.setTranslateX(xOffSet);
		squareGroup.getChildren().addAll(node.combinedPane);
		LLDataNode tmp = (LLDataNode) ps.get(ps.size() - 1);
		tmp.next = node;
		ps.add(node);
		this.OffSet();

	}

	public Group getSquareGroup() {
		// TODO Auto-generated method stub
		return this.squareGroup;
	}
	@Override
	   public void OffSet() {
	        System.out.println(xOffSet);
	        if(xOffSet < 700) {
	        	xOffSet+=ShapeBuilder.getLength();
	        
	        } else if (xOffSet >= 700) {
	        	xOffSet = 0;
	        	yOffSet = yOffSet + ShapeBuilder.getLength();
	        }
	 	   
	    }

}
