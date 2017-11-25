package gwt.jsample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TreeWidgetClient implements EntryPoint {

	@Override
	public void onModuleLoad() {

		Tree tree = new TreeWidget().createTree();

		Label label = new Label();
		tree.addSelectionHandler(event -> label.setText(event.getSelectedItem().getText()));
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(20);
		panel.add(tree);
		panel.add(label);

		RootPanel.get("gwtContainer").add(panel);

	}
}
