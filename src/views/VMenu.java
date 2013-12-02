package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import vectors.RoundedBorder;

public class VMenu extends JPanel {
	public JButton getBtnMVentas() {
		return btnMVentas;
	}

	public JButton getBtnMCompras() {
		return btnMCompras;
	}

	public JButton getBtnMEmpleados() {
		return btnMEmpleados;
	}


	public JButton getBtnMProductos() {
		return btnMProductos;
	}

	public JButton getBtnMPlatillos() {
		return btnMPlatillos;
	}

	private JButton btnMPlatillos,  btnMEmpleados, btnMCompras, btnMProductos, btnMVentas;
	private static final long serialVersionUID = 9014536977897804075L;

	/**
	 * Create the panel.
	 */
	public VMenu() {
		setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		setLayout(new MigLayout("", "[grow,fill]", "[][][][][][][][][][][][][][][][][][][][][]"));
		
		btnMProductos = new JButton("Productos");
		btnMProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMProductos.setToolTipText("Inventario de Productos");
		btnMProductos.setForeground(Color.WHITE);
		btnMProductos.setBackground(new Color(0, 153, 102));
		btnMProductos.setFont(new Font("Lato", Font.PLAIN, 11));
		btnMProductos.setBorder(new RoundedBorder(5));
		add(btnMProductos, "cell 0 0");
		
		btnMPlatillos = new JButton("Platillos");
		btnMPlatillos.setToolTipText("Inventario de Platillos");
		btnMPlatillos.setForeground(Color.WHITE);
		btnMPlatillos.setBackground(new Color(0, 153, 102));
		btnMPlatillos.setFont(new Font("Lato", Font.PLAIN, 11));
		btnMPlatillos.setBorder(new RoundedBorder(5));
		add(btnMPlatillos, "cell 0 5");
		
		btnMEmpleados = new JButton("Empleados");
		btnMEmpleados.setToolTipText("Inventario de Empleados");
		btnMEmpleados.setForeground(Color.WHITE);
		btnMEmpleados.setBackground(new Color(0, 153, 102));
		btnMEmpleados.setFont(new Font("Lato", Font.PLAIN, 11));
		btnMEmpleados.setBorder(new RoundedBorder(5));
		add(btnMEmpleados, "cell 0 10");
		
		btnMCompras = new JButton("Compras");
		btnMCompras.setToolTipText("Inventario de Compras");
		btnMCompras.setForeground(Color.WHITE);
		btnMCompras.setBackground(new Color(0, 153, 102));
		btnMCompras.setFont(new Font("Lato", Font.PLAIN, 11));
		btnMCompras.setBorder(new RoundedBorder(5));
		add(btnMCompras, "cell 0 14");
		
		btnMVentas = new JButton("Ventas");
		btnMVentas.setToolTipText("Lista de Ventas");
		btnMVentas.setForeground(Color.WHITE);
		btnMVentas.setBackground(new Color(0, 153, 102));
		btnMVentas.setFont(new Font("Lato", Font.PLAIN, 11));
		btnMVentas.setBorder(new RoundedBorder(5));
		add(btnMVentas, "cell 0 19");
	}

}
