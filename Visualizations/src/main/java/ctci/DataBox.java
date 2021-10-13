package ctci;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import java.util.Random;

public class  DataBox extends Pane implements DataBoxTemplate {
	
	 static double xOffSet = ShapeBuilder.getLength();
     static double yOffSet = ShapeBuilder.getLength();
     protected Polygon square;
     protected StackPane s = new StackPane();
	 final Label label = new Label("c");
	 final ContextMenu contextMenu = new ContextMenu();
	 final MenuItem item = new MenuItem("Change value");
     protected Text t = new Text();
     static int DataBoxCounter = 1;
     int index = 0;
     Random r = new Random();
     int value;
    
     public DataBox (){
    	value = r.nextInt(1000);
        square =  ShapeBuilder.square();
        menu();
        this.index = DataBoxCounter;
        changeValue(value);
        OffSet();
        s.getChildren().addAll(square,t);
 	    s.setLayoutX(xOffSet);
        s.setLayoutY(yOffSet);
  
      }


   public static void OffSet() {
       DataBoxCounter++;
       if(xOffSet < 1500) {
       	xOffSet+=ShapeBuilder.getLength();
       
       } else if (xOffSet >= 700) {
       	xOffSet = ShapeBuilder.getLength();
       	yOffSet = yOffSet + ShapeBuilder.getLength();
       }
	   
   }
    public StackPane getStackPane() {
    	return this.s;
    }


    public void setColor(Color c) {
    	this.square.setFill(c);
    }
    public boolean changeValue(int x) {
    	this.value = x;
    	this.t.setText(Integer.toString(x));
    	return true;
    }


    public void update() {
    
    	this.t.setText(Integer.toString(this.value));
   
    }
    @SuppressWarnings("unchecked")
	private void menu() {

	    item.setOnAction(new EventHandler<ActionEvent>() {
	    	
	    	@Override
	        public void handle(final ActionEvent event) {
	            
	         }
		
        });
	    

	    final MenuItem move = new MenuItem("Move");
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
