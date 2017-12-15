package gwt.jsample.client;

import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TreePanelWidget {

	public Panel createTreePanel() {

		Tree tree = new TreeWidget().createTree();

		new TreeItemContextMenu(tree);

		VerticalPanel verticalPanel = new VerticalPanel();

		verticalPanel.setSpacing(20);
		verticalPanel.add(tree);

		return verticalPanel;
	}
}