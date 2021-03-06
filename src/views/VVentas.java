package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import vectors.ModelTable;

public class VVentas extends JPanel {

	private static final long serialVersionUID = -39759645929967463L;
	private JButton btnNuevo, btnAdd, btnGuardar;
	private JTable tableVentas, tablePlatillos;
	private JScrollPane scrollPaneLista, scrollPaneP;
	private JPanel paneVenta;
	private JTextField txtNumMesa, txtSubtotal, txtIVA, txtTotal;
	
	public VVentas() {
		setBackground(Color.DARK_GRAY);
		setLayout(new MigLayout("", "[][][grow][grow]", "[][][][grow]"));
		
		btnNuevo = new JButton("Nueva Venta");
<<<<<<< HEAD
		btnNuevo.setFont(new Font("Lato", Font.PLAIN, 11));
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		add(btnNuevo, "cell 1 2");
		

		btnAdd = new JButton("Agregar Platillo");
<<<<<<< HEAD
		btnAdd.setFont(new Font("Lato", Font.PLAIN, 11));
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 0;
		gbc_btnAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAdd.insets = new Insets(10, 0, 10, 0);
		add(btnAdd, "cell 4 2");
		
		tableVentas = new JTable();
		scrollPaneLista = new JScrollPane(tableVentas);
		add(scrollPaneLista, "cell 1 3 3 1,grow");
		
		paneVenta = new JPanel();
		paneVenta.setBackground(Color.DARK_GRAY);
		paneVenta.setVisible(true);
		add(paneVenta, "cell 4 3 2 1,growx, aligny top");
		
		GridBagLayout gbl_pane = new GridBagLayout();
		gbl_pane.columnWidths = new int[]{0, 0, 0};
		gbl_pane.rowHeights = new int[]{0, 0, 0};
		gbl_pane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		paneVenta.setLayout(gbl_pane);
		
		tablePlatillos = new JTable();
		
		scrollPaneP = new JScrollPane(tablePlatillos);
		GridBagConstraints gbc_jtable = new GridBagConstraints();
		gbc_jtable.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtable.gridx = 0;
		gbc_jtable.gridy = 0;
		gbc_jtable.gridwidth = 2;
		gbc_jtable.gridheight = 2;
		paneVenta.add(scrollPaneP, gbc_jtable);
		
<<<<<<< HEAD
		GridBagConstraints gbc_lblNoMesa = new GridBagConstraints();
		gbc_lblNoMesa.gridx = 0;
		gbc_lblNoMesa.gridy = 2;
		gbc_lblNoMesa.anchor = GridBagConstraints.EAST;
		gbc_lblNoMesa.insets = new Insets(5, 0, 5, 0);
		JLabel lblNoMesa = new JLabel("No. Mesa:   ");
		lblNoMesa.setForeground(Color.WHITE);
		lblNoMesa.setFont(new Font("Lato", Font.PLAIN, 12));
		paneVenta.add(lblNoMesa, gbc_lblNoMesa);
		
		txtNumMesa = new JTextField();
		txtNumMesa.setFont(new Font("Lato", Font.PLAIN, 12));
=======
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 2;
		gbc_lbl.anchor = GridBagConstraints.EAST;
		gbc_lbl.insets = new Insets(5, 0, 5, 0);
		JLabel label = new JLabel("No. Mesa:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Lato", Font.PLAIN, 12));
		paneVenta.add(label, gbc_lbl);
		
		txtNumMesa = new JTextField();
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		gbc_textField.insets = new Insets(5, 0, 5, 0);
		paneVenta.add(txtNumMesa, gbc_textField);
		txtNumMesa.setColumns(20);
		
		GridBagConstraints gbc_lbl2 = new GridBagConstraints();
		gbc_lbl2.gridx = 0;
		gbc_lbl2.gridy = 3;
		gbc_lbl2.anchor = GridBagConstraints.EAST;
		gbc_lbl2.insets = new Insets(0, 0, 5, 0);
<<<<<<< HEAD
		JLabel label2 = new JLabel("Subtotal:   ");
=======
		JLabel label2 = new JLabel("Subtotal");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Lato", Font.PLAIN, 12));
		paneVenta.add(label2, gbc_lbl2);
		
