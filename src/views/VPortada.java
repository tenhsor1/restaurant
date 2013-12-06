package views;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
//...
 
public class VPortada extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public VPortada() {
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setAlignmentX(CENTER_ALIGNMENT);
		lblImagen.setAlignmentY(CENTER_ALIGNMENT);
		lblImagen.setIcon(new ImageIcon(VPortada.class.getResource("/assets/ChezMichel.jpg")));
		add(lblImagen);
	}
 

 
    //...
}