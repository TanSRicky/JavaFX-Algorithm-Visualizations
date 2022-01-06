package ctci;

import java.util.Random;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

// Need to build collections class for this 
public class TreeDataNode extends DataBoxTemplate {

	Circle circleOne = ShapeBuilder.circle();
	Random r = new Random();
	StackPane combinedPane = new StackPane();

	LLDataNode next;
	int value = 0;
	protected Text t = new Text();
    static boolean left = true;
	static double radius;
	static double hypotenuse;
	static double scaleFactor = 10;
	public TreeDataNode(double x, double y) {


        combinedPane.getChildren().addAll(circleOne, t);
    	combinedPane.setLayoutX(x);
    	combinedPane.setLayoutY(y);

		value = r.nextInt(1000);
		this.changeValue(value);
		
		radius = circleOne.getRadius();
	
	
	    
	    System.out.println(radius);

	  

        
    	left = !left;
		

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
		this.circleOne.setFill(orange);

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