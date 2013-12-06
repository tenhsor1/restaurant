package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

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

import javax.swing.ImageIcon;

import java.awt.Dimension;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class VCompras extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableCompras;
	private JPanel paneCompra;
	private JComboBox<Item> cmbProductos, cmbUnidad;
	private JTextField txtCantidad;
	private JDateChooser dcCaducidad;
	private JButton btnGuardar, btnNuevo;
	private GridBagConstraints gbc_comboBox, gbc_comboBox2;
	public VCompras() {
		setBackground(Color.DARK_GRAY);
		setLayout(new MigLayout("", "[][grow][][][][][]", "[][][][]"));
		
		btnNuevo = new JButton("Nueva Compra");
		btnNuevo.setFont(new Font("Lato", Font.PLAIN, 11));
		add(btnNuevo, "cell 1 2");
		
		tableCompras = new JTable();
		tableCompras.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(tableCompras);
		add(scrollPane, "cell 1 3 1 1,grow");
		
		paneCompra = new JPanel();
		paneCompra.setBackground(Color.DARK_GRAY);
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
		JLabel label = new JLabel("Nombre:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Lato", Font.PLAIN, 12));
		paneCompra.add(label, gbc_lbl);
		
		/*cmbProductos = new JComboBox<Item>();
		cmbProductos.setBackground(Color.LIGHT_GRAY);
		cmbProductos.setFont(new Font("Caviar Dreams", Font.BOLD, 12));
		cmbProductos.setForeground(Color.BLACK);
		gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		paneCompra.add(cmbProductos, gbc_comboBox);*/
		
		GridBagConstraints gbc_lbl2 = new GridBagConstraints();
		gbc_lbl2.gridx = 0;
		gbc_lbl2.gridy = 1;
		gbc_lbl2.anchor = GridBagConstraints.EAST;
		gbc_lbl2.insets = new Insets(0, 15, 5, 15);
		JLabel label_1 = new JLabel("Cantidad:");
		label_1.setFont(new Font("Lato", Font.PLAIN, 12));
		label_1.setForeground(Color.WHITE);
		paneCompra.add(label_1, gbc_lbl2);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Lato", Font.PLAIN, 12));
		
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
		JLabel label_2 = new JLabel("Unidad:");
		label_2.setFont(new Font("Lato", Font.PLAIN, 12));
		label_2.setForeground(Color.WHITE);
		paneCompra.add(label_2, gbc_lbl3);
		
		/*cmbUnidad = new JComboBox<Item>();
		cmbUnidad.setFont(new Font("Caviar Dreams", Font.BOLD, 12));
		cmbUnidad.setForeground(Color.BLACK);
		cmbUnidad.setBackground(Color.LIGHT_GRAY);
		gbc_comboBox2 = new GridBagConstraints();
		gbc_comboBox2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox2.gridx = 1;
		gbc_comboBox2.gridy = 2;
		paneCompra.add(cmbUnidad, gbc_comboBox2);*/
		
		GridBagConstraints gbc_lbl4 = new GridBagConstraints();
		gbc_lbl4.gridx = 0;
		gbc_lbl4.gridy = 3;
		gbc_lbl4.anchor = GridBagConstraints.EAST;
		gbc_lbl4.insets = new Insets(0, 15, 5, 15);
		JLabel label_3 = new JLabel("Fecha de Caducidad:");
		label_3.setFont(new Font("Lato", Font.PLAIN, 12));
		label_3.setForeground(Color.WHITE);
		paneCompra.add(label_3, gbc_lbl4);
		
		//Icono Calendar
		Image getCalicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/calendar.png"));
		Image sclCalicn = getCalicn.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnCal	= new ImageIcon(sclCalicn);//icono Login
		
		dcCaducidad = new JDateChooser();
		dcCaducidad.setFont(new Font("Lato", Font.PLAIN, 11));
		dcCaducidad.getCalendarButton().setMaximumSize(new Dimension(10, 10));
		dcCaducidad.getCalendarButton().setIcon(icnCal);
		dcCaducidad.setForeground(Color.WHITE);
		dcCaducidad.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_comboBox3 = new GridBagConstraints();
		gbc_comboBox3.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox3.gridx = 1;
		gbc_comboBox3.gridy = 3;
		paneCompra.add(dcCaducidad, gbc_comboBox3);
		dcCaducidad.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{dcCaducidad.getCalendarButton()}));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Lato", Font.PLAIN, 11));
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
	
	public void setCmbProductos(JComboBox<Item> cmbProductos){
		this.cmbProductos = cmbProductos;
		gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		paneCompra.add(this.cmbProductos, gbc_comboBox);
	}
	
	public JComboBox<Item> getCmbUnidad() {
		return cmbUnidad;
	}
	
	public void setCmbUnidad(JComboBox<Item> cmbUnidad){
		this.cmbUnidad = cmbUnidad;
		gbc_comboBox2 = new GridBagConstraints();
		gbc_comboBox2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox2.gridx = 1;
		gbc_comboBox2.gridy = 2;
		paneCompra.add(this.cmbUnidad, gbc_comboBox2);
		
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
	public JButton getBtnNuevo() {
		return btnNuevo;
	}

}
