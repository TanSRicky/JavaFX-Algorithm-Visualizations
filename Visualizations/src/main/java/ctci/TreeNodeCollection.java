package ctci;

import java.util.Collection;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class TreeNodeCollection extends CollectionTemplate {
	int level = 0;
    int mersennePrime = (int) (Math.pow(2,level)-1); //Use Mersenne Primes to count the nodes as you add them -> increment level once
    											   	// ps.size() reaches a Mersenne prime(maximum node for current level)
	
	public TreeNodeCollection() {
		this.xOffSet = 0;
		TreeDataNode t  = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		level++;
																			
	    yOffSet += 25;//attempts to figure out spacing
	    xOffSet = -100;//probably better to reflect off of the 0 point to each side, and work from inside
	    	          //This way guarantees space for the nodes on the inside 
		
		t = new TreeDataNode(xOffSet,yOffSet);
		
	    squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		
		
		xOffSet = 150;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		
		level++;
		yOffSet += 25;
		xOffSet = -300;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet = -100;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet = 100;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet = 200;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		
		
		
		yOffSet += 25;
		xOffSet = -400;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet = -250;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet = -125;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet = -25;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet =25;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		
		xOffSet = 75;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet = 150;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		xOffSet = 225;
		t = new TreeDataNode(xOffSet,yOffSet);
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
		
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
