package controllers;

import java.awt.Color;
<<<<<<< HEAD
import java.awt.Image;
import java.awt.Toolkit;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
<<<<<<< HEAD
import javax.swing.ImageIcon;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
<<<<<<< HEAD
import javax.swing.border.EmptyBorder;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c

import models.Productos;
import models.Productos.Categoria;
import models.Productos.Producto;
import vectors.EditorCell;
import vectors.Item;
import vectors.ModelTable;
import vectors.RenderCell;
<<<<<<< HEAD
import views.VLogin;
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
import views.VProductos;
import views.VProductos.VFormCategoria;
import views.VProductos.VFormProducto;
import conn.JDBC;

public class CProductos implements ActionListener{
	private JSplitPane panelPrincipal;
	private JTable tablaProductos, tablaCategorias;
	private VProductos vistaProductos;
	private ModelTable modelTableProductos, modelTableCategorias;
	private Productos productos;
	private Producto selectedProducto;
	private Categoria selectedCategoria;
	private JDBC conn;
	private int banderaVentana = 0;
	private JButton btnEditar, btnEliminar, btnNuevoProducto, btnNuevaCategoria, btnOkNuevo, btnOkEditar, btnOkNuevoCat, btnOkEditarCat;
	private VFormProducto panelProducto;
	private VFormCategoria panelCategoria;
	private Object[] columnasProductos = {"ID","Producto", "Categoria", "", ""}, columnasCategorias = {"ID","Categoria", "", ""};
	public CProductos(JSplitPane panel, JDBC conn){
		this.conn = conn;
		panelPrincipal = panel;
		vistaProductos = new VProductos();
	}
	
