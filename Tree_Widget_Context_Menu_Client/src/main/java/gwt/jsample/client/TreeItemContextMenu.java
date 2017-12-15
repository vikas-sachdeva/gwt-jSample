package gwt.jsample.client;

import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class TreeItemContextMenu {

	private PopupPanel popupPanel;

	private Tree tree;

	private MenuItem addMenuItem;

	private MenuItem deleteMenuItem;

	public TreeItemContextMenu(Tree tree) {
		this.tree = tree;
		createMenu();
		addContextMenu();
	}

	private void addContextMenu() {

		for (int i = 0; i < tree.getItemCount(); i++) {
			addContextMenu(tree.getItem(i));
		}
	}

	private void addContextMenu(TreeItem item) {
		if (item == null) {
			return;
		}
		for (int i = 0; i < item.getChildCount(); i++) {
			addContextMenu(item.getChild(i));
		}
		item.getWidget().sinkEvents(Event.ONCONTEXTMENU);
		item.getWidget().addHandler((event) -> {
			tree.setSelectedItem(item);
			event.preventDefault();
			event.stopPropagation();
			popupPanel.setPopupPosition(event.getNativeEvent().getClientX(), event.getNativeEvent().getClientY());
			popupPanel.show();

		}, ContextMenuEvent.getType());
	}

	private void createMenu() {

		popupPanel = new PopupPanel(true);
		popupPanel.getElement().setId("treeContextMenu");

		MenuBar menuBar = new MenuBar(true);

		addMenuItem = new MenuItem(SafeHtmlUtils.fromString("Add"));
		addMenuItem.setScheduledCommand(new MenuItemClickCommand(addMenuItem));
		menuBar.addItem(addMenuItem);

		deleteMenuItem = new MenuItem(SafeHtmlUtils.fromString("Delete"));
		deleteMenuItem.setScheduledCommand(new MenuItemClickCommand(deleteMenuItem));
		menuBar.addItem(deleteMenuItem);

		popupPanel.add(menuBar);
	}

	class MenuItemClickCommand implements ScheduledCommand {

		protected MenuItem menuItem;

		public MenuItemClickCommand(MenuItem menuItem) {
			this.menuItem = menuItem;
		}

		@Override
		public void execute() {
			TreeItem selectedTreeItem = tree.getSelectedItem();

			if (menuItem == addMenuItem) {

				if (selectedTreeItem.getParentItem() == null) {
					Window.alert("Can not add parallel element for root node");
				} else {

					TreeItem treeItem = new TreeItem();
					treeItem.setWidget(new Label("New Element"));
					addContextMenu(treeItem);

					int currentIndex = selectedTreeItem.getParentItem().getChildIndex(selectedTreeItem);
					selectedTreeItem.getParentItem().insertItem(currentIndex + 1, treeItem);
					selectedTreeItem.setSelected(false);
				}
			} else {
				selectedTreeItem.remove();
			}
			popupPanel.hide();
		}
	}
}