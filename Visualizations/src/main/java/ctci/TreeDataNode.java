package ctci;

import java.util.Random;
import java.lang.Math;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

// Need to build collections class for this 
public class TreeDataNode extends DataBoxTemplate {
	static double xOffSet = ShapeBuilder.getLength();
	static double yOffSet = ShapeBuilder.getLength();
	Circle circleOne;
	Circle circleTwo;
	Random r = new Random();
	StackPane combinedPane = new StackPane();
	Line line = new Line();
	Line linetwo = new Line();
	LLDataNode next;
	int value = 0;
	protected Text t = new Text();

	public TreeDataNode() {
		value = r.nextInt(1000);

		this.changeValue(value);
		circleOne = ShapeBuilder.circle();
		circleOne.setTranslateX(xOffSet);

	
		double r = circleOne.getRadius();
		double hypotenuse = Math.sqrt(Math.pow(r, 2) + Math.pow(r, 2));
		circleOne.setTranslateX(hypotenuse);
		line.setTranslateX(2*hypotenuse);
		t.setTranslateX(hypotenuse);
		line.setTranslateY(hypotenuse);
		line.setStartX(circleOne.getCenterX());
		line.setEndX(hypotenuse);
		line.setStartY(circleOne.getCenterY());
		line.setEndY(hypotenuse);

	
		linetwo.setTranslateY(hypotenuse);
		linetwo.setStartX(circleOne.getCenterX());
		linetwo.setEndX(circleOne.getCenterX() - hypotenuse);
		linetwo.setStartY(circleOne.getCenterY());
		linetwo.setEndY(hypotenuse);
		xOffSet += 2*hypotenuse;
		yOffSet += 2*hypotenuse;
		combinedPane.getChildren().addAll(circleOne, t, linetwo, line);
		combinedPane.setLayoutX(xOffSet);
		combinedPane.setLayoutY(yOffSet+50);

	}

	public static void offSet() {

		

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
