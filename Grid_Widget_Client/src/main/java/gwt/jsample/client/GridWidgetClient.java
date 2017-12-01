package gwt.jsample.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import gwt.jsample.client.grid.PropertyGrid;
import gwt.jsample.client.model.GridDataRow;
import gwt.jsample.client.model.GridDataRowType;
import gwt.jsample.client.model.GridSelectModel;

public class GridWidgetClient implements EntryPoint {

	@Override
	public void onModuleLoad() {

		List<GridDataRow> dataRows = getData();

		PropertyGrid propertyGrid = new PropertyGrid(dataRows);
		RootPanel.get("gwtContainer").add(propertyGrid);

		propertyGrid.addGridChangeHandler((dataRow) -> GWT.log(dataRow.toString()));

	}

	private List<GridDataRow> getData() {
		List<GridDataRow> dataRows = new ArrayList<>();
		GridDataRow labelRow = new GridDataRow("ID", "pet", GridDataRowType.LABEL);
		dataRows.add(labelRow);
		GridDataRow textRow = new GridDataRow("Path", "pet", GridDataRowType.TEXT_FIELD);
		dataRows.add(textRow);
		List<String> options = Arrays.asList("Integer", "Float", "String", "Byte");

		GridSelectModel selectModel = new GridSelectModel(options, 2);

		GridDataRow selectRow = new GridDataRow("Type", selectModel, GridDataRowType.SELECT);
		dataRows.add(selectRow);
		return dataRows;
	}
}
