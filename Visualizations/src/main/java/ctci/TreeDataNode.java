package ctci;

import java.util.Random;
import java.lang.Math;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

// Need to build collections class for this 
public class TreeDataNode extends DataBoxTemplate {
	static double xOffSet = ShapeBuilder.getLength();
	static double LeftOffSet = ShapeBuilder.getLength();
	static double yOffSet = ShapeBuilder.getLength();
	Circle circleOne = ShapeBuilder.circle();
	Random r = new Random();
	StackPane combinedPane = new StackPane();
	LineTo line = new LineTo();
	LineTo linetwo = new LineTo();
	LLDataNode next;
	int value = 0;
	protected Text t = new Text();
    static boolean left = true;
	double leftOffSet;
    double rightOffSet;
	static double radius;
	static double hypotenuse;
	static double scaleFactor = 10;
	public TreeDataNode() {
		MoveTo moveTo = new MoveTo(50,50);
		Path p = new Path(moveTo,line);
        if(left) {
        	combinedPane.getChildren().addAll(circleOne, t,p);
    		combinedPane.setLayoutX(LeftOffSet);
    		combinedPane.setLayoutY(yOffSet+50);
    		LeftOffSet -= 2*hypotenuse;
    		yOffSet += 2*hypotenuse;
        }
        else {
        	xOffSet+= 2*hypotenuse;
        	combinedPane.getChildren().addAll(circleOne, t,p);
    		combinedPane.setLayoutX(xOffSet);
    		combinedPane.setLayoutY(yOffSet+50);
    		
    	  
        }
		value = r.nextInt(1000);
		this.changeValue(value);
		
		radius = circleOne.getRadius();
	
		line.setX(100);
		line.setY(100);
		p.setTranslateX(50);
		p.setTranslateY(50);
		leftOffSet =circleOne.getTranslateX();
	    rightOffSet = 2*hypotenuse;
	    
	    System.out.println(radius);
	    System.out.println(p.toString());
	    System.out.println(line.toString());
	    System.out.println(linetwo.toString());

        
    	left = !left;
		

	}

    public double getLeftOffSet() {
		return leftOffSet;
	}


	public void setLeftOffSet(double leftOffSet) {
		this.leftOffSet = leftOffSet;
	}


	public double getRightOffSet() {
		return rightOffSet;
	}


	public void setRightOffSet(double rightOffSet) {
		this.rightOffSet = rightOffSet;
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