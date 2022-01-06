 package ctci;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import java.util.Random;

public class  DataBox  extends DataBoxTemplate {
	

	
     private Polygon square;
     private StackPane s = new StackPane();
     private Text t = new Text();
     static Random r = new Random(); 
     static int DataBoxCounter = 1;

     
    
     public DataBox (double x, double y){
   
    	 value = r.nextInt(255);
         square =  ShapeBuilder.square();
         changeValue(value);
         setColor(Color.rgb(0,0, value, ((double)value/255.0)));
         s.getChildren().addAll(square);
  	     s.setLayoutX(x);
         s.setLayoutY(y);
         DataBoxCounter++;
      }



    public StackPane getStackPane() {
    	return this.s;
    }


    public void setColor(Color c) {
    	this.square.setFill(c);
    }
    @Override
    public Color getColor() {
    	return (Color) this.square.getFill();
    }
    public boolean changeValue(int x) {
    	this.value = x;
    	this.t.setText(Integer.toString(x));
    	return true;
    }


    public void update() {
    
    	
   
    }


	


}
