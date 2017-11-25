package gwt.jsample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class CustomPanelWidgetClient implements EntryPoint {

	@Override
	public void onModuleLoad() {
		
		RootPanel panel = RootPanel.get("gwtContainer");
		
		panel.add(new CustomPanelWidget());
	}
}
