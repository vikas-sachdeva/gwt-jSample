package gwt.jsample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.jsample.button.SvgImageBundle;
import gwt.jsample.button.SvgImageButtonWidget;

public class CustomHorizontalPanelWidget extends Composite {

	@UiField
	HorizontalPanel horizontalPanel;

	public CustomHorizontalPanelWidget() {
		initWidget(binder.createAndBindUi(this));
		addSvgButtons();
	}

	private void addSvgButtons() {
		addButton();
		deleteButton();
	}

	private void deleteButton() {
		SvgImageButtonWidget deleteButton = new SvgImageButtonWidget(SvgImageBundle.INSTANCE.delete());
		deleteButton.registerClickHandler((event) -> Window.alert("Delete button clicked"));

		horizontalPanel.add(deleteButton);

	}

	private void addButton() {
		SvgImageButtonWidget addButton = new SvgImageButtonWidget(SvgImageBundle.INSTANCE.add());

		addButton.registerClickHandler((event) -> Window.alert("Add button clicked"));
		horizontalPanel.add(addButton);

	}

	/**
	 * This basically creates a class that can render template on demand.
	 */
	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, CustomHorizontalPanelWidget> {
	}
}