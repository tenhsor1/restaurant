package views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class VMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMain window = new VMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VMain() {
		initialize();
	}
	public void iniciarVista(){
		frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("Chez Michel - Panel de Control");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VMain.class.getResource("/assets/restaurant.png")));
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBackground(Color.GRAY);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow][][][][][][grow]", "[][][][][][][][][grow][][][grow]"));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "cell 1 11,grow");
	}

}
