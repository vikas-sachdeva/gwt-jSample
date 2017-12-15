package gwt.jsample.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class TreeWidget {

	public Tree createTree() {

		TreeItem rootNode = new TreeItem();
		rootNode.setWidget(new Label("Root Node"));

		TreeItem firstNode = new TreeItem();
		firstNode.setWidget(new Label("First Node"));

		TreeItem secondNode = new TreeItem();
		secondNode.setWidget(new Label("Second Node"));

		TreeItem thirdNode = new TreeItem();
		thirdNode.setWidget(new Label("Third Node"));

		TreeItem firstNodeChild1 = new TreeItem();
		firstNodeChild1.setWidget(new Label("First Node Child - 1"));

		TreeItem firstNodeChild2 = new TreeItem();
		firstNodeChild2.setWidget(new Label("First Node Child - 2"));

		TreeItem firstNodeChild3 = new TreeItem();
		firstNodeChild3.setWidget(new Label("First Node Child - 3"));

		firstNode.addItem(firstNodeChild1);
		firstNode.addItem(firstNodeChild2);
		firstNode.addItem(firstNodeChild3);

		TreeItem secondNodeChild1 = new TreeItem();
		secondNodeChild1.setWidget(new Label("Second Node Child - 1"));

		TreeItem secondNodeChild2 = new TreeItem();
		secondNodeChild2.setWidget(new Label("Second Node Child - 2"));

		secondNode.addItem(secondNodeChild1);
		secondNode.addItem(secondNodeChild2);

		TreeItem thirdNodeChild1 = new TreeItem();
		thirdNodeChild1.setWidget(new Label("Third Node Child - 1"));

		TreeItem thirdNodeChild2 = new TreeItem();
		thirdNodeChild2.setWidget(new Label("Third Node Child - 2"));

		thirdNode.addItem(thirdNodeChild1);
		thirdNode.addItem(thirdNodeChild2);

		rootNode.addItem(firstNode);
		rootNode.addItem(secondNode);
		rootNode.addItem(thirdNode);

		Tree tree = new Tree();

		// add root item to the tree
		tree.addItem(rootNode);

		return tree;

	}
}
