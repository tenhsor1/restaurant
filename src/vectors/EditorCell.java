package vectors;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class EditorCell extends AbstractCellEditor implements TableCellEditor {
	private static final long serialVersionUID = 2133580750408422521L;
	private Boolean currentValue;

	   @Override
	   public Object getCellEditorValue()
	   {
	       return currentValue;
	   }

	   //El editor usara el propio componente. Para que funcione la celda en el modelo debe ser editable.
	   @Override
	   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	   {
	       return (JComponent) value;// la tabla solo debe tener componentes graficos

	   }
	}