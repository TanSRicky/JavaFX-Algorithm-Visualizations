package ctci;

import javafx.beans.property.BooleanProperty;
import javafx.scene.Group;

public class LLCollection extends DataBoxCollection {

	LLDataNode sentinel;
	
	public LLCollection(BooleanProperty selected) {
		super(selected);
		sentinel = new LLDataNode(xOffSet+(ShapeBuilder.getLength()/2),yOffSet);
		sentinel.sentinel();
		squareGroup.getChildren().addAll(sentinel.combinedPane);
		ps.add(sentinel);
		this.OffSet();

	}
	
     @Override
	public void populate() {
		
		LLDataNode node = new LLDataNode(xOffSet,yOffSet);
		node.combinedPane.setTranslateX(xOffSet);
		squareGroup.getChildren().addAll(node.combinedPane);
		LLDataNode tmp = (LLDataNode) ps.get(ps.size() - 1);
		tmp.next = node;
		ps.add(node);
		this.OffSet();

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
