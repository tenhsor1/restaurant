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

import net.miginfocom.swing.MigLayout;
import vectors.ModelTable;

public class VEmpleados extends JPanel {
	private static final long serialVersionUID = 6319822403463454359L;
	private JScrollPane scrollPaneLista;
	private JTable tableEmpleados;
	private JPanel paneEmpleado;
	private JTextField txtNombre, txtApPat, txtApMat, txtTel, txtDir, txtPuesto, txtHoraIn, txtHoraOut;
	private JButton btnGuardar, btnNuevo;
	public VEmpleados() {
		setLayout(new MigLayout("", "[][grow][][][][][]", "[][][]"));
		
		btnNuevo = new JButton("Nuevo Empleado");
		add(btnNuevo, "cell 1 2");
		
		tableEmpleados = new JTable();
		scrollPaneLista = new JScrollPane(tableEmpleados);
		add(scrollPaneLista, "cell 1 3 3 1,grow");
	
		paneEmpleado = new JPanel();
		paneEmpleado.setVisible(false);
		add(paneEmpleado, "cell 4 3 2 1,growx, aligny top");
		GridBagLayout gbl_pane = new GridBagLayout();
		gbl_pane.columnWidths = new int[]{0, 0};
		gbl_pane.rowHeights = new int[]{0, 0, 0};
		gbl_pane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		paneEmpleado.setLayout(gbl_pane);
		
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 0;
		gbc_lbl.anchor = GridBagConstraints.EAST;
		gbc_lbl.insets = new Insets(5, 15, 5, 15);
		paneEmpleado.add(new JLabel("Nombre:"), gbc_lbl);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		gbc_textField.insets = new Insets(5, 10, 5, 0);
		paneEmpleado.add(txtNombre, gbc_textField);
		txtNombre.setColumns(30);
		
		gbc_lbl.gridy = 1;
		paneEmpleado.add(new JLabel("Apellido Paterno:"), gbc_lbl);
		
		txtApPat = new JTextField();
		gbc_textField.gridy = 1;
		paneEmpleado.add(txtApPat, gbc_textField);
		
		gbc_lbl.gridy = 2;
		paneEmpleado.add(new JLabel("Apellido Materno:"), gbc_lbl);
		
		txtApMat = new JTextField();
		gbc_textField.gridy = 2;
		paneEmpleado.add(txtApMat, gbc_textField);
		
		gbc_lbl.gridy = 3;
		paneEmpleado.add(new JLabel("Teléfono:"), gbc_lbl);
		
		txtTel = new JTextField();
		gbc_textField.gridy = 3;
		paneEmpleado.add(txtTel, gbc_textField);
		
		gbc_lbl.gridy = 4;
		paneEmpleado.add(new JLabel("Dirección:"), gbc_lbl);
		
		txtDir = new JTextField();
		gbc_textField.gridy = 4;
		paneEmpleado.add(txtDir, gbc_textField);
		
		gbc_lbl.gridy = 5;
		paneEmpleado.add(new JLabel("Puesto:"), gbc_lbl);
		
		txtPuesto = new JTextField();
		gbc_textField.gridy = 5;
		paneEmpleado.add(txtPuesto, gbc_textField);
		
		gbc_lbl.gridy = 6;
		paneEmpleado.add(new JLabel("Hora entrada:"), gbc_lbl);
		
		txtHoraIn = new JTextField();
		gbc_textField.gridy = 6;
		paneEmpleado.add(txtHoraIn, gbc_textField);
		
		gbc_lbl.gridy = 7;
		paneEmpleado.add(new JLabel("Hora salida:"), gbc_lbl);
		
		txtHoraOut = new JTextField();
		gbc_textField.gridy = 7;
		paneEmpleado.add(txtHoraOut, gbc_textField);
		
		btnGuardar = new JButton("Guardar");
		gbc_textField.gridy = 8;
		gbc_textField.anchor = GridBagConstraints.EAST;
		gbc_textField.fill = GridBagConstraints.NONE;
		paneEmpleado.add(btnGuardar, gbc_textField);
	}
	
	public JTable addTableEmpleados(ModelTable modelPlatillos){
		tableEmpleados.setModel(modelPlatillos);
		return tableEmpleados;
	}
	
	public JTable getTableEmpleados() {
		return tableEmpleados;
	}
	public JPanel getPaneEmpleado() {
		return paneEmpleado;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public JTextField getTxtApPat() {
		return txtApPat;
	}
	public JTextField getTxtApMat() {
		return txtApMat;
	}
	public JTextField getTxtTel() {
		return txtTel;
	}
	public JTextField getTxtDir() {
		return txtDir;
	}
	public JTextField getTxtPuesto() {
		return txtPuesto;
	}
	public JTextField getTxtHoraIn() {
		return txtHoraIn;
	}
	public JTextField getTxtHoraOut() {
		return txtHoraOut;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnNuevo() {
		return btnNuevo;
	}
}
