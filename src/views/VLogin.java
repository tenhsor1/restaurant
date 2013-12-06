package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class VLogin {

	private JFrame frame; // Ventana contenedora
	private JTextField txtUsuario;
	private JButton btnIniciar,btnMinimizar,btnCerrar;
	private JLabel lblEncabezado, lblMensaje,lblIzquierda,lblDerecha,lblEspacio, lblFondo;
	private JPasswordField txtPassword;
	int titleColor = new Color(236, 240, 241).getRGB();
	Border border;
	

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
		//<Update> Hugo 28/11/2013
		//Icono usuario
		Image getUsericn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/user.png"));
		Image sclUsericn = getUsericn.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnUsuario	= new ImageIcon(sclUsericn);//icono usuario
		//Icono contraseña
		Image getPassicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/key.png"));
		Image sclPassicn = getPassicn.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnPass	= new ImageIcon(sclPassicn);//icono contraseña
		//Icono LogIn
		Image getLoginicn = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/LogIn.png"));
		Image sclLoginicn = getLoginicn.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon icnLogin	= new ImageIcon(sclLoginicn);//icono Login
		//Icono LogIn
		Image getLogo = Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/LogoCM.png"));
		Image setLogo= getLogo.getScaledInstance(180, 130,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon Logo	= new ImageIcon(setLogo);//icono Login
		//<EndUpdate> Hugo 28/11/2013
		
		//inicializamos la ventana, gris, en el centro, con layout Mig
		frame = new JFrame("Chez Michel - Iniciar Sesión");
		//frame.getRootPane().setWindowDecorationStyle(2);
		frame.setUndecorated(true);
		frame.setFont(new Font("Lato",Font.PLAIN,11));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VMain.class.getResource("/assets/UserLogin.png")));
		frame.getContentPane().setBackground(new Color(236, 240, 241));
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow][][][][][][grow]", "[][][][][][][][][grow][][][]"));
		//<Update> Hugo 27/11/2013
		frame.setResizable(false);
		//<EndUpdate> Hugo 27/11/2013
		
		btnMinimizar = new JButton("  _");
		btnMinimizar.requestFocus(false);
		btnMinimizar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMinimizar.setFont(new Font("lato", Font.BOLD, 13));
		btnMinimizar.setForeground(Color.DARK_GRAY);
		btnMinimizar.setOpaque(false);
		btnMinimizar.setContentAreaFilled(false);
		btnMinimizar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnMinimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(btnMinimizar, "cell 7 0, aligny top, alignx right");
		
		btnCerrar = new JButton("  X");
		btnCerrar.requestFocus(false);
		btnCerrar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCerrar.setFont(new Font("lato", Font.BOLD, 13));
		btnCerrar.setForeground(Color.DARK_GRAY);
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(btnCerrar, "cell 7 0, aligny top, alignx right");
		
		
		
		lblIzquierda = new JLabel("____");
		lblIzquierda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIzquierda.setFont(new Font("lato", Font.BOLD, 13));
		lblIzquierda.setForeground(new Color(236, 240, 241,0));
		frame.getContentPane().add(lblIzquierda, "cell 0 1, growx, east");
		
		lblDerecha = new JLabel("____");
		lblDerecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblDerecha.setFont(new Font("lato", Font.BOLD, 13));
		lblDerecha.setForeground(new Color(236, 240, 241,0));
		frame.getContentPane().add(lblDerecha, "cell 0 1, growx, dock west");
		
		
		//<Update> Hugo 27/11/2013
		lblEspacio = new JLabel("Espacio",JLabel.CENTER);
		lblEspacio.setFont(new Font("Lato", Font.PLAIN, 20));
		lblEspacio.setForeground(new Color(236, 240, 241,0));
		frame.getContentPane().add(lblEspacio, "cell 0 0 8, alignx center, growx, growy 40");
		
		lblEncabezado = new JLabel("",JLabel.CENTER);
		lblEncabezado.setFont(new Font("Pacifico", Font.PLAIN, 30));
		lblEncabezado.setForeground(new Color(52, 73, 94));
		lblEncabezado.setIcon(Logo);
		frame.getContentPane().add(lblEncabezado, "cell 0 1 8, alignx center, growx, growy 40");
		
		/*lblEspacio = new JLabel("Espacio",JLabel.CENTER);
		lblEspacio.setFont(new Font("Lato", Font.PLAIN, 20));
		lblEspacio.setForeground(new Color(236, 240, 241,0));
		frame.getContentPane().add(lblEspacio, "cell 0 2 8, alignx center, growx, growy 40");
		//<EndUpdate> Hugo 27/11/2013*/
		
		JLabel lblUsuario = new JLabel("");//User
		//<Update> Hugo 27/11/2013
		lblUsuario.setIcon(icnUsuario);
		lblUsuario.setBorder(border = BorderFactory.createLineBorder(Color.gray, 1));
		//<EndUpdate> Hugo 27/11/2013
		frame.getContentPane().add(lblUsuario, "cell 0 3");
		
		txtUsuario = new JTextField();
		txtUsuario.setText("Usuario");
		txtUsuario.requestFocus(true);
		txtUsuario.setFont(new Font("lato",Font.ITALIC,12));
		txtUsuario.selectAll();
		txtUsuario.setToolTipText("Ingrese su Nombre de Usuario");
		frame.getContentPane().add(txtUsuario, "cell 1 3 7, aligny 30, growx, growy");
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("");//Contrase\u00F1a
		//<Update> Hugo 27/11/2013
		lblPassword.setIcon(icnPass);
		lblPassword.setBorder(border = BorderFactory.createLineBorder(Color.gray, 1));
		//<EndUpdate> Hugo 27/11/2013
		frame.getContentPane().add(lblPassword, "cell 0 4,aligny 30");
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Ingrese su Password");
		txtPassword.setText("Password");
		frame.getContentPane().add(txtPassword, "cell 1 4 7 1, aligny 30,growx, growy");
		
		lblEspacio = new JLabel("Espacio",JLabel.CENTER);
		lblEspacio.setFont(new Font("Lato", Font.ITALIC, 10));
		lblEspacio.setForeground(new Color(236, 240, 241,0));
		frame.getContentPane().add(lblEspacio, "cell 0 5 8, alignx center, growx, growy 40");
		
		btnIniciar = new JButton("Iniciar Sesi\u00F3n");
		btnIniciar.setHorizontalAlignment(SwingConstants.CENTER);
		//<Update> Hugo 27/11/2013
		btnIniciar.setFont(new Font("lato", Font.PLAIN, 13));
		//btnIniciar.setBackground(new Color(46, 204, 113));
		btnIniciar.setBackground(new Color(46, 204, 113));
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setIcon(icnLogin);
		//<EndUpdate> Hugo 27/11/2013
		frame.getContentPane().add(btnIniciar, "cell 0 7 8, aligny top, alignx center, growx, growy 40");
		
		lblMensaje = new JLabel("", icnAlert, JLabel.CENTER);
		//<Update> Hugo 27/11/2013
		lblMensaje.setFont(new Font("lato", Font.BOLD, 10));
		//<EndUpdate> Hugo 27/11/2013
		lblMensaje.setVisible(false);
		frame.getContentPane().add(lblMensaje, "cell 0 8, dock south");


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

	public JButton getBtnMinimizar() {
		return btnMinimizar;
	}

	public void setBtnMinimizar(JButton btnMinimizar) {
		this.btnMinimizar = btnMinimizar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JLabel getLblIzquierda() {
		return lblIzquierda;
	}

	public void setLblIzquierda(JLabel lblIzquierda) {
		this.lblIzquierda = lblIzquierda;
	}

	public JLabel getLblDerecha() {
		return lblDerecha;
	}

	public void setLblDerecha(JLabel lblDerecha) {
		this.lblDerecha = lblDerecha;
	}
	
}
