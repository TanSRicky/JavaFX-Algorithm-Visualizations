package ctci;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public abstract class DataBoxTemplate   {

	Integer value = null;
	abstract StackPane getStackPane();
	abstract void update();
	abstract void setColor(Color orange);
	abstract Color getColor();
	abstract boolean changeValue(int x);


}
