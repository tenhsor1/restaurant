package controllers;

import java.awt.Color;
<<<<<<< HEAD
import java.awt.Image;
import java.awt.Toolkit;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
<<<<<<< HEAD
import javax.swing.ImageIcon;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
<<<<<<< HEAD
import javax.swing.border.EmptyBorder;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c

import models.Empleados;
import models.Empleados.Empleado;
import vectors.EditorCell;
import vectors.ModelTable;
import vectors.RenderCell;
import views.VEmpleados;
<<<<<<< HEAD
import views.VLogin;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
import conn.JDBC;

public class CEmpleados  implements ActionListener{
	private JDBC conn;
	private JSplitPane panelPrincipal;
	private VEmpleados vista;
	private JButton btnNuevo, btnEditar, btnEliminar, btnGuardar;
	private Empleados empleados;
	private JTable tablaEmpleados;
	private Object[] columnasEmpleados = {"ID","Nombre", "Puesto", "", ""};
	private JTextField txtNombre, txtApPat, txtApMat, txtTel, txtDir, txtPuesto, txtHoraIn, txtHoraOut;
	private ModelTable modelTableEmpleados;
	private int idempleado;
	public CEmpleados(JSplitPane panel, JDBC conn){
		this.conn = conn;
		panelPrincipal = panel;
		vista = new VEmpleados();
		empleados = new Empleados(conn);
	}
	
	public void iniciar(){
		idempleado = 0;
		panelPrincipal.setRightComponent(vista);
		
		modelTableEmpleados = nuevoModeloTabla(getDataEmpleados(), columnasEmpleados);
		
		tablaEmpleados = vista.addTableEmpleados(modelTableEmpleados);
		tablaEmpleados.setDefaultRenderer(JButton.class, new RenderCell());
		tablaEmpleados.setDefaultEditor(JButton.class, new EditorCell());
		
		btnNuevo = vista.getBtnNuevo();
		btnNuevo.addActionListener(this);
		
		btnGuardar = vista.getBtnGuardar();
		btnGuardar.addActionListener(this);
		
		txtNombre = vista.getTxtNombre();
		txtApPat = vista.getTxtApPat();
		txtApMat = vista.getTxtApMat();
		txtTel = vista.getTxtTel();
		txtDir = vista.getTxtDir();
		txtPuesto = vista.getTxtPuesto();
		txtHoraIn = vista.getTxtHoraIn();
		txtHoraOut = vista.getTxtHoraOut();
	}

	public Object[][] getDataEmpleados(){
		ArrayList<Empleado> listaEmpleados = empleados.getAllEmpleados();
		int numEmpleados = listaEmpleados.size();
		Object[][] emps = new Object[numEmpleados][5];
		
<<<<<<< HEAD
		//Icono Editar
		Image getEditaricn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/Editar.png"));
		Image setEditaricn = getEditaricn.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnEditar	= new ImageIcon(setEditaricn);//icono Editar
		//Icono Eliminar
		Image getEliminaricn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/Eliminar.png"));
		Image setEliminaricn = getEliminaricn.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnEliminar	= new ImageIcon(setEliminaricn);//icono Eliminar
		
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		int i = 0;
		for(final Empleado e : listaEmpleados){
			emps[i][0] = e.getIdempleado();
			emps[i][1] = e.getNombre() + " " + e.getAppat() + " " + e.getApmat();
			emps[i][2] = e.getPuesto();
			
<<<<<<< HEAD
			btnEditar = new JButton("");
			btnEditar.setIcon(icnEditar);
			btnEditar.setToolTipText("Editar Empleado");
			//Importante
			btnEditar.setOpaque(false);
			btnEditar.setContentAreaFilled(false);
			btnEditar.setBorder(new EmptyBorder(0, 0, 0, 0));
=======
			btnEditar = new JButton("Editar");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
			btnEditar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
						editEmpleado(e);
				}
			});
			emps[i][3] = btnEditar;
			
<<<<<<< HEAD
			btnEliminar = new JButton("");
			btnEliminar.setIcon(icnEliminar);
			btnEliminar.setToolTipText("Eliminar Empleado");
			//Importante
			btnEliminar.setOpaque(false);
			btnEliminar.setContentAreaFilled(false);
			btnEliminar.setBorder(new EmptyBorder(0, 0, 0, 0));
			//Importante
=======
			btnEliminar = new JButton("Eliminar");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
			btnEliminar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					int opt = JOptionPane.showConfirmDialog(null, "Est�s seguro de eliminar el empleado: " + e.getNombre() + "?", 
							"Eliminar Producto", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						empleados.deleteEmpleado(e);
						tablaEmpleados.setModel(nuevoModeloTabla(getDataEmpleados(), columnasEmpleados));
					}
				}
			});
			emps[i][4] = btnEliminar;
			i++;			
		}
		return emps;
	}
	
	public ModelTable nuevoModeloTabla(Object[][] data, Object[] columns){
		return new ModelTable(data, columns);
	}
	
	public void editEmpleado(Empleado e){
		idempleado = e.getIdempleado();
		txtNombre.setText(e.getNombre());
		txtApPat.setText(e.getAppat());
		txtApMat.setText(e.getApmat());
		txtDir.setText(e.getDireccion());
		txtTel.setText(e.getTel());
		txtPuesto.setText(e.getPuesto());
		txtHoraIn.setText(e.getHorain());
		txtHoraOut.setText(e.getHoraout());
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
	
	private void emptyForm(){
		txtNombre.setText("");
		txtApPat.setText("");
		txtApMat.setText("");
		txtDir.setText("");
		txtTel.setText("");
		txtPuesto.setText("");
		txtHoraIn.setText("");
		txtHoraOut.setText("");
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnNuevo)){
			idempleado = 0;
			vista.getPaneEmpleado().setVisible(true);
			emptyForm();
		}else if(e.getSource().equals(btnGuardar) && idempleado == 0){
			if(fillField(txtNombre) && fillField(txtApPat) && fillField(txtApMat)){
				HashMap<String, String> datosEmpleado = new HashMap<String, String>();
				datosEmpleado.put("nombre", txtNombre.getText());
				datosEmpleado.put("appat", txtApPat.getText());
				datosEmpleado.put("apmat", txtApMat.getText());
				datosEmpleado.put("direccion", txtDir.getText());
				datosEmpleado.put("tel", txtTel.getText());
				datosEmpleado.put("puesto", txtPuesto.getText());
				datosEmpleado.put("horain", txtHoraIn.getText());
				datosEmpleado.put("horaout", txtHoraOut.getText());
				Empleado empleado = new Empleado(conn, datosEmpleado);
				tablaEmpleados.setModel(nuevoModeloTabla(getDataEmpleados(), columnasEmpleados));
				emptyForm();
			}
		}else if(e.getSource().equals(btnGuardar) && idempleado != 0){
			if(fillField(txtNombre) && fillField(txtApPat) && fillField(txtApMat)){
				Empleado empleado = new Empleado(conn, idempleado); 
				
				empleado.setNombre(txtNombre.getText());
				empleado.setAppat(txtApPat.getText());
				empleado.setApmat(txtApMat.getText());
				empleado.setDireccion(txtDir.getText());
				empleado.setTel(txtTel.getText());
				empleado.setPuesto(txtPuesto.getText());
				empleado.setHorain(txtHoraIn.getText());
				empleado.setHoraout(txtHoraOut.getText());
				
				tablaEmpleados.setModel(nuevoModeloTabla(getDataEmpleados(), columnasEmpleados));
				emptyForm();
			}
		}
	}

}
