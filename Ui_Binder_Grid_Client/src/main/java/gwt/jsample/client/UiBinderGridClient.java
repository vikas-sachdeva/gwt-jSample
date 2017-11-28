package gwt.jsample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class UiBinderGridClient implements EntryPoint {

	@Override
	public void onModuleLoad() {

		GridPanelWidget gridPanelWidget = new GridPanelWidget();
		
		RootPanel.get("gwtContainer").add(gridPanelWidget);
	}

}
