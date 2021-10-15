package ctci;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * JavaFX App
 */

public class App extends Application {
	Scene scene ;
	PaneBuilder pb = new PaneBuilder();
	
    @Override
    public void start(Stage primaryStage) throws IOException {
	       
    	System.out.println("What");
	
	    	scene  = new Scene(pb.extracted(),1920,1080);
	     	primaryStage.setScene(scene);
	    	primaryStage.show();
	   	 
    }

	

 
    
    public static void main(String[] args) {
        launch();
    }
}
