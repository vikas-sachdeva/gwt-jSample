package gwt.jsample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Widget;

public class GridPanelWidget extends Composite {

	@UiField
	Grid grid;

	public GridPanelWidget() {
		initWidget(binder.createAndBindUi(this));

		for (int i = 1; i < grid.getRowCount(); i++) {

			grid.setText(i, 0, "Property " + i);
			grid.setText(i, 1, "Value " + i);

		}
	}

	/**
	 * This basically creates a class that can render template on demand.
	 */
	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, GridPanelWidget> {
	}
}
