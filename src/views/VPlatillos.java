package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import vectors.ModelTable;

public class VPlatillos extends JPanel {

	private static final long serialVersionUID = -1958084112420948841L;
	private JButton btnNuevoPlatillo;
	private JTable tablePlatillos;
	private JScrollPane scrollPaneLista;
	private JPanel paneProducto;
	public VPlatillos() {
		setLayout(new MigLayout("", "[][][grow][grow]", "[][][][grow]"));
		
		btnNuevoPlatillo = new JButton("Nuevo Platillo");
		add(btnNuevoPlatillo, "cell 1 2");
		
		tablePlatillos = new JTable();
		scrollPaneLista = new JScrollPane(tablePlatillos);
		add(scrollPaneLista, "cell 1 3 1 1,grow");
		
		paneProducto = new JPanel();
		paneProducto.setLayout(new MigLayout("", "[][][grow][grow]", "[][][][grow]"));
		add(paneProducto, "cell 2 3 2 1,grow");
	}

	public JTable addTablePlatillos(ModelTable modelPlatillos){
		tablePlatillos.setModel(modelPlatillos);
		return tablePlatillos;
	}
}
