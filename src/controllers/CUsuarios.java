package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import models.Usuarios;
import models.Usuarios.Usuario;
import vectors.EditorCell;
import vectors.ModelTable;
import vectors.RenderCell;
import views.VUsuarios;
import conn.JDBC;

public class CUsuarios implements ActionListener{

	private JDBC conn;
	private JSplitPane panelPrincipal;
	private VUsuarios vista;
	private Usuarios modelo;
	private int idusuario;
	private ModelTable modelTableUsuarios;
	private DefaultTableModel modelTablePermisos;
	private JButton btnEditar, btnEliminar, btnNuevo, btnGuardar;
	private JTextField txtNombre, txtApPat, txtApMat, txtUsername;
	private JPasswordField txtPassword, txtPassword2;
	private Object[] columnasUsuarios = {"ID", "Usuario", "Nombre", "", ""};
	private Object[] columnasPermisos = {"Permiso", "Activo/Inactivo"};
	private JTable tablaUsuarios, tablaPermisos;
	
	public CUsuarios(JSplitPane panel, JDBC conn){
		this.conn = conn;
		panelPrincipal = panel;
		vista = new VUsuarios();
		modelo = new Usuarios(this.conn);
	}
	
	public void iniciar(){
		idusuario = 0;
		panelPrincipal.setRightComponent(vista);
		
		modelTableUsuarios = nuevoModeloTabla(getDataUsuarios(), columnasUsuarios);
		tablaUsuarios = vista.addTableUsuarios(modelTableUsuarios);
		tablaUsuarios.setDefaultRenderer(JButton.class, new RenderCell());
		tablaUsuarios.setDefaultEditor(JButton.class, new EditorCell());
		
		modelTablePermisos = new DefaultTableModel(getDataPermisos(), columnasPermisos){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex){
				return true;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex){
				if(columnIndex == 0)
					return String.class;
				else
					return Boolean.class;
					
			}
		};
		tablaPermisos = vista.addTablePermisos(modelTablePermisos);
		
		btnNuevo = vista.getBtnNuevo();
		btnNuevo.addActionListener(this);
		
		btnGuardar = vista.getBtnGuardar();
		btnGuardar.addActionListener(this);
		
