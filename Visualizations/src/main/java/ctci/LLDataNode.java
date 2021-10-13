package ctci;

import java.util.Random;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

public class LLDataNode extends Pane implements DataBoxTemplate{
		static double xOffSet = ShapeBuilder.getLength();
		static double yOffSet = ShapeBuilder.getLength();
		Polygon squareOne;
		Polygon squareTwo;
		Random r = new Random();
		StackPane combinedPane = new StackPane();
		Line line = new Line(); 
		int value = 0;
	    protected Text t = new Text();
	    
		public LLDataNode(){
			value = r.nextInt(1000);
			squareOne =  ShapeBuilder.square();
			squareTwo =  ShapeBuilder.square();
			line.setStartX(xOffSet+(ShapeBuilder.getLength()));
			line.setEndX(xOffSet+100);
			line.setStartY(yOffSet+25);
			line.setEndY(yOffSet+25);
			combinedPane.getChildren().addAll(squareOne,t,squareTwo);
			combinedPane.setLayoutX(xOffSet);
		    combinedPane.setLayoutY(yOffSet);
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

	    
	}
	

