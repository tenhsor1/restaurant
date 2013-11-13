package vectors;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import models.Productos;
import models.Productos.Categoria;
import net.miginfocom.swing.MigLayout;
import conn.JDBC;

public  class VFormProductos extends JDialog implements  ActionListener{

	private static final long serialVersionUID = 7071389459783724540L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtProducto;
	private JComboBox<Item> cmbCategoria;
	
	public static void main(String[] args) {
		VFormProductos v = new VFormProductos();
		v.setVisible(true);
		v.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public VFormProductos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow]", "[][][][]"));

		JLabel lblProducto = new JLabel("Producto");
		contentPanel.add(lblProducto, "cell 1 1");
			
		txtProducto = new JTextField();
		txtProducto.setToolTipText("Nuevo Producto");
		contentPanel.add(txtProducto, "cell 3 1,growx");

		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		contentPanel.add(lblCategoria, "cell 1 3");

		ArrayList<Categoria> categorias;
		Productos p;
		try {
			p = new Productos(new JDBC("127.0.0.1", "restaurant", "root", "abc123"));
			categorias = p.getAllCategorias();
			Vector<Item> model = new Vector<Item>();
			
			for(final Categoria c : categorias){
				System.out.println(c.getCategoria());
				model.add(new Item(c.getIdcategoria(), c.getCategoria()));
				
			}
			cmbCategoria = new JComboBox<Item>(model);
			cmbCategoria.setToolTipText("Selecciona una categor\u00EDa");
			cmbCategoria = new JComboBox<Item>( model );
			cmbCategoria.addActionListener( this );
			cmbCategoria.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
			contentPanel.add(cmbCategoria, "cell 3 3,growx");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("Guardar");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
						
			}
		});
		buttonPane.add(cancelButton);
	}
/*
	public JComboBox<Hashtable<Integer, String>> getCmbCategoria() {
		return cmbCategoria;
	}

	public void setCmbCategoria(JComboBox<Hashtable<Integer, String>> cmbCategoria) {
		this.cmbCategoria = cmbCategoria;
	}
*/
	public JTextField getTxtProducto() {
		return txtProducto;
	}

	public void setTxtNuevoProducto(JTextField txtNuevoProducto) {
		this.txtProducto = txtNuevoProducto;
	}
	
	
	class Item  
    {  
        private int id;  
        private String description;  
  
        public Item(int id, String description)  
        {  
            this.id = id;  
            this.description = description;  
        }  
  
        public int getId()  
        {  
            return id;  
        }  
  
        public String getDescription()  
        {  
            return description;  
        }  
  
        public String toString()  
        {  
            return description;  
        }  
    }  

	class ItemRenderer extends BasicComboBoxRenderer  
    {  
		private static final long serialVersionUID = 5070435280594257329L;

		public Component getListCellRendererComponent(  
            @SuppressWarnings("rawtypes") JList list, Object value, int index,  
            boolean isSelected, boolean cellHasFocus)
		{  
            super.getListCellRendererComponent(list, value, index,  
                isSelected, cellHasFocus);  
  
            if (value != null)  
            {  
                Item item = (Item)value;  
                setText( item.getDescription().toUpperCase() );  
            }  
  
            if (index == -1)  
            {  
                Item item = (Item)value;  
                setText( "" + item.getId() );  
            }  
  
  
            return this;  
        }  
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}  
}
