package ctci;

import java.util.Collection;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class TreeNodeCollection extends CollectionTemplate {

	public TreeNodeCollection() {
		TreeDataNode t  = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
	}
	
	
	
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		TreeDataNode t  = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);

	}




	@Override
	public void OffSet() {
		// TODO Auto-generated method stub
		
	}
}
