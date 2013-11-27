package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import views.VMain;
import views.VMenu;
import conn.JDBC;

public class CMain implements ActionListener {
	private static VMain vista;
	private static VMenu vistaMenu;
	private JDBC conn;
	public static void main(String[] args) {

	}
	
	public CMain(){
		vista = new VMain();	
		vista.iniciarVista();
		vistaMenu = new VMenu();
	}
	
	public void iniciar(){
		try {
			conn = new JDBC("127.0.0.1", "restaurant", "root", "abc123");
			vista.getSplitPane().setLeftComponent(vistaMenu);
			vistaMenu.getBtnMProductos().addActionListener(this);
			vistaMenu.getBtnMPlatillos().addActionListener(this);
			vistaMenu.getBtnMEmpleados().addActionListener(this);
			vistaMenu.getBtnMCompras().addActionListener(this);
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
		}
	}
}