		txtUsername = vista.getTxtUsername();
		txtPassword = vista.getTxtPassword();
		txtPassword2 = vista.getTxtPassword2();
		txtNombre = vista.getTxtNombre();
		txtApPat = vista.getTxtApPat();
		txtApMat = vista.getTxtApMat();
	}
	
	public Object[][] getDataPermisos(){
		Object[][] perms = new Object[7][2];
		perms[0][0] = "Productos";
		perms[0][1] = false;
		perms[1][0] = "Platillos";
		perms[1][1] = false;
		perms[2][0] = "Empleados";
		perms[2][1] = false;
		perms[3][0] = "Ventas";
		perms[3][1] = false;
		perms[4][0] = "Compras";
		perms[4][1] = false;
		perms[5][0] = "Usuarios";
		perms[5][1] = false;
		perms[6][0] = "Reportes";
		perms[6][1] = false;
		return perms;
	}
	
	public Object[][] getDataUsuarios(){
		ArrayList<Usuario> listaUsuarios = modelo.getAllUsuarios();
		int numUsuarios = listaUsuarios.size();
		Object[][] usrs = new Object[numUsuarios][5];
		
		int i = 0;
		for(final Usuario u : listaUsuarios){
			usrs[i][0] = u.getIdusuario();
			usrs[i][1] = u.getUsername();
			usrs[i][2] = u.getNombre() + " " + u.getAppat() + " " + u.getApmat();
			
			btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
						editUsuario(u);
				}
			});
			usrs[i][3] = btnEditar;
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					int opt = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el usuario: " + u.getUsername() + "?", 
							"Eliminar Usuario", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						modelo.deleteUsuario(u);
						tablaUsuarios.setModel(nuevoModeloTabla(getDataUsuarios(), columnasUsuarios));
					}
				}
			});
			usrs[i][4] = btnEliminar;
			i++;			
		}
		return usrs;
	}
	
	public void editUsuario(Usuario u){
		idusuario = u.getIdusuario();
		System.out.println(idusuario);
		txtUsername.setText(u.getUsername());
		txtPassword.setText(u.getPassword());
		txtNombre.setText(u.getNombre());
		txtApPat.setText(u.getAppat());
		txtApMat.setText(u.getApmat());
		HashMap<Integer, Boolean> permisos = u.getPermisos();
		for(int i=0; i < 7; i ++){
			tablaPermisos.getModel().setValueAt(false, i, 1);
		}
		for(Integer key : permisos.keySet()){
			tablaPermisos.getModel().setValueAt(true, key, 1);
		}
	}
	
	private void emptyForm(){
		txtUsername.setText("");
		txtPassword.setText("");
		txtPassword2.setText("");
		txtNombre.setText("");
		txtApPat.setText("");
		txtApMat.setText("");
		for(int i=0; i < 7; i++)
			modelTablePermisos.setValueAt(false, i, 1);
		
	}
	
	private boolean fillField(JTextField field){
		if(field.getText().equals("") || field.getText() == null){
			field.setBorder(BorderFactory.createLineBorder(Color.red));
			field.requestFocus();
			return false;
		}
		field.setBorder(BorderFactory.createLineBorder(Color.gray));
		return true;
	}
	
	public ModelTable nuevoModeloTabla(Object[][] data, Object[] columns){
		return new ModelTable(data, columns);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnNuevo)){
			idusuario = 0;
			emptyForm();
		}else if(e.getSource().equals(btnGuardar) && idusuario == 0){
			if(fillField(txtUsername) && fillField(txtPassword) && fillField(txtPassword2) && fillField(txtNombre)){
				if(!Arrays.equals(txtPassword.getPassword(), txtPassword2.getPassword())){
					JOptionPane.showMessageDialog(null, "Los campos de contraseña no son iguales", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					Usuario usr = new Usuario(conn, txtUsername.getText(), new String(txtPassword.getPassword()),
							txtNombre.getText(), txtApPat.getText(), txtApMat.getText());
					if(!usr.isError()){
						HashMap<Integer, Boolean> permisos = new HashMap<Integer, Boolean>();
						Boolean permiso;
						for(int i=0; i < 7; i ++){
							permiso = (boolean) tablaPermisos.getModel().getValueAt(i, 1);
							if(permiso)
								permisos.put(i, permiso);
						}
						usr.setPermisos(permisos);
						tablaUsuarios.setModel(nuevoModeloTabla(getDataUsuarios(), columnasUsuarios));
						emptyForm();
					}else{
						JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe. Elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		}else{
			System.out.println(idusuario);
			if(fillField(txtUsername) && fillField(txtPassword) && fillField(txtPassword2) && fillField(txtNombre)){
				if(!Arrays.equals(txtPassword.getPassword(), txtPassword2.getPassword())){
					JOptionPane.showMessageDialog(null, "Los campos de contraseña no son iguales", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					Usuario usr = new Usuario(conn, idusuario);
					usr.setUsername(txtUsername.getText());
					if(!usr.isError()){
						usr.setPassword(new String(txtPassword.getPassword()));
						usr.setNombre(txtNombre.getText());
						usr.setAppat(txtApPat.getText());
						usr.setApmat(txtApMat.getText());
						
						HashMap<Integer, Boolean> permisos = new HashMap<Integer, Boolean>();
						Boolean permiso;
						for(int i=0; i < 7; i ++){
							permiso = (boolean) tablaPermisos.getModel().getValueAt(i, 1);
							if(permiso)
								permisos.put(i, permiso);
						}
						usr.setPermisos(permisos);
						tablaUsuarios.setModel(nuevoModeloTabla(getDataUsuarios(), columnasUsuarios));
						emptyForm();
					}else{
						JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe. Elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}

}
