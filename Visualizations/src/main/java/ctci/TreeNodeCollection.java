package ctci;

public class TreeNodeCollection extends CollectionTemplate {
    
	
	
	
	public TreeNodeCollection() {
		
	}
	
	
	
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		TreeDataNode t = new TreeDataNode();
		squareGroup.getChildren().addAll(t.combinedPane);
		ps.add(t);
	}

}