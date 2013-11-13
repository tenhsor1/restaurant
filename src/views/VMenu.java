package views;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class VMenu extends JPanel {
	public JButton getBtnMProductos() {
		return btnMProductos;
	}

	public void setBtnMProductos(JButton btnMProductos) {
		this.btnMProductos = btnMProductos;
	}

	public JButton getBtnMPlatillos() {
		return btnMPlatillos;
	}

	public void setBtnMPlatillos(JButton btnMPlatillos) {
		this.btnMPlatillos = btnMPlatillos;
	}

	private JButton btnMProductos;
	private JButton btnMPlatillos;
	private static final long serialVersionUID = 9014536977897804075L;

	/**
	 * Create the panel.
	 */
	public VMenu() {
		setLayout(new MigLayout("", "[grow,fill]", "[][][][][]"));
		
		btnMProductos = new JButton("Productos");
		add(btnMProductos, "cell 0 0");
		
		btnMPlatillos = new JButton("Platillos");
		add(btnMPlatillos, "cell 0 4");

	}

}
