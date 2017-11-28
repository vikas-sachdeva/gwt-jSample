package gwt.jsample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CustomHorizontalPanelWidget extends Composite {

	@UiField
	Button addButton;

	@UiField
	Button deleteButton;

	public CustomHorizontalPanelWidget() {
		initWidget(binder.createAndBindUi(this));

	}

	@UiHandler("addButton")
	void handleAddButtonClick(ClickEvent e) {
		Window.alert("Clicked on Add button");
	}

	@UiHandler("deleteButton")
	void handleDeleteButtonClick(ClickEvent e) {
		Window.alert("Clicked on Delete button");
	}

	/**
	 * This basically creates a class that can render template on demand.
	 */
	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, CustomHorizontalPanelWidget> {
	}

}