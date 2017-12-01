package gwt.jsample.client.model;

import java.util.List;

public class GridSelectModel {

	private List<String> options;

	private int selectedIndex;

	public GridSelectModel(List<String> options, int selectedIndex) {
		this.options = options;
		this.selectedIndex = selectedIndex;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	@Override
	public String toString() {
		return "SelectModel [options=" + options + ", selectedIndex=" + selectedIndex + "]";
	}
}
