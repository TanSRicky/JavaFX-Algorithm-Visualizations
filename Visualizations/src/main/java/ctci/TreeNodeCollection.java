package ctci;

import java.util.ArrayList;
import java.util.Collections;

import javafx.beans.property.BooleanProperty;
import javafx.geometry.Point2D;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class TreeNodeCollection extends CollectionTemplate {
	int level = 0;

	
	public TreeNodeCollection(BooleanProperty s) {
		super(s);
		
		Path path = new Path();
		path.getElements().add(new MoveTo(0.0f, 50.0f));
		path.getElements().add(new LineTo(100.0f, 100.0f));
		this.xOffSet = -475;
		double startSet = -481.5;
		TreeDataNode t;
	
		level++;
		double spacing = 20;																	

	   //probably better to reflect off of the 0 point to each side, and work from inside
	    	          //This way guarantees space for the nodes on the inside  or start from btm
		ArrayList<Point2D> points = new ArrayList<>();
		for (int i = 4; i > 0; i--) {
			for (int j = 0; j < Math.pow(2,i); j++ ) {
				
				t  = new TreeDataNode(xOffSet,yOffSet);
				points.add(new Point2D(xOffSet,yOffSet));
				squareGroup.getChildren().addAll(t.combinedPane);
				ps.add(t);
				xOffSet += spacing;
			}
			xOffSet = startSet+spacing;
			spacing = 2 * spacing;
			yOffSet -=30; 
		
	
		}

		squareGroup.setTranslateX(500);
		Collections.reverse(points);
		System.out.println(points);
		
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
