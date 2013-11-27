package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import models.Platillos;
import models.Platillos.Platillo;
import models.Platillos.ProdPlatillo;
import models.Platillos.Unidad;
import models.Productos;
import models.Productos.Producto;
import vectors.EditorCell;
import vectors.Item;
import vectors.ModelTable;
import vectors.RenderCell;
import views.VPlatillos;
import conn.JDBC;

public class CPlatillos implements ActionListener{
	private JDBC conn;
	private JSplitPane panelPrincipal;
	private VPlatillos vista;
	private Platillos platillos;
	private Productos productos;
	private JButton btnEditar, btnEliminar, btnNuevo, btnGuardar, btnAdd;
	private ModelTable modelTablePlatillos;
	private DefaultTableModel modelTableProductos;
	private JTextField txtPlatillo, txtPrecio;
	private Object[] columnasPlatillos = {"ID", "platillo", "", ""}, 
			columnasProductos = {"ID", "producto", "cantidad", "unidad"};
	private JTable tablaPlatillos, tablaProductos;
	private int bandAccion;
	public CPlatillos(JSplitPane panel, JDBC conn){
		this.conn = conn;
		panelPrincipal = panel;
		vista = new VPlatillos();
	}
	
	public void iniciar(){
		bandAccion = 0;
		platillos = new Platillos(conn);
		productos = new Productos(conn);
		panelPrincipal.setRightComponent(vista);
		
		modelTablePlatillos = nuevoModeloTabla(getDataPlatillos(), columnasPlatillos);
		tablaPlatillos = vista.addTablePlatillos(modelTablePlatillos);
		tablaPlatillos.setDefaultRenderer(JButton.class, new RenderCell());
		tablaPlatillos.setDefaultEditor(JButton.class, new EditorCell());
		
		
		modelTableProductos = new DefaultTableModel(null, columnasProductos){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex){
				return columnIndex != 0;
			}
		};
		btnNuevo = vista.getBtnNuevoPlatillo();
		btnNuevo.addActionListener(this);
		
		btnAdd = vista.getBtnAddProducto();
		btnAdd.addActionListener(this);
		
