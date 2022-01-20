package ctci;

import javafx.beans.property.BooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

//Each data box collection has an FX sorts
//which provides a time line to it.

public class DataBoxCollection extends CollectionTemplate{
    private int cols = 5;
    public DataBoxCollection(BooleanProperty s){
    	super(s);

		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Pixel Grid creator");
		dialog.setHeaderText("Enter nodes, rows, columns for your pixel grid");
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		TextField columns  = new TextField();
		columns.setText("Columns");
		TextField rows = new TextField();
		rows.setText("Rows");
		grid.add(new Label("Columns:"), 0, 0);
		grid.add(columns, 1, 0);
		grid.add(new Label("Rows:"), 0, 1);
		grid.add(rows, 1, 1);
		dialog.getDialogPane().setContent(grid);
		dialog.showAndWait();
		System.out.println(rows.getText());
		System.out.println(columns.getText());
    }
    
   public void OffSet() {

        if(xOffSet < ShapeBuilder.getLength()*cols) {
        	xOffSet+=ShapeBuilder.getLength();
        
        } else if (xOffSet >= ShapeBuilder.getLength()*cols) {
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
       
	public void setCols(int c) {
		this.cols = c;
		
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

