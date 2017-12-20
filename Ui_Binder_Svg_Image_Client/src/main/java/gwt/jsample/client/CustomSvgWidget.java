package gwt.jsample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CustomSvgWidget extends Composite {

	public CustomSvgWidget() {
		initWidget(binder.createAndBindUi(this));
	}

	/**
	 * This basically creates a class that can render template on demand.
	 */
	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, CustomSvgWidget> {
	}
}
