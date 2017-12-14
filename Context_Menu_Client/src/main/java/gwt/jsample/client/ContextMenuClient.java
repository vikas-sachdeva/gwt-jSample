package gwt.jsample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class ContextMenuClient implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel panel = RootPanel.get("gwtContainer");
		Label label = new Label("Label with Context Menu");
		createContextMenu(label);
		panel.add(label);
	}

	private void createContextMenu(Label label) {

		PopupPanel popupPanel = createPopupPanel();

		label.sinkEvents(Event.ONCONTEXTMENU);
		label.addHandler((event) -> {
			event.preventDefault();
			event.stopPropagation();
			popupPanel.setPopupPosition(event.getNativeEvent().getClientX(), event.getNativeEvent().getClientY());
			popupPanel.show();

		}, ContextMenuEvent.getType());

	}

	private PopupPanel createPopupPanel() {

		PopupPanel popupPanel = new PopupPanel(true);

		MenuBar menuBar = new MenuBar(true);

		menuBar.addItem("Menu Item 1", () -> {
			Window.alert("Menu Item 1 clicked");
			popupPanel.hide();
		});

		menuBar.addItem("Menu Item 2", () -> {
			Window.alert("Menu Item 2 clicked");
			popupPanel.hide();
		});

		popupPanel.add(menuBar);
		return popupPanel;
	}
}