package ctci;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import java.util.Random;

public class  DataBox  extends DataBoxTemplate {
	
	
     protected Polygon square;
     protected StackPane s = new StackPane();
	 final Label label = new Label("c");
	 final ContextMenu contextMenu = new ContextMenu();
	 final MenuItem item = new MenuItem("Change value");
     protected Text t = new Text();
     static int DataBoxCounter = 1;
     int index = 0;
     static Random r = new Random(); 
     
    
     public DataBox (double x, double y){
   
    	 value = r.nextInt(255);
         square =  ShapeBuilder.square();
         menu();
         this.index = DataBoxCounter;
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
    @SuppressWarnings("unchecked")
	private void menu() {

	    item.setOnAction(new EventHandler<ActionEvent>() {
	    	
	    	@Override
	        public void handle(final ActionEvent event) {
	            
	         }
		
        });
	    
	 
	    contextMenu.getItems().addAll(item);
	 	s.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            
            public void handle(final ContextMenuEvent event) {
                contextMenu.show(s, event.getScreenX(), event.getScreenY());
            }
            
        });

		
	
	    
    
    }



   
	


}
