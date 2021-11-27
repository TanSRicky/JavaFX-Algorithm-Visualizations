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
		super.OffSet();

	}

	public void populate() {

		LLDataNode node = new LLDataNode(xOffSet,yOffSet);
		node.combinedPane.setTranslateX(xOffSet);
		squareGroup.getChildren().addAll(node.combinedPane);
		LLDataNode tmp = (LLDataNode) ps.get(ps.size() - 1);
		tmp.next = node;
		ps.add(node);
		super.OffSet();

	}

	public Group getSquareGroup() {
		// TODO Auto-generated method stub
		return this.squareGroup;
	}

	   public void OffSet() {
	        
	        if(xOffSet < 1500) {
	        	xOffSet+=ShapeBuilder.getLength()*6;
	        
	        } else if (xOffSet >= 700) {
	        	xOffSet = ShapeBuilder.getLength();
	        	yOffSet = yOffSet + ShapeBuilder.getLength();
	        }
	 	   
	    }

}
