package ctci;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public abstract class DataBoxTemplate   {

	Integer value = null;
	Text t;
	abstract StackPane getStackPane();
	abstract void update();
	abstract void setColor(Color orange);
	abstract Color getColor();
	abstract boolean changeValue(int x);
	protected abstract Text getT();


}
