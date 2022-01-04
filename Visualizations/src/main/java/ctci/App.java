package ctci;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;


// TODO: Auto-generated Javadoc
/**
 * JavaFX App.
 * https://stackoverflow.com/a/53237667 
 * javadoc link; need to fix IDE to generate javadoc 
 */

public class App extends Application {
	
	/** The scene. */
	Scene scene ;
	
	/** The pb. */
	PrimaryPane pb = new PrimaryPane();
	
    /**
     * Start.
     *
     * @param primaryStage the primary stage
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

    		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	    	scene  = new Scene(pb.getGroup(),primaryScreenBounds.getMinX(),primaryScreenBounds.getMinY());
	     	primaryStage.setScene(scene);
	    	primaryStage.show();
	   	 
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        launch();
    }
}
