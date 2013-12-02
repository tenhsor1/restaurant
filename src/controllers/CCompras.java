package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import models.Compras;
import models.Compras.Compra;
import models.Platillos;
import models.Platillos.Unidad;
import models.Productos;
import models.Productos.Producto;
import vectors.EditorCell;
import vectors.Item;
import vectors.ModelTable;
import vectors.RenderCell;
import views.VCompras;

import com.toedter.calendar.JDateChooser;

import conn.JDBC;

public class CCompras implements ActionListener{
	private JDBC conn;
	private JSplitPane panelPrincipal;
	private VCompras vista;
	private Compras compras;
	private Productos productos;
	private Platillos platillos;
	private ModelTable modelTableCompras;
	private JButton btnEditar, btnEliminar, btnNuevo, btnGuardar;
	private JTextField txtCantidad;
	private JComboBox<Item> cmbProductos, cmbUnidad;
	private JDateChooser dcCaducidad;
	private Object[] columnas = {"ID", "Fecha Compra", "Producto", "Cantidad", "Unidad", "Fecha Caducidad", "", ""};
	private JTable tablaCompras;
	private int idcompra = 0;
	public CCompras(JSplitPane panel, JDBC conn){
		this.conn = conn;
		panelPrincipal = panel;
		vista = new VCompras();
		compras = new Compras(conn);
		productos = new Productos(conn);
		platillos = new Platillos(conn);
	}
	
	public void iniciar(){
		idcompra = 0;
		panelPrincipal.setRightComponent(vista);
		
		modelTableCompras = nuevoModeloTabla(getDataCompras(), columnas);
		
		tablaCompras = vista.addTableCompras(modelTableCompras);
		tablaCompras.setDefaultRenderer(JButton.class, new RenderCell());
		tablaCompras.setDefaultEditor(JButton.class, new EditorCell());
		
		btnNuevo = vista.getBtnNuevo();
		btnNuevo.addActionListener(this);
		
		btnGuardar = vista.getBtnGuardar();
		btnGuardar.addActionListener(this);
			
		vista.setCmbProductos(comboProductos());
		cmbProductos = vista.getCmbProductos();
		txtCantidad = vista.getTxtCantidad();
		vista.setCmbUnidad(comboUnidades());
		cmbUnidad = vista.getCmbUnidad();
		dcCaducidad = vista.getDcCaducidad();
		
		
	}
	
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
	
	
	public Object[][] getDataCompras(){
		ArrayList<Compra> listaCompras = compras.getAllCompras();
		int numCompras = listaCompras.size();
		Object[][] comps = new Object[numCompras][8];
		
		int i = 0;
		for(final Compra c : listaCompras){
			comps[i][0] = c.getIdcompra();
			comps[i][1] = c.getFechacompra();
			comps[i][2] = c.getProducto();
			comps[i][3] = c.getCantidad();
			comps[i][4] = c.getUnidad();
			comps[i][5] = c.getFechacad();
			
			btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
						editCompra(c);
				}
			});
			comps[i][6] = btnEditar;
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					int opt = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar la compra de : " + c.getProducto() + "?", 
							"Eliminar Producto", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						compras.deleteCompra(c);
						tablaCompras.setModel(nuevoModeloTabla(getDataCompras(), columnas));
					}
				}
			});
			comps[i][7] = btnEliminar;
			i++;			
		}
		return comps;
	}
	
	public void editCompra(Compra c){
		idcompra = c.getIdcompra();
		cmbProductos.setSelectedIndex(c.getIndexProducto());
		txtCantidad.setText(Float.toString(c.getCantidad()));
		cmbUnidad.setSelectedIndex(c.getIndexUnidad());
		dcCaducidad.setDate(c.getFechacad());
	}
	
	public ModelTable nuevoModeloTabla(Object[][] data, Object[] columns){
		return new ModelTable(data, columns);
	}
	
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
	
	private boolean fillField(JTextField field){
		if(field.getText().equals("") || field.getText() == null){
			field.setBorder(BorderFactory.createLineBorder(Color.red));
			field.requestFocus();
			return false;
		}
		field.setBorder(BorderFactory.createLineBorder(Color.gray));
		return true;
	}
	
	public boolean DateValidation(JDateChooser dateField) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    try {
	        sdf.format(dateField.getDate());
	        dateField.setBorder(BorderFactory.createLineBorder(Color.gray));
	        return true;
	    }
	    catch(NullPointerException ex) {
	    	dateField.setBorder(BorderFactory.createLineBorder(Color.red));
			dateField.requestFocus();
	        return false;
	    }
	}
	
	private void emptyForm(){
		txtCantidad.setText("");
		dcCaducidad.setDate(null);
		cmbProductos.setSelectedIndex(0);
		cmbUnidad.setSelectedIndex(0);
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnNuevo)){
			idcompra = 0;
			emptyForm();
		}else if(e.getSource().equals(btnGuardar) && idcompra == 0){
			if(fillField(txtCantidad)){
				Item producto = (Item)cmbProductos.getSelectedItem();
				Item unidad = (Item)cmbUnidad.getSelectedItem();
				if(DateValidation(dcCaducidad)){
					Compra compra = new Compra(conn, producto.getId() , unidad.getId(), getNumber(txtCantidad.getText()), dcCaducidad.getDate());
					tablaCompras.setModel(nuevoModeloTabla(getDataCompras(), columnas));
					emptyForm();
				}
			}
		}else if(e.getSource().equals(btnGuardar) && idcompra != 0){
			if(fillField(txtCantidad)){
				Item producto = (Item)cmbProductos.getSelectedItem();
				Item unidad = (Item)cmbUnidad.getSelectedItem();
				if(DateValidation(dcCaducidad)){
					Compra compra = new Compra(conn, idcompra);
					compra.setIdproducto(producto.getId());
					compra.setCantidad(getNumber(txtCantidad.getText()));
					compra.setIdunidad(unidad.getId());
					compra.setFechacad(dcCaducidad.getDate());
					tablaCompras.setModel(nuevoModeloTabla(getDataCompras(), columnas));
					emptyForm();
				}
			}
		}
	}
}