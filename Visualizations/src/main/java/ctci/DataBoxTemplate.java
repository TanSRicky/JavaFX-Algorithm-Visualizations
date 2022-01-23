package ctci;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public abstract class DataBoxTemplate   {

	Integer value = 0;
	Text t = new Text(value.toString());
	Text secondText =  new Text(value.toString());
	abstract StackPane getStackPane();

	abstract void setColor(Color orange);
	abstract Color getColor();

    public void update() {
     	this.t.setText(Integer.toString(this.value));
     	this.secondText.setText(Integer.toString(this.value));
    }

    public Text getT() {
    	return t;
    }
    public Text getSecondT() {
    	return secondText;
    }
    public boolean changeValue(int x) {
    	this.value = x;
    	this.secondText.setText(Integer.toString(x));
    	this.t.setText(Integer.toString(x));
    	return true;
    }



}
