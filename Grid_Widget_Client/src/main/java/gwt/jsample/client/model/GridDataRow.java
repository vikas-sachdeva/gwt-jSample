package gwt.jsample.client.model;

public class GridDataRow {

	private String key;

	private Object value;

	private GridDataRowType dataRowType;

	public GridDataRow(String key, Object value, GridDataRowType dataRowType) {
		this.key = key;
		this.value = value;
		this.dataRowType = dataRowType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public GridDataRowType getDataRowType() {
		return dataRowType;
	}

	public void setDataRowType(GridDataRowType dataRowType) {
		this.dataRowType = dataRowType;
	}

	@Override
	public String toString() {
		return "DataRow [key=" + key + ", value=" + value + ", dataRowType=" + dataRowType + "]";
	}
}