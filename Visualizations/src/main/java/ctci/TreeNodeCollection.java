package ctci;

import javafx.beans.property.BooleanProperty;

public class TreeNodeCollection extends CollectionTemplate {
	int level = 0;

	
	public TreeNodeCollection(BooleanProperty s) {
		super(s);
		this.xOffSet = -475;
		int startSet = -750;
		TreeDataNode t;
	
		level++;
		int spacing = 10;																	

	   //probably better to reflect off of the 0 point to each side, and work from inside
	    	          //This way guarantees space for the nodes on the inside  or start from btm
		for (int i = 10; i >=0 ; i--) {
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
		
		squareGroup.setScaleX(.7);
		
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




	@Override
	public void buttons() {
		// TODO Auto-generated method stub
		
	}
}
