package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;

import views.VCompras;
import views.VPlatillos;
import conn.JDBC;

public class CCompras implements ActionListener{
	private JDBC conn;
	private JSplitPane panelPrincipal;
	private VCompras vista;
	
	public CCompras(JSplitPane panel, JDBC conn){
		this.conn = conn;
		panelPrincipal = panel;
		vista = new VCompras();
	}
	
	public void iniciar(){
		panelPrincipal.setRightComponent(vista);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
