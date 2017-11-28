package gwt.jsample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloUiBinderClient implements EntryPoint {

	@Override
	public void onModuleLoad() {
		CustomWidget customWidget = new CustomWidget();

		customWidget.setMessage(
				"Security awareness and training are typically covered under the single heading of Information Security Awareness Training.  This high-level approach is appropriate for many organizations, especially those with tenuous management commitment and a meager budget.  However, awareness and training, when part of a formal methodology for employee behavior modification, are actually two different activities.");

		// add the tree to the root panel
		RootPanel.get("gwtContainer").add(customWidget);
	}
}
