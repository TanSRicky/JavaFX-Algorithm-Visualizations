package ctci;


//Each data box collection has an FX sorts
//which provides a time line to it.

public class DataBoxCollection extends CollectionTemplate{
   
    public DataBoxCollection(){
 
     	
		 
    }
    
   public void OffSet() {

        if(xOffSet < 1500) {
        	xOffSet+=ShapeBuilder.getLength();
        
        } else if (xOffSet >= 700) {
        	xOffSet = ShapeBuilder.getLength();
        	yOffSet = yOffSet + ShapeBuilder.getLength();
        }
 	   
    }
	public void show() {
		// TODO Auto-generated method stub
		for (DataBoxTemplate d : ps) {
			squareGroup.getChildren().addAll(d.getStackPane());
		}
		
	}
       

	@Override
	public void populate() {
		// TODO Auto-generated method stub
		
		   	    DataBox d = new DataBox(xOffSet,yOffSet);
		   		squareGroup.getChildren().add(d.getStackPane());
		   		ps.add(d);
		   		OffSet();
		}

	@Override
	public void buttons() {
		// TODO Auto-generated method stub
		
	}
	}

