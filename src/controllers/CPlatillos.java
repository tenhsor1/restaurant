package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import models.Platillos;
import models.Platillos.Platillo;
import vectors.EditorCell;
import vectors.ModelTable;
import vectors.RenderCell;
import views.VPlatillos;
import conn.JDBC;

public class CPlatillos implements ActionListener{
	private JDBC conn;
	private JSplitPane panelPrincipal;
	private VPlatillos vista;
	private Platillos platillos;
	private JButton btnEditar, btnEliminar;
	private ModelTable modelTablePlatillos;
	private Object[] columnasPlatillos = {"ID", "platillo", "", ""};
	private JTable tablaPlatillos;
	public CPlatillos(JSplitPane panel, JDBC conn){
		this.conn = conn;
		panelPrincipal = panel;
		vista = new VPlatillos();
	}
	
	public void iniciar(){
		platillos = new Platillos(conn);
		panelPrincipal.setRightComponent(vista);
		
		modelTablePlatillos = nuevoModeloTabla(getDataPlatillos(), columnasPlatillos);
		tablaPlatillos = vista.addTablePlatillos(modelTablePlatillos);
		tablaPlatillos.setDefaultRenderer(JButton.class, new RenderCell());
		tablaPlatillos.setDefaultEditor(JButton.class, new EditorCell());
	}
	
	public Object[][] getDataPlatillos(){
		ArrayList<Platillo> listaPlatillos = platillos.getAllPlatillos();
		int numPlatillos = listaPlatillos.size();
		Object[][] plats = new Object[numPlatillos][4];
		
		int i = 0;
		for(final Platillo p : listaPlatillos){
			plats[i][0] = p.getIdplatillo();
			plats[i][1] = p.getPlatillo();
			
			btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						editPlatillo(p);
					} 
					
			});
			plats[i][2] = btnEditar;
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						editPlatillo(p);
					} 
					
			});
			plats[i][3] = btnEliminar;
			i++;			
		}
		return plats;
	}
	
	private void editPlatillo(Platillo platillo){
		
	
	}
	
	public ModelTable nuevoModeloTabla(Object[][] data, Object[] columns){
		return new ModelTable(data, columns);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
