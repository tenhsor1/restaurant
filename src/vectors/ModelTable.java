package vectors;

import javax.swing.table.DefaultTableModel;

public class ModelTable extends DefaultTableModel {
	public Object[] getColumns() {
		return columns;
	}

	public void setColumns(Object[] columns) {
		this.columns = columns;
	}

	private static final long serialVersionUID = -7371767486823110657L;
	private Object[][] data;
	private Object[] columns;
	public ModelTable(Object[][] data, Object[] columns){
		super(data, columns);
		this.data = data;
		this.columns = columns;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		return data[0][columnIndex].getClass();
			
	}
	
	@Override
	public Object getValueAt(int row, int column){
		return data[row][column];   
	}

}