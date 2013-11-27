package views;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class VMenu extends JPanel {
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

	private JButton btnMProductos, btnMPlatillos,  btnMEmpleados, btnMCompras;
	private static final long serialVersionUID = 9014536977897804075L;

	/**
	 * Create the panel.
	 */
	public VMenu() {
		setLayout(new MigLayout("", "[grow,fill]", "[][][][][][][][][][][][][][][]"));
		
		btnMProductos = new JButton("Productos");
		add(btnMProductos, "cell 0 0");
		
		btnMPlatillos = new JButton("Platillos");
		add(btnMPlatillos, "cell 0 4");
		
		btnMEmpleados = new JButton("Empleados");
		add(btnMEmpleados, "cell 0 9");
		
		btnMCompras = new JButton("Compras");
		add(btnMCompras, "cell 0 13");
	}

}
