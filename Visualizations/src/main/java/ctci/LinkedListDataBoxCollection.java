package ctci;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class LinkedListDataBoxCollection extends CollectionTemplate {
	LLDataNode sentinel;

	public LinkedListDataBoxCollection() {

		sentinel = new LLDataNode();
		sentinel.sentinel();
		squareGroup.getChildren().addAll(sentinel.combinedPane);
		ps.add(sentinel);

	}

	public void populate() {

		LLDataNode node = new LLDataNode();
		squareGroup.getChildren().addAll(node.combinedPane);
		LLDataNode tmp = (LLDataNode) ps.get(ps.size() - 1);
		tmp.next = node;
		ps.add(node);

	}

	public Group getSquareGroup() {
		// TODO Auto-generated method stub
		return this.squareGroup;
	}

}
