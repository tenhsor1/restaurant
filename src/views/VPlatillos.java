package views;

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

public class VPlatillos extends JPanel {

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public JTextField getTxtPlatillo() {
		return txtPlatillo;
	}

	private static final long serialVersionUID = -1958084112420948841L;
	private JButton btnNuevoPlatillo, btnGuardarPlatillo, btnAddProducto;
	private JTable tablePlatillos;
	private JTable tableProdPlatillos;
	private JScrollPane scrollPaneLista, scrollPaneProdP;
	private JPanel paneProducto;
	private JTextField txtPlatillo, txtPrecio;
	
	public VPlatillos() {
		setLayout(new MigLayout("", "[][][grow][grow]", "[][][][grow]"));
		
		btnNuevoPlatillo = new JButton("Nuevo Platillo");
		add(btnNuevoPlatillo, "cell 1 2");
		
		tablePlatillos = new JTable();
		scrollPaneLista = new JScrollPane(tablePlatillos);
		add(scrollPaneLista, "cell 1 3 1 1,grow");
	
		
		paneProducto = new JPanel();
		paneProducto.setVisible(false); //Comentar solo en debbug
		add(paneProducto, "cell 2 3 2 1,growx, aligny top");
		GridBagLayout gbl_paneProducto = new GridBagLayout();
		gbl_paneProducto.columnWidths = new int[]{0, 0};
		gbl_paneProducto.rowHeights = new int[]{0, 0, 0};
		gbl_paneProducto.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_paneProducto.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		paneProducto.setLayout(gbl_paneProducto);
		
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.insets = new Insets(0, 0, 5, 0);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 0;
		gbc_lbl.anchor = GridBagConstraints.EAST;
		paneProducto.add(new JLabel("Platillo:"), gbc_lbl);
		
		txtPlatillo = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		paneProducto.add(txtPlatillo, gbc_textField);
		txtPlatillo.setColumns(50);
		
		gbc_lbl.gridy = 1;
		paneProducto.add(new JLabel("Precio:"), gbc_lbl);
		
		txtPrecio = new JTextField();
		gbc_textField.gridy = 1;
		gbc_textField.fill = GridBagConstraints.NONE;
		gbc_textField.anchor = GridBagConstraints.WEST;
		paneProducto.add(txtPrecio, gbc_textField);
		txtPrecio.setColumns(20);
		
		
		btnAddProducto = new JButton("Agregar Producto");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 2;
		gbc_btnAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAdd.insets = new Insets(10, 0, 10, 0);
		paneProducto.add(btnAddProducto, gbc_btnAdd);
		
		tableProdPlatillos = new JTable();
		
		scrollPaneProdP = new JScrollPane(tableProdPlatillos);
		GridBagConstraints gbc_jtable = new GridBagConstraints();
		gbc_jtable.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtable.gridx = 0;
		gbc_jtable.gridy = 3;
		gbc_jtable.gridwidth = 2;
		paneProducto.add(scrollPaneProdP, gbc_jtable);
		
		btnGuardarPlatillo = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 4;
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.insets = new Insets(10, 0, 10, 0);
		paneProducto.add(btnGuardarPlatillo, gbc_btnGuardar);
				
	    paneProducto.setVisible(false);
	}

	public JButton getBtnAddProducto() {
		return btnAddProducto;
	}

	public JButton getBtnGuardarPlatillo() {
		return btnGuardarPlatillo;
	}

	public JTable addTablePlatillos(ModelTable modelPlatillos){
		tablePlatillos.setModel(modelPlatillos);
		return tablePlatillos;
	}
	
	public JTable addTableProdPlatillos(DefaultTableModel modelProdPlatillos){
		tableProdPlatillos.setModel(modelProdPlatillos);
		return tableProdPlatillos;
	}
	
	public void activarW(){
		paneProducto.setVisible(true);
	}
	
	public JButton getBtnNuevoPlatillo() {
		return btnNuevoPlatillo;
	}

}
