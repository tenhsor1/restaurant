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

import models.Ventas;
import models.Ventas.PVentas;
import models.Ventas.Venta;
import vectors.EditorCell;
import vectors.Item;
import vectors.ModelTable;
import vectors.RenderCell;
import views.VVentas;
import conn.JDBC;

public class CVentas implements ActionListener{
	private JDBC conn;
	private JSplitPane panelPrincipal;
	private VVentas vista;
	private Ventas ventas;
	private int idVenta;
	private ModelTable modelTableVentas;
	private DefaultTableModel modelTablePlatillos;
	private JButton btnEditar, btnEliminar, btnNuevo, btnGuardar, btnAdd;
	private JTextField txtSubtotal, txtIVA, txtTotal, txtNumMesa;
	private ArrayList<PVentas> platillos;
	private JComboBox<Item> cmbPlatillos;
	private Object[] columnasVentas = {"ID", "Fecha Venta", "No. Mesa", "Subtotal", "IVA", "Total", "", ""};
	private Object[] columnasPlatillos = {"Platillo/bebida", "Precio"};
	private JTable tablaVentas, tablaPlatillos;
	
	public CVentas(JSplitPane panel, JDBC conn){
		this.conn = conn;
		panelPrincipal = panel;
		vista = new VVentas();
		ventas = new Ventas(this.conn);
	}
	
	public void iniciar(){
		idVenta = 0;
		panelPrincipal.setRightComponent(vista);
		
		modelTableVentas = nuevoModeloTabla(getDataVentas(), columnasVentas);
		
		tablaVentas = vista.addTableVentas(modelTableVentas);
		tablaVentas.setDefaultRenderer(JButton.class, new RenderCell());
		tablaVentas.setDefaultEditor(JButton.class, new EditorCell());
		modelTablePlatillos = new DefaultTableModel(null, columnasPlatillos){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex){
				return true;
			}
			 @Override
	            public Object getValueAt(int row, int col) {
         		float subtotal = 0, iva = 0, total = 0;   
				 if (col == 1) {
	                	Item i = (Item)this.getValueAt(row, 0);
	                	Item id;
	                	if(i.getId() > 0){
	                		PVentas p = platillos.get(i.getId()-1);

	                		for(int j = 0; j < getRowCount(); j++){
	                			if(j != row){
	                				id = (Item)this.getValueAt(j, 0);
	                				if(id.getId() > 0)
	                				subtotal += platillos.get(id.getId()-1).precio;
	                			}else{
	                				subtotal += p.precio;
	                			}
	                		}
	                		iva = subtotal * 0.16f;
	                		total = subtotal + iva;
	                		txtSubtotal.setText(Float.toString(subtotal));
	                		txtIVA.setText(Float.toString(iva));
	                		txtTotal.setText(Float.toString(total));
	                    	return p.precio;
	                	}else{
	                		
	                		for(int j = 0; j < getRowCount(); j++){
	                			if(j != row){
	                				id = (Item)this.getValueAt(j, 0);
	                				if(id.getId() > 0)
	                				subtotal += platillos.get(id.getId()-1).precio;
	                			}else{
	                				subtotal += (float)0.0;
	                			}
	                		}
	                		iva = subtotal * 0.16f;
	                		total = subtotal + iva;
	                		txtSubtotal.setText(Float.toString(subtotal));
	                		txtIVA.setText(Float.toString(iva));
	                		txtTotal.setText(Float.toString(total));
	                		return (float)0.0;
	                	}
	                	
	                	
	                } else {
	                    return super.getValueAt(row, col);
	                }
	            }
			 
			 @Override
	         public void setValueAt(Object aValue, int row, int col) {
	                super.setValueAt(aValue, row, col);
	                fireTableCellUpdated(row, 1); // may have changed
	         }
		};
		
		tablaPlatillos = vista.addTablePlatillos(modelTablePlatillos);
		
		cmbPlatillos = comboPlatillos();
		//cmbPlatillos.addItemListener(this);
		DefaultCellEditor dcp = new DefaultCellEditor(cmbPlatillos);
		tablaPlatillos.getColumnModel().getColumn(0).setCellEditor(dcp);
		modelTablePlatillos.addRow(nuevaFila());
		
		btnNuevo = vista.getBtnNuevo();
		btnNuevo.addActionListener(this);
		
		btnGuardar = vista.getBtnGuardar();
		btnGuardar.addActionListener(this);
		
		btnAdd = vista.getBtnAdd();
		btnAdd.addActionListener(this);
			
