package controllers;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;

import models.Usuarios.Usuario;
import views.VMain;
import views.VMenu;
import views.VPortada;
=======
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import views.VMain;
import views.VMenu;
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
import conn.JDBC;

public class CMain implements ActionListener {
	private static VMain vista;
	private static VMenu vistaMenu;
<<<<<<< HEAD
	private static VPortada vistaPortada;
	private Usuario usuario;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
	private JDBC conn;
	public static void main(String[] args) {

	}
	
<<<<<<< HEAD
	public CMain(Usuario usuario){
		vista = new VMain();	
		vista.iniciarVista();
		vistaMenu = new VMenu();
		vistaPortada = new VPortada();
		this.usuario = usuario;
=======
	public CMain(){
		vista = new VMain();	
		vista.iniciarVista();
		vistaMenu = new VMenu();
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
	}
	
	public void iniciar(){
		try {
			conn = new JDBC("127.0.0.1", "restaurant", "root", "abc123");
			vista.getSplitPane().setLeftComponent(vistaMenu);
<<<<<<< HEAD
			vista.getSplitPane().setRightComponent(vistaPortada);
			
			HashMap<Integer, Boolean> permisos = usuario.getPermisos();
			int col = 0;
			for(Integer key : permisos.keySet()){
				switch(key){
				case 0:
					vistaMenu.add(vistaMenu.getBtnMProductos(), "cell " + col + " 0");
					break;
				case 1:
					vistaMenu.add(vistaMenu.getBtnMPlatillos(), "cell " + col + " 0");
					break;
				case 2:
					vistaMenu.add(vistaMenu.getBtnMEmpleados(), "cell " + col + " 0");
					break;
				case 3:
					vistaMenu.add(vistaMenu.getBtnMVentas(), "cell " + col + " 0");
					break;
				case 4:
					vistaMenu.add(vistaMenu.getBtnMCompras(), "cell " + col + " 0");
					break;
				case 5:
					vistaMenu.add(vistaMenu.getBtnMUsuarios(), "cell " + col + " 0");
					break;
				case 6:
					//vistaMenu.add(vistaMenu.getBtnMReportes(), "cell " + col + " 0");
					break;
				}
				col += 5;
			}
			
=======
			vista.getSplitPane().setRightComponent(new JButton("Button"));
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
			vistaMenu.getBtnMProductos().addActionListener(this);
			vistaMenu.getBtnMPlatillos().addActionListener(this);
			vistaMenu.getBtnMEmpleados().addActionListener(this);
			vistaMenu.getBtnMCompras().addActionListener(this);
			vistaMenu.getBtnMVentas().addActionListener(this);
<<<<<<< HEAD
			vistaMenu.getBtnMUsuarios().addActionListener(this);
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vistaMenu.getBtnMProductos())){
			CProductos cProducto = new CProductos(vista.getSplitPane(), conn);
			cProducto.iniciar();
		
		}else if(e.getSource().equals(vistaMenu.getBtnMPlatillos())){
			CPlatillos cPlatillos = new CPlatillos(vista.getSplitPane(), conn);
			cPlatillos.iniciar();
		
		}else if(e.getSource().equals(vistaMenu.getBtnMEmpleados())){
			CEmpleados cEmpledos = new CEmpleados(vista.getSplitPane(), conn);
			cEmpledos.iniciar();
		
		}else if(e.getSource().equals(vistaMenu.getBtnMCompras())){
			CCompras cCompras = new CCompras(vista.getSplitPane(), conn);
			cCompras.iniciar();
		
		}else if(e.getSource().equals(vistaMenu.getBtnMVentas())){
			CVentas cVentas = new CVentas(vista.getSplitPane(), conn);
			cVentas.iniciar();
<<<<<<< HEAD
		
		}else if(e.getSource().equals(vistaMenu.getBtnMUsuarios())){
			CUsuarios cUsuarios = new CUsuarios(vista.getSplitPane(), conn);
			cUsuarios.iniciar();
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		}
	}
}
