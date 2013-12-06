package controllers;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import models.Usuarios;
import models.Usuarios.Usuario;
import views.VLogin;

public class CLogin implements ActionListener,FocusListener, KeyListener{

	private VLogin vista;
	private Usuarios modelo;
	private Usuario usuario;
	private JButton btnCerrar, btnIniciar, btnMinimizar;
	public CLogin(VLogin vista, Usuarios modelo){
		this.iniciarFuentes();
		this.vista = vista;
		this.modelo = modelo;
		btnIniciar = this.vista.getBtnIniciar();
		this.vista.getTxtUsuario().addFocusListener(this);
		this.vista.getTxtPassword().addFocusListener(this);
		this.vista.getBtnIniciar().addKeyListener(this);
		this.vista.getTxtUsuario().addKeyListener(this);
		this.vista.getTxtPassword().addKeyListener(this);
		btnCerrar = this.vista.getBtnCerrar();
		btnMinimizar = this.vista.getBtnMinimizar();
		
	}
	
	public void iniciarVista(){
		this.vista.getFrame().setVisible(true);	
		btnCerrar.addActionListener(this);
		btnIniciar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnIniciar)){
			usuario = this.modelo.authUsuario(this.vista.getTxtUsuario().getText(), this.vista.getTxtPassword().getText());
			if(usuario != null){
				this.vista.close();
				CMain cMain = new CMain(usuario);
				cMain.iniciar();
			}else{
				this.vista.getLblMensaje().setText("  Nombre de usuario y/o ontrase\u00F1a incorrectos");
			}
			this.vista.getLblMensaje().setVisible(true);
		}else if(e.getSource().equals(btnCerrar)){
			this.vista.close();
		}else if(e.getSource().equals(btnMinimizar)){
			this.vista.getFrame().setExtendedState(JFrame.ICONIFIED);
		}
	}
	
	public void iniciarFuentes(){
	try {
		   GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new  File("src/assets.Fonts/lato-light-webfont.ttf")));
		} catch (IOException|FontFormatException e) {
		 //Handle exception
		}
	try {
		   GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 ge2.registerFont(Font.createFont(Font.TRUETYPE_FONT, new  File("src/assets.Fonts/Cursiva.ttf")));
		} catch (IOException|FontFormatException e) {
		 //Handle exception
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
			vista.getTxtUsuario().selectAll();
			vista.getTxtPassword().selectAll();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
		usuario = this.modelo.authUsuario(this.vista.getTxtUsuario().getText(), this.vista.getTxtPassword().getText());
		if(usuario != null){
			this.vista.close();
			CMain cMain = new CMain(usuario);
			cMain.iniciar();
		}else{
			this.vista.getLblMensaje().setText("  Nombre de usuario y/o ontrase\u00F1a incorrectos");
		}
		this.vista.getLblMensaje().setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