	public void iniciar(){
		productos = new Productos(conn); //Modelo de productos
		// agregamos la vista de productos al panel izquierdo
		panelPrincipal.setRightComponent(vistaProductos); 
		
		//Iniciamos el modelo de la tabla en la vista productos
		modelTableProductos = nuevoModeloTabla(getDataProductos(), columnasProductos);
		tablaProductos = vistaProductos.addTableProductos(modelTableProductos);
		tablaProductos.setDefaultRenderer(JButton.class, new RenderCell());
		tablaProductos.setDefaultEditor(JButton.class, new EditorCell());
		
		modelTableCategorias = nuevoModeloTabla(getDataCategorias(), columnasCategorias);
		tablaCategorias = vistaProductos.addTableCategorias(modelTableCategorias);
		tablaCategorias.setDefaultRenderer(JButton.class, new RenderCell());
		tablaCategorias.setDefaultEditor(JButton.class, new EditorCell());
		
<<<<<<< HEAD
		
=======
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		btnNuevoProducto = vistaProductos.getBtnNuevoProducto();
		btnNuevoProducto.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevoProducto();
			}
		});
		
		btnNuevaCategoria = vistaProductos.getBtnNuevaCategoria();
		btnNuevaCategoria.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevaCategoria();
			}
		});
		
		panelProducto =  vistaProductos.getPanelProducto();
		panelProducto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		panelProducto.setCmbCategoria(listaCategorias());
		
		panelCategoria =  vistaProductos.getPanelCategoria();
		panelCategoria.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public ModelTable nuevoModeloTabla(Object[][] data, Object[] columns){
		return new ModelTable(data, columns);
	}
	
	public Object[][] getDataProductos(){
		ArrayList<Producto> listaProds = productos.getAllProductos();
		int numProductos = listaProds.size();
		Object[][] prods = new Object[numProductos][5];
		
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
		for(final Producto p : listaProds){
			prods[i][0] = p.getIdproducto();
			prods[i][1] = p.getProducto();
			prods[i][2] = p.getCategoria();
			
<<<<<<< HEAD
			btnEditar = new JButton("");
			btnEditar.setIcon(icnEditar);
			btnEditar.setToolTipText("Editar Producto");
			//Importante
			btnEditar.setOpaque(false);
			btnEditar.setContentAreaFilled(false);
			btnEditar.setBorder(new EmptyBorder(0, 0, 0, 0));
			//Importante
=======
			btnEditar = new JButton("Editar");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
			btnEditar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						editProducto(p.getIdproducto());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			prods[i][3] = btnEditar;
			
<<<<<<< HEAD
			btnEliminar = new JButton("");
			btnEliminar.setIcon(icnEliminar);
			btnEliminar.setToolTipText("Eliminar Producto");
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
				public void actionPerformed(ActionEvent e) {
					int opt = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el producto: " + p.getProducto() + "?", 
							"Eliminar Producto", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						productos.deleteProducto(p.getIdproducto());
						tablaProductos.setModel(nuevoModeloTabla(getDataProductos(), columnasProductos));
					}
				}
			});
			prods[i][4] = btnEliminar;
			i++;			
		}
		return prods;
	}

	
	public Object[][] getDataCategorias(){
		ArrayList<Categoria> listaCats = productos.getAllCategorias();
		int numCategorias = listaCats.size();
		Object[][] cats = new Object[numCategorias][4];
		
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
		for(final Categoria c : listaCats){
			cats[i][0] = c.getIdcategoria();
			cats[i][1] = c.getCategoria();
			
<<<<<<< HEAD
			btnEditar= new JButton("");
			btnEditar.setIcon(icnEditar);
			btnEditar.setToolTipText("Editar Categoría");
			//Importante
			btnEditar.setOpaque(false);
			btnEditar.setContentAreaFilled(false);
			btnEditar.setBorder(new EmptyBorder(0, 0, 0, 0));
			//Importante
=======
			btnEditar= new JButton("Editar");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
			btnEditar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						editCategoria(c.getIdcategoria());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			cats[i][2] = btnEditar;
			
<<<<<<< HEAD
			btnEliminar = new JButton("");
			btnEliminar.setIcon(icnEliminar);
			btnEliminar.setToolTipText("Eliminar  Categoría");
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
				public void actionPerformed(ActionEvent e) {
					int opt = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar la categoría: " + c.getCategoria() + "?", 
							"Eliminar Categoría", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						productos.deleteCategoria(c.getIdcategoria());
						tablaCategorias.setModel(nuevoModeloTabla(getDataCategorias(), columnasCategorias));
					}
				}
			});
			cats[i][3] = btnEliminar;
			i++;			
		}
		return cats;
	}
	
	
	
	
	private void nuevoProducto(){
		
		panelProducto.setTitle("Nuevo Producto");
		panelProducto.setVisible(true);
		
		btnOkNuevo = panelProducto.getOkButton();
		btnOkNuevo.addActionListener(this);
		banderaVentana = 1;
	}
	
	private void editProducto(int idproducto) throws SQLException{
		panelProducto.setTitle("Editar Producto");
		panelProducto.setVisible(true);
		
		selectedProducto = new Producto(conn, idproducto);
		
		panelProducto.getTxtProducto().setText(selectedProducto.getProducto());
		panelProducto.getCmbCategoria().setSelectedIndex(selectedProducto.getIndexCategoria());
		
		btnOkEditar = panelProducto.getOkButton();
		btnOkEditar.addActionListener(this);
		banderaVentana = 2;
	}
	
	private void nuevaCategoria(){
		
		panelCategoria.setTitle("Nueva Categoría");
		panelCategoria.setVisible(true);
		
		btnOkNuevoCat = panelCategoria.getOkButton();
		btnOkNuevoCat.addActionListener(this);
		banderaVentana = 1;
	}
	
	private void editCategoria(int idcategoria) throws SQLException{
		panelCategoria.setTitle("Editar Categoría");
		panelCategoria.setVisible(true);
		
		selectedCategoria = new Categoria(conn, idcategoria);
		
		panelCategoria.getTxtCategoria().setText(selectedCategoria.getCategoria());
		
		btnOkEditarCat = panelCategoria.getOkButton();
		btnOkEditarCat.addActionListener(this);
		banderaVentana = 2;
	}
	
	
	private JComboBox<Item> listaCategorias(){
		ArrayList<Categoria> categorias = productos.getAllCategorias();
		Vector<Item> listaItems = new Vector<Item>();
		for(Categoria categoria : categorias){
			listaItems.add(new Item(categoria.getIdcategoria(), categoria.getCategoria()));
		}
		
		JComboBox<Item> cmbCategoria = new JComboBox<Item>(listaItems);
		cmbCategoria.setToolTipText("Selecciona una categor\u00EDa");
		cmbCategoria.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		return cmbCategoria;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOkNuevo) && banderaVentana == 1){
			String nomProducto = panelProducto.getTxtProducto().getText();
			if(nomProducto.equals("") || nomProducto == null){
				panelProducto.getTxtProducto().setBorder(BorderFactory.createLineBorder(Color.red));
				panelProducto.getTxtProducto().requestFocus();
			}else{
				Item selectedCategoria = (Item) panelProducto.getCmbCategoria().getSelectedItem();
				@SuppressWarnings("unused")
				Producto nuevoProducto = new Producto(conn, nomProducto, selectedCategoria.getId());
				tablaProductos.setModel(nuevoModeloTabla(getDataProductos(), columnasProductos));
				panelProducto.getTxtProducto().setText("");
				panelProducto.getTxtProducto().requestFocus();
			}
		}else if(e.getSource().equals(btnOkEditar) && banderaVentana == 2){
			String nomProducto = panelProducto.getTxtProducto().getText();
			if(nomProducto.equals("") || nomProducto == null){
				panelProducto.getTxtProducto().setBorder(BorderFactory.createLineBorder(Color.red));
				panelProducto.getTxtProducto().requestFocus();
			}else{
				System.out.println("entra");
				Item selectedCategoria = (Item) panelProducto.getCmbCategoria().getSelectedItem();
				selectedProducto.setProducto(nomProducto);
				selectedProducto.setIdcategoria(selectedCategoria.getId());
				tablaProductos.setModel(nuevoModeloTabla(getDataProductos(), columnasProductos));
				panelProducto.setVisible(false);
			}
		}else if(e.getSource().equals(btnOkNuevoCat) && banderaVentana == 1){
			String nomCategoria = panelCategoria.getTxtCategoria().getText();
			if(nomCategoria.equals("") || nomCategoria == null){
				panelProducto.getTxtProducto().setBorder(BorderFactory.createLineBorder(Color.red));
				panelProducto.getTxtProducto().requestFocus();
			}else{
				@SuppressWarnings("unused")
				Categoria nuevoCategoria = new Categoria(conn, nomCategoria);
				tablaCategorias.setModel(nuevoModeloTabla(getDataCategorias(), columnasCategorias));
				panelCategoria.getTxtCategoria().setText("");
				panelCategoria.getTxtCategoria().requestFocus();
			}
		}else if(e.getSource().equals(btnOkEditarCat) && banderaVentana == 2){
			String nomCategoria = panelCategoria.getTxtCategoria().getText();
			if(nomCategoria.equals("") || nomCategoria == null){
				panelCategoria.getTxtCategoria().setBorder(BorderFactory.createLineBorder(Color.red));
				panelCategoria.getTxtCategoria().requestFocus();
			}else{
				selectedCategoria.setCategoria(nomCategoria);
				tablaCategorias.setModel(nuevoModeloTabla(getDataCategorias(), columnasCategorias));
				panelCategoria.setVisible(false);
			}
		}
		
		
	}
	
}