package gwt.jsample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class UiBinderSvgImageClient implements EntryPoint {

	@Override
	public void onModuleLoad() {
		CustomSvgWidget customWidget = new CustomSvgWidget();

		// add the tree to the root panel
		RootPanel.get("gwtContainer").add(customWidget);
	}

}