		txtSubtotal = vista.getTxtSubtotal();
		txtIVA = vista.getTxtIVA();
		txtTotal = vista.getTxtTotal();
		txtNumMesa = vista.getTxtNumMesa();
	}
	
	public Object[][] getDataVentas(){
		ArrayList<Venta> listaVentas = ventas.getAllVentas();
		int numVentas = listaVentas.size();
		Object[][] vents = new Object[numVentas][8];
		
		int i = 0;
		for(final Venta v : listaVentas){
			vents[i][0] = v.getIdventa();
			vents[i][1] = v.getFecha();
			vents[i][2] = v.getNummesa();
					
			vents[i][3] = v.getSubtotal();
			vents[i][4] = v.getIva();
			vents[i][5] = v.getTotal();
			
			btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
						editVenta(v);
				}
			});
			vents[i][6] = btnEditar;
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					int opt = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar la venta de : " + v.getFecha() + "?", 
							"Eliminar Venta", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						ventas.deleteVenta(v);
						tablaVentas.setModel(nuevoModeloTabla(getDataVentas(), columnasVentas));
					}
				}
			});
			vents[i][7] = btnEliminar;
			i++;			
		}
		return vents;
	}
	
	public void editVenta(Venta v){
		idVenta = v.getIdventa();
		txtSubtotal.setText(Float.toString(v.getSubtotal()));
		txtIVA.setText(Float.toString(v.getIva()));
		txtTotal.setText(Float.toString(v.getTotal()));
		txtNumMesa.setText(Float.toString(v.getNummesa()));
		removeRows(modelTablePlatillos);
		ArrayList<PVentas> v_platillos = v.getPVentas();
		for(PVentas vp : v_platillos){
			Object[] fila = new Object[2];
			fila[0] =  new Item(getPlatillosIndex(vp.idplatillo), vp.platillo);
			fila[1] = vp.precio;
			modelTablePlatillos.addRow(fila);
		}
	}
	
	private void emptyForm(){
		txtSubtotal.setText("");
		txtIVA.setText("");
		txtTotal.setText("");
		txtNumMesa.setText("");
		removeRows(modelTablePlatillos);
		
	}
	
	/*private boolean fillField(JTextField field){
		if(field.getText().equals("") || field.getText() == null){
			field.setBorder(BorderFactory.createLineBorder(Color.red));
			field.requestFocus();
			return false;
		}
		field.setBorder(BorderFactory.createLineBorder(Color.gray));
		return true;
	}*/
	
	public ModelTable nuevoModeloTabla(Object[][] data, Object[] columns){
		return new ModelTable(data, columns);
	}
	
	public JComboBox<Item> comboPlatillos(){
		platillos =  ventas.getAllPlatillos();
		Vector<Item> listaItems = new Vector<Item>();
		listaItems.add(new Item(0, "[Seleccione]"));
		int cont = 1;
		for(final PVentas p : platillos){
			listaItems.add(new Item(cont, p.platillo));
			cont++;
		}
		return new JComboBox<Item>(listaItems);
	}

	private void removeRows(DefaultTableModel modelo){
		int rows = modelo.getRowCount(); 
		for(int i = rows - 1; i >=0; i--)
		{
		   modelo.removeRow(i); 
		}
	}
	
	public Object[] nuevaFila(){
		Object[] fila = new Object[2];
		fila[0] = new Item(0, "[Seleccione]");
		fila[1] = "";
		return fila;
	}
	
	public ArrayList<PVentas> getPVentas(){
		ArrayList<PVentas> v_platillos = new ArrayList<PVentas>();
		for(int i=0;i<tablaPlatillos.getRowCount();i++){
			Item plat = (Item)tablaPlatillos.getValueAt(i, 0);
			if(plat.getId() != 0)
			v_platillos.add(new PVentas(platillos.get(plat.getId()).idplatillo, i, plat.getDescription(), 0));
		}
		return v_platillos;
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
	
	public int getPlatillosIndex(int idplatillo) {
	    for(int i = 0; i < platillos.size(); i++) {
	        if(platillos.get(i).idplatillo == idplatillo) return i;
	    }
	    return -1; //Or throw error if it wasn't found.
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)){
			modelTablePlatillos.addRow(nuevaFila());
		}else if(e.getSource().equals(btnNuevo)){
			emptyForm();
			modelTablePlatillos.addRow(nuevaFila());
			idVenta = 0;
		}else if(e.getSource().equals(btnGuardar) && idVenta == 0){			
			ArrayList<PVentas> v_platillos = getPVentas();
			if(v_platillos.size() == 0){
				btnAdd.setBorder(BorderFactory.createLineBorder(Color.red));
			}else{
				btnAdd.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				float subtotal = getNumber(txtSubtotal.getText());
				float iva = getNumber(txtIVA.getText());
				float total = getNumber(txtTotal.getText());
				int numMesa = (int)getNumber(txtNumMesa.getText());
				
				Venta v = new Venta(conn, subtotal, iva, total, numMesa, v_platillos);
				emptyForm();
				modelTablePlatillos.addRow(nuevaFila());
				tablaVentas.setModel(nuevoModeloTabla(getDataVentas(), columnasVentas));
			}
		}else if(e.getSource().equals(btnGuardar) && idVenta != 0){			
			ArrayList<PVentas> v_platillos = getPVentas();
			if(v_platillos.size() == 0){
				btnAdd.setBorder(BorderFactory.createLineBorder(Color.red));
			}else{
				btnAdd.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				float subtotal = getNumber(txtSubtotal.getText());
				float iva = getNumber(txtIVA.getText());
				float total = getNumber(txtTotal.getText());
				int numMesa = (int)getNumber(txtNumMesa.getText());
				
				Venta v = new Venta(conn, idVenta);
				v.setSubtotal(subtotal);
				v.setIva(iva);
				v.setTotal(total);
				v.setNummesa(numMesa);
				v.setPVentas(v_platillos);
				
				emptyForm();
				modelTablePlatillos.addRow(nuevaFila());
				tablaVentas.setModel(nuevoModeloTabla(getDataVentas(), columnasVentas));
			}
		}
	}
}
