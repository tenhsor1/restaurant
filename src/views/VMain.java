package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class VMain {

	private JFrame frame;
	private JSplitPane splitPane;
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
<<<<<<< HEAD
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VMain.class.getResource("/assets/Wine.png")));
=======
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VMain.class.getResource("/assets/restaurant.png")));
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		frame.setBackground(Color.DARK_GRAY);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(1100, 720));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBackground(Color.DARK_GRAY);
<<<<<<< HEAD
		splitPane.setDividerSize(0);
=======
		splitPane.setDividerSize(1);
>>>>>>> fccb445ea459b2d5e7edb3c07a741b7625a3df5c
		splitPane.setDividerLocation(100);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}
}
