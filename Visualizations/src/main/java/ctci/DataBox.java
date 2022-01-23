 package ctci;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import java.util.Random;

public class  DataBox  extends DataBoxTemplate {

     private Polygon square;
     private StackPane s = new StackPane();
     static Random r = new Random(); 
     static int DataBoxCounter = 1;

    
     public DataBox (double x, double y){
 		super();
    
    	 value = r.nextInt(255);
    	 
         square =  ShapeBuilder.square();
         this.changeValue(value);
         setColor(Color.rgb(0,0, value, ((double)value/255.0)));
         s.getChildren().addAll(square,t);
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


    public void update() {
     	this.t.setText(Integer.toString(this.value));
     	this.secondText.setText(Integer.toString(this.value));
    }


	


}
