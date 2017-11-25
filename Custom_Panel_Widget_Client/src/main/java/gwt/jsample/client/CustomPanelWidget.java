package gwt.jsample.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class CustomPanelWidget extends Composite {

	public CustomPanelWidget() {
		Button addButton = new Button("Add");
		addButton.getElement().setId("addButton");
		addButton.addClickHandler((event) -> Window.alert("Add button clicked"));
		
		Button deleteButton = new Button("Delete");
		deleteButton.getElement().setId("deleteButton");
		deleteButton.addClickHandler((event) -> Window.alert("Delete button clicked"));

		HorizontalPanel panel = new HorizontalPanel();
		panel.add(addButton);
		panel.add(deleteButton);
		
		initWidget(panel);

	}
}