		txtSubtotal = new JTextField();
<<<<<<< HEAD
		txtSubtotal.setFont(new Font("Lato", Font.PLAIN, 12));
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		
		GridBagConstraints gbc_textField2 = new GridBagConstraints();
		gbc_textField2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField2.gridx = 1;
		gbc_textField2.gridy = 3;
		gbc_textField2.insets = new Insets(0, 0, 5, 0);
		paneVenta.add(txtSubtotal, gbc_textField2);
		txtSubtotal.setColumns(20);
		txtSubtotal.setEnabled(false);
		
		
		GridBagConstraints gbc_lbl3 = new GridBagConstraints();
		gbc_lbl3.gridx = 0;
		gbc_lbl3.gridy = 4;
		gbc_lbl3.anchor = GridBagConstraints.EAST;
		gbc_lbl3.insets = new Insets(0, 0, 5, 0);
<<<<<<< HEAD
		JLabel label3 = new JLabel("IVA:   ");
=======
		JLabel label3 = new JLabel("IVA:");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Lato", Font.PLAIN, 12));
		paneVenta.add(label3, gbc_lbl3);
		
		txtIVA = new JTextField();
<<<<<<< HEAD
		txtIVA.setFont(new Font("Lato", Font.PLAIN, 12));
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		
		GridBagConstraints gbc_textField3 = new GridBagConstraints();
		gbc_textField3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField3.gridx = 1;
		gbc_textField3.gridy = 4;
		gbc_textField3.insets = new Insets(0, 0, 5, 0);
		paneVenta.add(txtIVA, gbc_textField3);
		txtIVA.setColumns(20);
		txtIVA.setEnabled(false);
		
		GridBagConstraints gbc_lbl4 = new GridBagConstraints();
		gbc_lbl4.gridx = 0;
		gbc_lbl4.gridy = 5;
		gbc_lbl4.anchor = GridBagConstraints.EAST;
		gbc_lbl4.insets = new Insets(0, 0, 5, 0);
<<<<<<< HEAD
		JLabel label4 = new JLabel("Total:   ");
=======
		JLabel label4 = new JLabel("Total:");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("Lato", Font.PLAIN, 12));
		paneVenta.add(label4, gbc_lbl4);
		
		txtTotal = new JTextField();
<<<<<<< HEAD
		txtTotal.setFont(new Font("Lato", Font.PLAIN, 12));
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		
		GridBagConstraints gbc_textField4 = new GridBagConstraints();
		gbc_textField4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField4.gridx = 1;
		gbc_textField4.gridy = 5;
		gbc_textField4.insets = new Insets(0, 0, 5, 0);
		paneVenta.add(txtTotal, gbc_textField4);
		txtTotal.setColumns(20);
		txtTotal.setEnabled(false);
		
		btnGuardar = new JButton("Guardar");
<<<<<<< HEAD
		btnGuardar.setFont(new Font("Lato", Font.PLAIN, 11));
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 6;
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.insets = new Insets(10, 0, 10, 0);
		paneVenta.add(btnGuardar, gbc_btnGuardar);
	}
	
	public JTable addTableVentas(ModelTable modelVentas){
		tableVentas.setModel(modelVentas);
		return tableVentas;
	}
	
	public JTable addTablePlatillos(DefaultTableModel modelPlatillos){
		tablePlatillos.setModel(modelPlatillos);
		return tablePlatillos;
	}
	
	public JTable getTableVentas() {
		return tableVentas;
	}

	public void setTableVentas(JTable tableVentas) {
		this.tableVentas = tableVentas;
	}

	public JTable getTablePlatillos() {
		return tablePlatillos;
	}

	public void setTablePlatillos(JTable tablePlatillos) {
		this.tablePlatillos = tablePlatillos;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JPanel getPaneVenta() {
		return paneVenta;
	}

	public JTextField getTxtNumMesa() {
		return txtNumMesa;
	}

	public JTextField getTxtSubtotal() {
		return txtSubtotal;
	}

	public JTextField getTxtIVA() {
		return txtIVA;
	}

	public JTextField getTxtTotal() {
		return txtTotal;
	}

}
