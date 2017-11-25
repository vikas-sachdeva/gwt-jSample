package gwt.jsample.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TreePanelWidget {

	private TreeItem selectedTreeItem;

	private Button addButton;

	private Button deleteButton;

	public Panel createTreePanel() {

		Tree tree = new TreeWidget().createTree();

		tree.addSelectionHandler(event -> this.selectedTreeItem = event.getSelectedItem());

		VerticalPanel verticalPanel = new VerticalPanel();

		verticalPanel.setSpacing(20);
		verticalPanel.add(tree);
		addButtons(verticalPanel);

		return verticalPanel;

	}

	private void addButtons(VerticalPanel verticalPanel) {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(20);

		addButton = new Button();
		addButton.setText("Add");
		addButton.addClickHandler(this::buttonClickHandler);

		deleteButton = new Button();
		deleteButton.setText("Delete");
		deleteButton.addClickHandler(this::buttonClickHandler);

		horizontalPanel.add(addButton);
		horizontalPanel.add(deleteButton);

		verticalPanel.add(horizontalPanel);
	}

	private void buttonClickHandler(ClickEvent event) {

		if (selectedTreeItem == null) {
			Window.alert("Please select a tree item");
		} else {

			if (event.getSource() == addButton) {

				if (selectedTreeItem.getParentItem() == null) {
					Window.alert("Can not add parallel element for root node");
				}

				TreeItem treeItem = new TreeItem();
				treeItem.setText("New Element");
				int currentIndex = selectedTreeItem.getParentItem().getChildIndex(selectedTreeItem);
				selectedTreeItem.getParentItem().insertItem(currentIndex + 1, treeItem);
				selectedTreeItem.setSelected(false);
				selectedTreeItem = null;
			} else {
				selectedTreeItem.remove();
				selectedTreeItem = null;
			}
		}
	}
}