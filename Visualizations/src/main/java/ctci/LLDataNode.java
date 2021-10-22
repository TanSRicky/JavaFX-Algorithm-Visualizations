package ctci;

import java.util.Random;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

public class LLDataNode extends DataBoxTemplate{
	
		static double xOffSet = ShapeBuilder.getLength();
		static double yOffSet = ShapeBuilder.getLength();
		
		Polygon squareOne;
		Polygon squareTwo;
		
		Random r = new Random();
		StackPane combinedPane = new StackPane();
		Line line = new Line(); 
		LLDataNode next;
		
		int value = 0;
	    protected Text t = new Text();
	    
		public LLDataNode(){
			System.out.println("created");
			value = r.nextInt(1000);
			this.changeValue(value);
			squareOne =  ShapeBuilder.square();
			squareOne.setTranslateX(xOffSet);
			t.setTranslateX(xOffSet);
			squareTwo =  ShapeBuilder.square();
			offSet();
			squareTwo.setTranslateX(xOffSet);
			line.setTranslateX(xOffSet+50);
			line.setStartX(line.getTranslateX());
			line.setEndX(line.getTranslateX()+100);
			line.setStartY(yOffSet+25);
			line.setEndY(yOffSet+25);
			offSet();
			combinedPane.getChildren().addAll(squareOne,t,squareTwo,line);
			combinedPane.setLayoutX(xOffSet);
		    combinedPane.setLayoutY(yOffSet);
		 
		    
		}
		  
		public static void offSet() {
		
		       if(xOffSet < 1500) {
		       	xOffSet+=ShapeBuilder.getLength();
		       
		       } else if (xOffSet >= 700) {
		       	xOffSet = ShapeBuilder.getLength();
		       	yOffSet = yOffSet + ShapeBuilder.getLength();
		       }
			   
		   }
		
		@Override
		public StackPane getStackPane() {
			// TODO Auto-generated method stub
			return combinedPane;
			
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setColor(Color orange) {
			// TODO Auto-generated method stub
			this.squareOne.setFill(orange);
			
		}
	    public boolean changeValue(int x) {
	    	this.value = x;
	    	this.t.setText(Integer.toString(x));
	    	return true;
	    }  
	    public boolean sentinel() {
	    	this.value = 0;
	    	this.t.setText("NULL");
	    	return true;
	    }

		@Override
		Color getColor() {
			// TODO Auto-generated method stub
			return null;
		}


	    
	}
	

