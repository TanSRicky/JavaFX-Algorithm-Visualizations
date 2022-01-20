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
	
	
		Polygon squareOne;
		Polygon squareTwo;
		
		Random r = new Random();
		StackPane combinedPane = new StackPane();
		Line line;
		LLDataNode next;
	    protected Text t = new Text();
	    
		public LLDataNode(double x, double y){
			
			line = new Line();
			value = r.nextInt(1000);
			this.changeValue(value);
			squareOne =  ShapeBuilder.square();
			squareOne.setTranslateX(x);
			t.setTranslateX(x);
			
			squareTwo =  ShapeBuilder.square();
			x+=ShapeBuilder.getLength();
			squareTwo.setTranslateX(x);
		
			line.setStartX(25);
			line.setEndX(50);
			line.setStartY(y+25);
			line.setEndY(y+25);
	
			x+=ShapeBuilder.getLength();
			line.setTranslateX(x);
			
			combinedPane.getChildren().addAll(squareOne,t,squareTwo,line);
			combinedPane.setLayoutX(x);
		    combinedPane.setLayoutY(y);
		 

			
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


		@Override
		protected Text getT() {
			// TODO Auto-generated method stub
			return null;
		}


	    
	}
	

