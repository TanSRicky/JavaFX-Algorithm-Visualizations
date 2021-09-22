package ctci;

import java.util.Stack;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.Random;
public class  DataBox extends Pane{
	 static double xOffSet = ShapeBuilder.getLength();
     static double yOffSet = ShapeBuilder.getLength();
     private static Stack<StackPane> buffer = new Stack<>();
     protected Polygon square;
     private Circle circle;
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
    
   
	
//    void squareColor() {
//    	
//    	 FillTransition ft = new FillTransition(Duration.millis(1), square, Color.RED, Color.BLUE);
//         ft.setCycleCount(4);
//         ft.setAutoReverse(true);
//         ft.play();
//         ft = new FillTransition(Duration.millis(3000), square, Color.RED, Color.AQUAMARINE);
//         ft.setCycleCount(4);
//         ft.setAutoReverse(true);
//         ft.play();
//    
//    }
//
//
//



}
