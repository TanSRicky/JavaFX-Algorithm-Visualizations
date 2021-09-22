package ctci;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DataBoxGravity extends DataBox {
	 
    private final double acceleration = .008;
    double hacceleration = 0.9;
    double velocity = 1;
    double hvelocity = 10;
    double height = 0;
    double floor = 700;
    double ceiling = 350;
    boolean bounce  = false;
    boolean falling = true;
    int bouncecount = 0;
    int flip = -1;
    double terminalVelocity = 50;
    double yPosition = super.getStackPane().getLayoutY();
    double xPosition = super.getStackPane().getLayoutX();
    boolean fall = true;
    boolean slide = true;
    boolean clickable = false;
    public DataBoxGravity() {
    	super();
    }
    public void fall() 
    {
           yPosition = super.getStackPane().getLayoutY();
           xPosition = super.getStackPane().getLayoutX();
		   final AnimationTimer timer = new AnimationTimer() 
		   {
	
	           @Override public void handle(final long currentNanoTime) 
	           {
	               try 
	               {
	
	               	  if(falling) 
	               	  {
		                   yPosition += velocity;
		                   if(velocity < terminalVelocity) velocity += acceleration;
	               	  }
	               	  else if (bounce && bouncecount < 100) 
	               	  {
	               		  yPosition -= velocity;
	               		  velocity -= acceleration+(acceleration);
	               		  if(velocity < 0)
	               		  {
	               			  bounce = false;
	               			  falling = true;
	               			  bouncecount++;
	               		  }
	               	  }
	               	  
	               	  
	               	  if( yPosition > floor ) 
	               	  {
	               		  
	               		  if (hvelocity/flip > 0) 
	               		  {
	               			  hvelocity = hvelocity + 0.45;
	               			  xPosition +=1;
	               		  }
	               		  
	               		  else 
	               		  {
	               			  hvelocity = hvelocity - 0.45;
	               			  xPosition -=1;
	               		  }
	
	               		  if(Math.round(hvelocity) == 0) {
	               			  slide = false;
	               		  }
	               		  falling = false;
	               		  bounce = true;
	
	
	               	  }
	
	               	 xPosition += hvelocity;
	               	 if(xPosition > 1000) 
	               	 {
	               	     xPosition -= 1;
	               	     hvelocity -= hacceleration;
	               		 hvelocity = flip*hvelocity;
	
	               	 }
	               	 if(xPosition < 0) {
	
	               		 xPosition += 1;
	               		 hvelocity += hacceleration;
	               		 hvelocity = flip*hvelocity;
	
	               	 }
	
	
	                 if(fall) getStackPane().setLayoutY(yPosition);
	               	 if(slide) getStackPane().setLayoutX(xPosition);
	
	                  }  catch (final Exception e) {
	
	                  }
	
	       }
	       };
	       
	      this.getStackPane().setOnMouseDragged(gravityHandler());
	      this.getStackPane().setOnMouseReleased(releaseHandler());
	      timer.start();
	
	   }
	   public EventHandler<MouseEvent> gravityHandler() {
			  return new EventHandler<MouseEvent>()
		      {	 @Override
		          public void handle(final MouseEvent event)
		          {
		              fall = false;
		              getStackPane().setLayoutX(getStackPane().getLayoutX()+ event.getX());
		              getStackPane().setLayoutY(getStackPane().getLayoutY()+ event.getY());
		
		          }
		      };
		  }
		  public EventHandler<MouseEvent> releaseHandler(){
			  return new EventHandler<MouseEvent>()
		      {	  @Override
		          public void handle(final MouseEvent event)
		          {
		      	    System.out.println("WHAT");
		      	    velocity = 1;
		      	    yPosition = getStackPane().getLayoutY()+event.getY();
		            bouncecount = 0;
		            fall = true;
		          }
		      };
		  }
}
