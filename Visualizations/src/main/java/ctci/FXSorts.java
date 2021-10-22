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
    ArrayList<DataBoxTemplate> ps = new ArrayList<DataBoxTemplate>();
	final static IntegerProperty x = new SimpleIntegerProperty(0);
	static int quickSortQ = 0;
     Timeline timeline = new Timeline();
     int swaps = 0;
     
	public FXSorts(ArrayList<DataBoxTemplate> ps2) {
		ps = ps2;
    	timeline.setCycleCount(0);
	}
	
	
	public void swap(int i, int j) {
	
		 DataBoxTemplate tmp = ps.get(i);
	     DataBoxTemplate tmp2 = ps.get(j);
	
		Color ctmp = tmp.getColor();
		tmp.setColor(tmp2.getColor());
		tmp2.setColor(ctmp);
    		       
            
		int nTmp = tmp.value;
		tmp.value = tmp2.value;
		tmp2.value = nTmp;
		swaps++;
		
	
	 }
    public  void stop() {
    	timeline.stop();
    }


	public  void bubbleSort() {

		

		
			for (int i11 = 0; i11 < ps.size() - 1; i11++) {
				final int index = i11;
				final DataBoxTemplate tmp = ps.get(index);
				final DataBoxTemplate tmp2 = ps.get(index + 1);
				timeline.setCycleCount(timeline.getCycleCount()+1);
				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(rate), event -> {
					
					
				if (tmp.value > tmp2.value) {
							
						
							swap(index, index + 1);
						
						}
	
				}));
				}
			   

			
			
		

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
				    
						QuickSort(l,q-1);
						QuickSort(q+1,r);
				
		         	}      
	    
	        }));
		timeline.play();
		System.out.println(swaps);
	}
	public int partitiontest(int l, int r) {
      
	        int left =l-1;
	     
	        int xr = ps.get(r).value;
	        for(int i = l; i < r; i++) {
	         
	        
	        	if(ps.get(i).value < xr) {
	        	    left++;
	        	    swap(left,i);

	           }
	       }
	        
	        
	        
	           swap(left+1,r);
 
	       return left+1;
	  } 
	
	 
	}
