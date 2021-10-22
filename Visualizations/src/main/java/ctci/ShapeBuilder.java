package ctci;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import java.util.Random;
public class ShapeBuilder
{
	static Polygon polygon;
	static Circle circle;
    private static Double length = 40.0;
	private static Double y = getLength()*2;
	private static  Double x = getLength();
	static Random rand = new Random();

	
    static Polygon square()
    {
    	polygon = new Polygon();
    	polygon.setFill(new Color(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble()));
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeWidth(length/10);
        
        polygon.getPoints().addAll(
        		new Double[]
        		{
                x, y,       
                getLength()+x,y,	  
                getLength()+x,getLength()+y,    
                x,getLength() +y       
                }                         );
        
        return polygon;
	}

    static Circle circle() 
    {
    	Color c = new Color(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble());
    	circle = new Circle();
    	circle.setFill(c);
        circle.setStroke(Color.BLACK);
        // set the position of center of the  circle
        circle.setCenterX(0.0f);
        circle.setCenterY(0.0f);
  
        // set Radius of the circle
        circle.setRadius(length/2);
  
        return circle;
	}

	public static Double getLength() {
		return length;
	}

	public static void setLength(Double length) {
		ShapeBuilder.length = length;
	}


}
