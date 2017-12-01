package gwt.jsample.client.grid;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.jsample.client.model.GridDataRow;
import gwt.jsample.client.model.GridDataRowType;
import gwt.jsample.client.model.GridSelectModel;

public class PropertyGrid extends Grid {

	private List<GridDataRow> dataRows;

	private List<GridChangeHandler> gridChangeHandlers = new ArrayList<>();

	public PropertyGrid(List<GridDataRow> dataRows) {
		super(dataRows.size() + 1, 2);
		getElement().setId("propertyGrid");
		setCellSpacing(0);
		this.dataRows = dataRows;
		createHeader();
		fill();
	}

	private void fill() {
		resizeRows(dataRows.size() + 1);

		for (int i = 0; i < dataRows.size(); i++) {

			Label keyLabel = new Label(dataRows.get(i).getKey());
			setWidget(i + 1, 0, keyLabel);

			Widget valueWidget;

			switch (dataRows.get(i).getDataRowType()) {
			case LABEL:
				valueWidget = new Label((String) dataRows.get(i).getValue());
				break;
			case SELECT:

				GridSelectModel selectModel = (GridSelectModel) dataRows.get(i).getValue();

				ListBox listBox = new ListBox();
				listBox.setVisibleItemCount(1);
				for (String option : selectModel.getOptions()) {
					listBox.addItem(option);
				}
				listBox.setSelectedIndex(selectModel.getSelectedIndex());

				listBox.addChangeHandler(this::gridDataChanged);

				valueWidget = listBox;
				break;

			case TEXT_FIELD:

				TextBox textBox = new TextBox();
				textBox.setText((String) dataRows.get(i).getValue());
				textBox.addChangeHandler(this::gridDataChanged);

				valueWidget = textBox;
				break;
			default:
				valueWidget = null;
			}

			setWidget(i + 1, 1, valueWidget);
			getRowFormatter().addStyleName(i + 1, "dataRow");
		}
	}

	private void createHeader() {
		Label propertyLabel = new Label("Property");
		setWidget(0, 0, propertyLabel);

		Label valueLabel = new Label("Value");
		setWidget(0, 1, valueLabel);
		getRowFormatter().addStyleName(0, "headerRow");

	}

	private void gridDataChanged(ChangeEvent event) {
		Element td = getEventTargetCell(Event.as(event.getNativeEvent()));

		int row = TableRowElement.as(td.getParentElement()).getSectionRowIndex();

		GridDataRow dataRow = dataRows.get(row - 1);

		if (dataRow.getDataRowType().equals(GridDataRowType.TEXT_FIELD)) {

			TextBox textBox = (TextBox) event.getSource();

			dataRow.setValue(textBox.getValue());
		} else if (dataRow.getDataRowType().equals(GridDataRowType.SELECT)) {

			ListBox listBox = (ListBox) event.getSource();
			((GridSelectModel) dataRow.getValue()).setSelectedIndex(listBox.getSelectedIndex());
		}
		fireGridChangeEvent(dataRow);

	}

	private void fireGridChangeEvent(GridDataRow dataRow) {

		gridChangeHandlers.forEach((gridChangeHandler) -> gridChangeHandler.onChange(dataRow));

	}

	public void addGridChangeHandler(GridChangeHandler gridChangeHandler) {
		gridChangeHandlers.add(gridChangeHandler);
	}
}