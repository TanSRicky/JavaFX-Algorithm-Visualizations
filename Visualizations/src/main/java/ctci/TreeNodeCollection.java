package ctci;

import java.util.Collection;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class TreeNodeCollection extends CollectionTemplate {
	int level = 0;

	
	public TreeNodeCollection() {
		this.xOffSet = -475;
		int startSet = -500;
		TreeDataNode t;
	
		level++;
		int spacing = 50;																	

	   //probably better to reflect off of the 0 point to each side, and work from inside
	    	          //This way guarantees space for the nodes on the inside  or start from btm
		for (int i = 5; i >=0 ; i--) {
			for (int j = 0; j < Math.pow(2,i); j++ ) {
				t  = new TreeDataNode(xOffSet,yOffSet);
				squareGroup.getChildren().addAll(t.combinedPane);
				ps.add(t);
				xOffSet += spacing;
			}
			xOffSet = startSet+spacing;
			spacing = 2 * spacing;

			yOffSet -=30; 
		 

		
		
		}
		
		
	}
	
	
	
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		TreeDataNode t  = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		this.OffSet();

	}




	@Override
	public void OffSet() {
	
	
	
		
		
		
	}   
	public static int log2(int N)
    {
  
 
        int result = (int)(Math.log(N) / Math.log(2));
  
        return result;
    }
}
