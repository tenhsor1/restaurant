package views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import vectors.ModelTable;

public class VUsuarios extends JPanel {

	private static final long serialVersionUID = 3816471388567845162L;
	private JButton btnNuevo, btnGuardar;
	private JTable tableUsuarios, tablePermisos;
	private JScrollPane scrollPaneLista, scrollPaneP;
	private JPanel paneUsuario;
	private JTextField txtUsername, txtNombre, txtApPat, txtApMat;
	private JPasswordField txtPassword, txtPassword2;
	public VUsuarios() {
		setLayout(new MigLayout("", "[][][grow][grow]", "[][][][grow]"));
		
		btnNuevo = new JButton("Nuevo Usuario");
		btnNuevo.setFont(new Font("Lato", Font.PLAIN, 11));
		add(btnNuevo, "cell 1 2");
		
		tableUsuarios = new JTable();
		scrollPaneLista = new JScrollPane(tableUsuarios);
		add(scrollPaneLista, "cell 1 3 3 1,grow");
		
		paneUsuario = new JPanel();
		paneUsuario.setVisible(true);
		add(paneUsuario, "cell 4 3 2 1,growx, aligny top");
		
		GridBagLayout gbl_pane = new GridBagLayout();
		gbl_pane.columnWidths = new int[]{0, 0, 0};
		gbl_pane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		paneUsuario.setLayout(gbl_pane);
		
		tablePermisos = new JTable();
		tablePermisos.setRowHeight(30);
		
		GridBagConstraints gbc_lblU = new GridBagConstraints();
		gbc_lblU.gridx = 0;
		gbc_lblU.gridy = 0;
		gbc_lblU.anchor = GridBagConstraints.EAST;
		gbc_lblU.insets = new Insets(5, 0, 5, 5);
		JLabel lblUsername = new JLabel("Usuario: ");
		lblUsername.setFont(new Font("Lato", Font.PLAIN, 12));
		paneUsuario.add(lblUsername, gbc_lblU);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Lato", Font.PLAIN, 12));
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		gbc_textField.insets = new Insets(5, 0, 5, 0);
		paneUsuario.add(txtUsername, gbc_textField);
		txtUsername.setColumns(30);
		
		GridBagConstraints gbc_lbl2 = new GridBagConstraints();
		gbc_lbl2.gridx = 0;
		gbc_lbl2.gridy = 1;
		gbc_lbl2.anchor = GridBagConstraints.EAST;
		gbc_lbl2.insets = new Insets(5, 0, 5, 5);
		JLabel lbl2 = new JLabel("Password: ");
		lbl2.setFont(new Font("Lato", Font.PLAIN, 12));
		paneUsuario.add(lbl2, gbc_lbl2);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Lato", Font.PLAIN, 12));
		
		GridBagConstraints gbc_textField2 = new GridBagConstraints();
		gbc_textField2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField2.gridx = 1;
		gbc_textField2.gridy = 1;
		gbc_textField2.insets = new Insets(5, 0, 5, 0);
		paneUsuario.add(txtPassword, gbc_textField2);
		txtPassword.setColumns(20);
		
		GridBagConstraints gbc_lbl3 = new GridBagConstraints();
		gbc_lbl3.gridx = 0;
		gbc_lbl3.gridy = 2;
		gbc_lbl3.anchor = GridBagConstraints.EAST;
		gbc_lbl3.insets = new Insets(5, 0, 5, 5);
		JLabel lbl3 = new JLabel("Repite tu Password: ");
		lbl3.setFont(new Font("Lato", Font.PLAIN, 12));
		paneUsuario.add(lbl3, gbc_lbl3);
		
		txtPassword2 = new JPasswordField();
		txtPassword2.setFont(new Font("Lato", Font.PLAIN, 12));
		
		GridBagConstraints gbc_textField3 = new GridBagConstraints();
		gbc_textField3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField3.gridx = 1;
		gbc_textField3.gridy = 2;
		gbc_textField3.insets = new Insets(5, 0, 5, 0);
		paneUsuario.add(txtPassword2, gbc_textField3);
		txtPassword2.setColumns(20);
		
		GridBagConstraints gbc_lbl4 = new GridBagConstraints();
		gbc_lbl4.gridx = 0;
		gbc_lbl4.gridy = 3;
		gbc_lbl4.anchor = GridBagConstraints.EAST;
		gbc_lbl4.insets = new Insets(5, 0, 5, 5);
		JLabel lbl4 = new JLabel("Nombre: ");
		lbl4.setFont(new Font("Lato", Font.PLAIN, 12));
		paneUsuario.add(lbl4, gbc_lbl4);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Lato", Font.PLAIN, 12));
		
		GridBagConstraints gbc_textField4 = new GridBagConstraints();
		gbc_textField4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField4.gridx = 1;
		gbc_textField4.gridy = 3;
		gbc_textField4.insets = new Insets(5, 0, 5, 0);
		paneUsuario.add(txtNombre, gbc_textField4);
		txtNombre.setColumns(30);
		
		GridBagConstraints gbc_lbl5 = new GridBagConstraints();
		gbc_lbl5.gridx = 0;
		gbc_lbl5.gridy = 4;
		gbc_lbl5.anchor = GridBagConstraints.EAST;
		gbc_lbl5.insets = new Insets(5, 0, 5, 5);
		JLabel lbl5 = new JLabel("Apellido Paterno: ");
		lbl5.setFont(new Font("Lato", Font.PLAIN, 12));
		paneUsuario.add(lbl5, gbc_lbl5);
		
		txtApPat = new JTextField();
		txtApPat.setFont(new Font("Lato", Font.PLAIN, 12));
		
		GridBagConstraints gbc_textField5 = new GridBagConstraints();
		gbc_textField5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField5.gridx = 1;
		gbc_textField5.gridy = 4;
		gbc_textField5.insets = new Insets(5, 0, 5, 0);
		paneUsuario.add(txtApPat, gbc_textField5);
		txtApPat.setColumns(30);
		
		GridBagConstraints gbc_lbl6 = new GridBagConstraints();
		gbc_lbl6.gridx = 0;
		gbc_lbl6.gridy = 5;
		gbc_lbl6.anchor = GridBagConstraints.EAST;
		gbc_lbl6.insets = new Insets(5, 0, 5, 5);
		JLabel lbl6 = new JLabel("Apellido Materno: ");
		lbl6.setFont(new Font("Lato", Font.PLAIN, 12));
		paneUsuario.add(lbl6, gbc_lbl6);
		
		txtApMat = new JTextField();
		txtApMat.setFont(new Font("Lato", Font.PLAIN, 12));
		
		GridBagConstraints gbc_textField6 = new GridBagConstraints();
		gbc_textField6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField6.gridx = 1;
		gbc_textField6.gridy = 5;
		gbc_textField6.insets = new Insets(5, 0, 5, 0);
		paneUsuario.add(txtApMat, gbc_textField6);
		txtApMat.setColumns(30);
		
		scrollPaneP = new JScrollPane(tablePermisos);
		scrollPaneP.setPreferredSize(new Dimension(scrollPaneP.getWidth(), 230));
		scrollPaneP.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_jtable = new GridBagConstraints();
		gbc_jtable.insets = new Insets(0, 0, 5, 0);
		gbc_jtable.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtable.gridx = 0;
		gbc_jtable.gridy = 6;
		gbc_jtable.gridwidth = 2;
		gbc_jtable.gridheight = 5;
		paneUsuario.add(scrollPaneP, gbc_jtable);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Lato", Font.PLAIN, 11));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy =11;
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.insets = new Insets(10, 0, 10, 0);
		paneUsuario.add(btnGuardar, gbc_btnGuardar);
	}

	public JTable addTableUsuarios(ModelTable modelUsuarios){
		tableUsuarios.setModel(modelUsuarios);
		return tableUsuarios;
	}
	
	public JTable addTablePermisos(DefaultTableModel modelPermisos){
		tablePermisos.setModel(modelPermisos);
		return tablePermisos;
	}
	
	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JTable getTableUsuarios() {
		return tableUsuarios;
	}

	public JTable getTablePermisos() {
		return tablePermisos;
	}

	public JPanel getPaneUsuario() {
		return paneUsuario;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
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

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public JPasswordField getTxtPassword2() {
		return txtPassword2;
	}

}
