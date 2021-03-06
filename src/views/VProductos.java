package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import vectors.Item;
import vectors.ModelTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VProductos extends JPanel {

	private static final long serialVersionUID = -3276610171353503066L;
	private JTable tableProductos, tableCategorias;
	private JScrollPane scrollPaneProductos, scrollPaneCategorias;
	private JButton btnNuevoProducto, btnNuevaCategoria;
	private VFormProducto panelProducto;
	private VFormCategoria panelCategoria;
	public VProductos() {
<<<<<<< HEAD
		setLayout(new MigLayout("", "[][grow][grow][grow]", "[][][][grow]"));
		setBackground(new Color(236, 240, 241));
		
		btnNuevoProducto = new JButton("Nuevo Producto");
		btnNuevoProducto.setFont(new Font("lato",Font.PLAIN,11));
		add(btnNuevoProducto, "cell 1 1");
		
		btnNuevaCategoria = new JButton("Nueva Categor�a");
		btnNuevaCategoria.setFont(new Font("lato",Font.PLAIN,11));
		add(btnNuevaCategoria, "cell 4 1");
		
		panelProducto = new VFormProducto();
		panelProducto.setTitle("Agregar nuevo producto");
=======
		setLayout(new MigLayout("", "[][][grow][grow]", "[][][][grow]"));
		setBackground(Color.DARK_GRAY);
		
		btnNuevoProducto = new JButton("Nuevo Producto");
		add(btnNuevoProducto, "cell 2 2");
		
		btnNuevaCategoria = new JButton("Nueva Categor�a");
		add(btnNuevaCategoria, "cell 4 2");
		
		panelProducto = new VFormProducto();
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		panelProducto.getTxtProducto().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c = evt.getKeyChar();
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
					evt.consume();

			}
			
		});
		panelProducto.getOkButton().setFont(new Font("Lato", Font.PLAIN, 11));
		panelProducto.getTxtProducto().setFont(new Font("Lato", Font.PLAIN, 11));
		panelProducto.getContentPane().setFont(new Font("Lato", Font.PLAIN, 11));
		panelProducto.setIconImage(Toolkit.getDefaultToolkit().getImage(VProductos.class.getResource("/assets/wine_big.png")));
		
		panelCategoria = new VFormCategoria();
		panelCategoria.setIconImage(Toolkit.getDefaultToolkit().getImage(VProductos.class.getResource("/assets/restaurant.png")));
	}
	

	public JTable addTableProductos(ModelTable modelProductos){
		tableProductos = new JTable(modelProductos);
<<<<<<< HEAD
		tableProductos.setFont(new Font("Lato", Font.PLAIN, 11));
		tableProductos.getTableHeader().setBackground(new Color(0, 153, 102));
		tableProductos.getTableHeader().setFont(new Font("lato", Font.BOLD, 12));
		tableProductos.getTableHeader().setForeground(Color.white);
		tableProductos.getColumnModel().getColumn(4).setMaxWidth(25);
		tableProductos.getColumnModel().getColumn(3).setMaxWidth(25);
		tableProductos.getColumnModel().getColumn(0).setMaxWidth(40);
		tableProductos.setRowHeight(30);
		tableProductos.setAlignmentX(CENTER_ALIGNMENT);
		scrollPaneProductos = new JScrollPane(tableProductos);
		scrollPaneProductos.setOpaque(false);
		scrollPaneProductos.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(scrollPaneProductos, "cell 1 2 2 1, grow");
=======
		scrollPaneProductos = new JScrollPane(tableProductos);
		add(scrollPaneProductos, "cell 2 3 2 1,grow");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		return tableProductos;
	}
	
	public JTable addTableCategorias(ModelTable modelCategorias){
		tableCategorias = new JTable(modelCategorias);
<<<<<<< HEAD
		tableCategorias.setFont(new Font("Lato", Font.PLAIN, 11));
		tableCategorias.getTableHeader().setBackground(new Color(0, 153, 102));
		tableCategorias.getTableHeader().setFont(new Font("lato", Font.BOLD, 12));
		tableCategorias.getTableHeader().setForeground(Color.white);
		tableCategorias.getColumnModel().getColumn(3).setMaxWidth(25);
		tableCategorias.getColumnModel().getColumn(2).setMaxWidth(25);
		tableCategorias.getColumnModel().getColumn(0).setMaxWidth(40);
		tableCategorias.setRowHeight(30);
		scrollPaneCategorias = new JScrollPane(tableCategorias);
		scrollPaneCategorias.setOpaque(false);
		scrollPaneCategorias.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(scrollPaneCategorias, "cell 4 2,alignx left, grow");
=======
		scrollPaneCategorias = new JScrollPane(tableCategorias);
		add(scrollPaneCategorias, "cell 4 3,grow");
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		return tableCategorias;
	}
	
	public JButton getBtnNuevoProducto() {
		return btnNuevoProducto;
	}

	public void setBtnNuevoProducto(JButton btnNuevoProducto) {
		this.btnNuevoProducto = btnNuevoProducto;
	}
	
	public JButton getBtnNuevaCategoria() {
		return btnNuevaCategoria;
	}


	public void setBtnNuevaCategoria(JButton btnNuevaCategoria) {
		this.btnNuevaCategoria = btnNuevaCategoria;
	}
	
	public VFormProducto getPanelProducto() {
		return panelProducto;
	}
	
	public void setPanelProducto(VFormProducto panelProducto) {
		this.panelProducto = panelProducto;
	}
	
	public VFormCategoria getPanelCategoria() {
		return panelCategoria;
	}


	public void setPanelCategoria(VFormCategoria panelCategoria) {
		this.panelCategoria = panelCategoria;
	}
	
	public static class VFormProducto extends JDialog {
		private static final long serialVersionUID = 7071389459783724540L;
		private final JPanel contentPanel = new JPanel();
		private JTextField txtProducto;
		private JComboBox<Item> cmbCategoria;
		private JButton okButton;
		public VFormProducto() {
			setBounds(100, 100, 450, 180);
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

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			okButton = new JButton("Guardar");
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

		public JComboBox<Item> getCmbCategoria() {
			return cmbCategoria;
		}

		public void setCmbCategoria(JComboBox<Item> cmbCategoria) {
			this.cmbCategoria = cmbCategoria;
			contentPanel.add(this.cmbCategoria, "cell 3 3,growx");
			
		}

		public JTextField getTxtProducto() {
			return txtProducto;
		}
		
		public JButton getOkButton() {
			return okButton;
		}

		public void setOkButton(JButton okButton) {
			this.okButton = okButton;
		}

		public void setTxtProducto(JTextField txtProducto) {
			this.txtProducto = txtProducto;
		}

	}

	
	public static class VFormCategoria extends JDialog {
		private static final long serialVersionUID = 7071389459783724540L;
		private final JPanel contentPanel = new JPanel();
		private JTextField txtCategoria;
		private JButton okButton;
		public VFormCategoria() {
			setBounds(100, 100, 450, 140);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new MigLayout("", "[][][][grow]", "[][][][]"));

			JLabel lblProducto = new JLabel("Categor�a");
			contentPanel.add(lblProducto, "cell 1 1");
				
			txtCategoria = new JTextField();
			txtCategoria.setToolTipText("Nueva Categor�a");
			contentPanel.add(txtCategoria, "cell 3 1,growx");			

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			okButton = new JButton("Guardar");
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

		public JTextField getTxtCategoria() {
			return txtCategoria;
		}

		public void setTxtCategoria(JTextField txtCategoria) {
			this.txtCategoria = txtCategoria;
		}
		
		public JButton getOkButton() {
			return okButton;
		}

		public void setOkButton(JButton okButton) {
			this.okButton = okButton;
		}

	}
}
