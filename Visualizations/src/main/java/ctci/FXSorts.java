package ctci;


import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FXSorts {
	
	static double rate = .1;
    ArrayList<DataBox> ps = new ArrayList<DataBox>();
	final static IntegerProperty x = new SimpleIntegerProperty(0);
	static int quickSortQ = 0;
     Timeline timeline = new Timeline();
     
	public FXSorts(ArrayList<DataBox> ps2) {
		ps = ps2;
    	timeline.setCycleCount(Animation.INDEFINITE);
	}
	

	public void swap(int i, int j) {
		
		ps.get(j).setColor(Color.ORANGE);
    	ps.get(i).setColor(Color.LIGHTPINK);
		var tmp =  ps.get(i).value;
		ps.get(i).value = ps.get(j).value;
		ps.get(j).value = tmp;
		
	 }
    public  void stop() {
    	timeline.stop();
    }


	public  void bubbleSort() {

		timeline.getKeyFrames().add(new KeyFrame(
		        Duration.seconds(rate),
		        event -> {        x.set(x.get() + 1);
		        	            for (int i11 = 0; i11 < ps.size()-1; i11++) 
		        	    	    {
		        	    	       
		        	    	    	if(ps.get(i11).value > ps.get(i11+1).value) {
		        	    	    		swap(i11,i11+1);
		        	    	    		ps.get(i11).update();
		        	    	    		ps.get(i11+1).update();
		        	    	 
		        	    	    	}
		        	    	  			
		        	    	    	    
		        	    	    } 
		        	            
	    
		        }));      
	    
		  timeline.play();
		  
	}

	public  void QuickSort(int l, int r) 
	{
		
		timeline =new Timeline(	new KeyFrame(
	       Duration.seconds(rate),
	        event -> 
	        {
	        x.set(x.get() + 1);
	        int q;
		         if(l < r) 
		         	{
				    	q=partitiontest(l,r);	
				    	ps.get(q).setColor(Color.RED);
				        ps.get(q).update();
						QuickSort(l,q-1);
						QuickSort(q+1,r);
				
		         	}      
	    
	        }));
			timeline.play();
	}
	public int partitiontest(int l, int r) {
	
		timeline.getKeyFrames().add(new KeyFrame(
	        Duration.seconds(rate),
	        event -> {
	            x.set(x.get() + 1);
	            ps.get(l).setColor(Color.BLUE);
	           	ps.get(l).update();

	    	    ps.get(r).setColor(Color.ORANGE);
	           	ps.get(r).update();
	    
	        
	        
	        } 
	        
	    ));
	       

	        	      
	        int left =l-1;
	     
	        int xr = ps.get(r).value;
	        for(int i = l; i < r; i++) {
	         
	        
	        	if(ps.get(i).value < xr) {
	        	    left++;
	        	    swap(left,i);
	        		final int tmp = i;
	        		final int tmpa = left;
	        		timeline.getKeyFrames().add(new KeyFrame(
	        	        Duration.seconds(rate),
	        	        event -> {
	        	            x.set(x.get() + 1);
	        	        	ps.get(tmp).setColor(Color.BLUE);
	    		         	ps.get(tmp).update();
	    		        	ps.get(tmpa).setColor(Color.BLUE);
	    		        	ps.get(tmpa).update();
	        	        
	        	        
	        	        } 
	        	        
	        	    ));
	        	       
	          
		         	ps.get(i).update();
	
		        	ps.get(left).update();
	     
	           }
	       }
	        
	        
	        
	           swap(left+1,r);
		     

	      	
	        	        
	        	        
	       return left+1;
	  } 
	
	public void partitionQS(int p,int l, int r) {
	
        timeline.pause();
		timeline = new Timeline(
				
	    	    new KeyFrame(
	        	        Duration.seconds(3),
	        	        event -> {
	        	            x.set(x.get() + 1);
	        	            ps.get(p).setColor(Color.RED);
	        	            for(int a = p-1; a>l; a--)   ps.get(a).setColor(Color.LIGHTBLUE);
		        	        for(int b = p+1; b<r; b++)   ps.get(b).setColor(Color.ORANGE);


	        	          } 
	        	        
	        	    )
	        	);
		timeline.setCycleCount(1);
		timeline.play();

}
	}
