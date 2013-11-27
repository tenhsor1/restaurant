package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import vectors.Item;
import vectors.ModelTable;

import com.toedter.calendar.JDateChooser;

public class VCompras extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableCompras;
	private JPanel paneCompra;
	private JComboBox<Item> cmbProductos, cmbUnidad;
	private JTextField txtCantidad;
	private JDateChooser dcCaducidad;
	private JButton btnGuardar;
	public VCompras() {
		setLayout(new MigLayout("", "[][grow][][][][][]", "[][][]"));
		
		JButton btnNuevaCompra = new JButton("Nueva Compra");
		add(btnNuevaCompra, "cell 1 2");
		
		tableCompras = new JTable();
		JScrollPane scrollPane = new JScrollPane(tableCompras);
		add(scrollPane, "cell 1 3 1 1,grow");
		
		paneCompra = new JPanel();
		paneCompra.setVisible(true);
		add(paneCompra, "cell 4 3 2 1,growx, aligny top");
		
		GridBagLayout gbl_pane = new GridBagLayout();
		gbl_pane.columnWidths = new int[]{0, 0, 0};
		gbl_pane.rowHeights = new int[]{0, 0, 0};
		gbl_pane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		paneCompra.setLayout(gbl_pane);

		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 0;
		gbc_lbl.anchor = GridBagConstraints.EAST;
		gbc_lbl.insets = new Insets(0, 15, 5, 15);
		paneCompra.add(new JLabel("Nombre:"), gbc_lbl);
		
		cmbProductos = new JComboBox<Item>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		paneCompra.add(cmbProductos, gbc_comboBox);
		
		GridBagConstraints gbc_lbl2 = new GridBagConstraints();
		gbc_lbl2.gridx = 0;
		gbc_lbl2.gridy = 1;
		gbc_lbl2.anchor = GridBagConstraints.EAST;
		gbc_lbl2.insets = new Insets(0, 15, 5, 15);
		paneCompra.add(new JLabel("Cantidad:"), gbc_lbl2);
		
		txtCantidad = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		paneCompra.add(txtCantidad, gbc_textField);
		txtCantidad.setColumns(20);
		
		GridBagConstraints gbc_lbl3 = new GridBagConstraints();
		gbc_lbl3.gridx = 0;
		gbc_lbl3.gridy = 2;
		gbc_lbl3.anchor = GridBagConstraints.EAST;
		gbc_lbl3.insets = new Insets(0, 15, 5, 15);
		paneCompra.add(new JLabel("Unidad:"), gbc_lbl3);
		
		cmbUnidad = new JComboBox<Item>();
		GridBagConstraints gbc_comboBox2 = new GridBagConstraints();
		gbc_comboBox2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox2.gridx = 1;
		gbc_comboBox2.gridy = 2;
		paneCompra.add(cmbUnidad, gbc_comboBox2);
		
		GridBagConstraints gbc_lbl4 = new GridBagConstraints();
		gbc_lbl4.gridx = 0;
		gbc_lbl4.gridy = 3;
		gbc_lbl4.anchor = GridBagConstraints.EAST;
		gbc_lbl4.insets = new Insets(0, 15, 5, 15);
		paneCompra.add(new JLabel("Fecha de Caducidad:"), gbc_lbl4);
		
		dcCaducidad = new JDateChooser();
		GridBagConstraints gbc_comboBox3 = new GridBagConstraints();
		gbc_comboBox3.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox3.gridx = 1;
		gbc_comboBox3.gridy = 3;
		paneCompra.add(dcCaducidad, gbc_comboBox3);
		
		btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_comboBox4 = new GridBagConstraints();
		gbc_comboBox4.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox4.gridx = 1;
		gbc_comboBox4.gridy = 4;
		paneCompra.add(btnGuardar, gbc_comboBox4);
	}
	
	public JTable addTableCompras(ModelTable modelCompras){
		tableCompras.setModel(modelCompras);
		return tableCompras;
	}
	
	public JTable getTableCompras() {
		return tableCompras;
	}
	public JPanel getPaneCompra() {
		return paneCompra;
	}
	public JComboBox<Item> getCmbProductos() {
		return cmbProductos;
	}
	public JComboBox<Item> getCmbUnidad() {
		return cmbUnidad;
	}
	public JTextField getTxtCantidad() {
		return txtCantidad;
	}
	public JDateChooser getDcCaducidad() {
		return dcCaducidad;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

}
