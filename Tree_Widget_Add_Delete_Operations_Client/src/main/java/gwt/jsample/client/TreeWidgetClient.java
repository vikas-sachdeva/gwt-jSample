package gwt.jsample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class TreeWidgetClient implements EntryPoint {

	@Override
	public void onModuleLoad() {

		RootPanel.get("gwtContainer").add(new TreePanelWidget().createTreePanel());
	}


}