		txtPlatillo = vista.getTxtPlatillo();
		txtPrecio = vista.getTxtPrecio();
	}
	//obtiene la información de todos los platillos y les da formato para agregarlos a una JTable
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
						int opt = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el platillo: " + p.getPlatillo() + "?", 
								"Eliminar Platillo", JOptionPane.YES_NO_OPTION);
						if(opt == 0){
							platillos.deletePlatillo(p);
							tablaPlatillos.setModel(nuevoModeloTabla(getDataPlatillos(), columnasPlatillos));
						}
					} 
			});
			plats[i][3] = btnEliminar;
			i++;			
		}
		return plats;
	}
	
	private void editPlatillo(Platillo platillo){ 
		vista.activarW();
		btnGuardar = vista.getBtnGuardarPlatillo();
		btnGuardar.setVisible(true);
		btnGuardar.addActionListener(this);
		removeRows(modelTableProductos);
		tablaProductos = vista.addTableProdPlatillos(modelTableProductos);
		vista.getTxtPlatillo().setText(platillo.getPlatillo());
		vista.getTxtPrecio().setText(Float.toString(platillo.getPrecio()));
		bandAccion = platillo.getIdplatillo();
		//definimos que la columna 2 y 4 serán JComboBox con los productos y unidades
		DefaultCellEditor dcp = new DefaultCellEditor(comboProductos());
		DefaultCellEditor dcu = new DefaultCellEditor(comboUnidades());
		tablaProductos.getColumnModel().getColumn(1).setCellEditor(dcp);
		tablaProductos.getColumnModel().getColumn(3).setCellEditor(dcu);
		 
		ArrayList<ProdPlatillo> prods_platillo = platillo.getProductos_platillo();
		for(ProdPlatillo pp : prods_platillo){
			Object[] fila = new Object[4];
			fila[0] = pp.idproducto_platillo;
			fila[1] = new Item(pp.idproducto, pp.producto);
			fila[2] = pp.cantidad;
			fila[3] = new Item(pp.idunidad, pp.unidad);
			modelTableProductos.addRow(fila);
		}
	}
	private void nuevoPlatillo(){
		vista.activarW();
		btnGuardar = vista.getBtnGuardarPlatillo();
		btnGuardar.setVisible(true);
		btnGuardar.addActionListener(this);
		removeRows(modelTableProductos);
		vista.getTxtPlatillo().setText("");
		vista.getTxtPrecio().setText("");
		tablaProductos = vista.addTableProdPlatillos(modelTableProductos);
		 
		 //definimos que la columna 2 y 4 serán JComboBox con los productos y unidades
		 DefaultCellEditor dcp = new DefaultCellEditor(comboProductos());
		 DefaultCellEditor dcu = new DefaultCellEditor(comboUnidades());
		 tablaProductos.getColumnModel().getColumn(1).setCellEditor(dcp);
		 tablaProductos.getColumnModel().getColumn(3).setCellEditor(dcu);
	}
	
	public ModelTable nuevoModeloTabla(Object[][] data, Object[] columns){
		return new ModelTable(data, columns);
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		//cuando se presiona el boton de nuevo
		if(e.getSource().equals(btnNuevo)){
			bandAccion = 0;
			nuevoPlatillo();
			//mostramos el panel de platillo y asignamos al actionlistener al boton de guardar
			 modelTableProductos.addRow(nuevaFila()); //agregamos una fila vacía a la tabla de productos
			
		//cuando se presiona el boton de guardar y se estaba en nuevo	 
		}else if(e.getSource().equals(btnGuardar) && bandAccion == 0){
			//si esta vacio el campo de platillo, se indica
			if(txtPlatillo.getText().equals("") || txtPlatillo.getText() == null){
				txtPlatillo.setBorder(BorderFactory.createLineBorder(Color.red));
				txtPlatillo.requestFocus();
			}else{
				//obtenemos los valores de la tabla de productos por platillo
				ArrayList<ProdPlatillo> prod_platillos = new ArrayList<ProdPlatillo>();
				for(int i=0;i<tablaProductos.getRowCount();i++){
					Item prod = (Item)tablaProductos.getValueAt(i, 1);
					Item unid = (Item)tablaProductos.getValueAt(i, 3);
					float cant = getNumber(tablaProductos.getValueAt(i, 2));
					prod_platillos.add(new ProdPlatillo(prod.getId(), unid.getId(), cant));
				}
				//creamos el nuevo platillo
				float precio=getNumber(txtPrecio.getText());
				Platillo p = new Platillo(conn, txtPlatillo.getText(), precio, prod_platillos);
				tablaPlatillos.setModel(nuevoModeloTabla(getDataPlatillos(), columnasPlatillos));
				//vaciamos la información para una nueva captura
				txtPlatillo.setText("");
				txtPrecio.setText("");
				removeRows(modelTableProductos);
				modelTableProductos.addRow(nuevaFila());
			}
		}else if(e.getSource().equals(btnAdd)){
			modelTableProductos.addRow(nuevaFila());
		}else if(e.getSource().equals(btnGuardar) && bandAccion != 0){
			//si esta vacio el campo de platillo, se indica
			if(txtPlatillo.getText().equals("") || txtPlatillo.getText() == null){
				txtPlatillo.setBorder(BorderFactory.createLineBorder(Color.red));
				txtPlatillo.requestFocus();
			}else{
				//obtenemos los valores de la tabla de productos por platillo
				ArrayList<ProdPlatillo> prod_platillos = new ArrayList<ProdPlatillo>();
				for(int i=0;i<tablaProductos.getRowCount();i++){
					int idproducto_platillo = (tablaProductos.getValueAt(i, 0) == "")? 0 : (Integer)tablaProductos.getValueAt(i, 0);
					Item prod = (Item)tablaProductos.getValueAt(i, 1);
					Item unid = (Item)tablaProductos.getValueAt(i, 3);
					float cant = getNumber(tablaProductos.getValueAt(i, 2));
					prod_platillos.add(new ProdPlatillo(idproducto_platillo, prod.getId(), unid.getId(), cant, prod.getDescription(), unid.getDescription()));
				}
				//obtenemos el platillo especificado y modificamos sus componentes
				Platillo p = new Platillo(conn, bandAccion);
				p.setPlatillo(txtPlatillo.getText());
				p.setPrecio(getNumber(txtPrecio.getText()));
				p.setProductos_platillo(prod_platillos);
				
				tablaPlatillos.setModel(nuevoModeloTabla(getDataPlatillos(), columnasPlatillos));
				//llenamos la tabla con los nuevos id's
				editPlatillo(p);
			}
		}
	}
	//genera una nueva fila para la lista de productos
	public Object[] nuevaFila(){
		Object[] fila = new Object[4];
		fila[0] = "";
		fila[1] = new Item(0, "[Seleccione]");
		fila[2] = "";
		fila[3] = new Item(0, "[Seleccione]");
		return fila;
	}
	//regresa un combo con la lista de unidades
	public JComboBox<Item> comboUnidades(){
		ArrayList<Unidad> unidades =  platillos.getAllUnidades();
		Vector<Item> listaItems = new Vector<Item>();
		
		for(final Unidad u : unidades){
			listaItems.add(new Item(u.idunidad, u.unidad));
		}
		return new JComboBox<Item>(listaItems);
	}
	//regresa un combo con la lista de productos
	public JComboBox<Item> comboProductos(){
		ArrayList<Producto> listaProductos =  productos.getAllProductos();
		Vector<Item> listaItems = new Vector<Item>();
		
		for(final Producto p : listaProductos){
			listaItems.add(new Item(p.getIdproducto(), p.getProducto()));
		}
		return new JComboBox<Item>(listaItems);
	}
	//comprueba si una cadena tiene valores numericos
	private static float getNumber(Object cadena){
		if(cadena instanceof String){
			try {
				return Float.parseFloat((String) cadena);
			} catch (NumberFormatException nfe){
				return 0;
			}
		}else if(cadena instanceof Float){
			return (Float)cadena;
		}else{
			return 0;
		}
	}
	//borra el contenido de una tabla
	private void removeRows(DefaultTableModel modelo){
		int rows = modelo.getRowCount(); 
		for(int i = rows - 1; i >=0; i--)
		{
		   modelo.removeRow(i); 
		}
	}
}
