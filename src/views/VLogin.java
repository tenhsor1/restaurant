package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class VLogin {

	private JFrame frame; // Ventana contenedora
	private JTextField txtUsuario;
	private JButton btnIniciar;
	private JLabel lblMensaje;
	private JPasswordField txtPassword;
	/**
	 * @wbp.nonvisual location=29,119
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin window = new VLogin();
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
	public VLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image bufImg = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/alert.png")); //obtenemos la imagen tamaño real
		Image newImg = bufImg.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); //generamos una nueva imagen pero escalda
		
		ImageIcon icnAlert = new ImageIcon(newImg); // generamos un icono para la etiqueta de mensaje lblMensaje
		
		//inicializamos la ventana, gris, en el centro, con layout Mig
		frame = new JFrame("Chez Michel - Iniciar Sesión");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VMain.class.getResource("/assets/user.png")));
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBackground(Color.GRAY);
		frame.setSize(450, 170);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow][][][][][][grow]", "[][][][][][][][][grow][][][]"));
		
		JLabel lblUsuario = new JLabel("Usuario");
		frame.getContentPane().add(lblUsuario, "cell 0 1");
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Ingresa tu Nombre de Usuario");
		frame.getContentPane().add(txtUsuario, "cell 1 1 7 1,growx");
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		frame.getContentPane().add(lblPassword, "cell 0 3");
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Ingrese su Password");
		frame.getContentPane().add(txtPassword, "cell 1 3 7 1,growx,aligny top");
		
		btnIniciar = new JButton("Iniciar Sesi\u00F3n");
		btnIniciar.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(btnIniciar, "cell 7 5,alignx right");
		
		lblMensaje = new JLabel("", icnAlert, JLabel.RIGHT);
		lblMensaje.setVisible(false);
		frame.getContentPane().add(lblMensaje, "cell 0 7 8 1");
	}
	public void close(){
		frame.setVisible(false);
		frame.dispose();
	}
	public JButton getBtnIniciar() {
		return btnIniciar;
	}

	public void setBtnIniciar(JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public void setLblMensaje(JLabel lblMensaje) {
		this.lblMensaje = lblMensaje;
	}
}
