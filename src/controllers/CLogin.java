package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Usuarios;
import models.Usuarios.Usuario;
import views.VLogin;

public class CLogin implements ActionListener{

	private VLogin vista;
	private Usuarios modelo;
	private Usuario usuario;
	public CLogin(VLogin vista, Usuarios modelo){
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnIniciar().addActionListener(this);
	}
	
	public void iniciarVista(){
		this.vista.getFrame().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		usuario = this.modelo.authUsuario(this.vista.getTxtUsuario().getText(), this.vista.getTxtPassword().getText());
		if(usuario != null){
			this.vista.close();
			CMain cMain = new CMain();
			cMain.iniciar();
		}else{
			this.vista.getLblMensaje().setText("El usuario o contraseña no es correcto.");
		}
		this.vista.getLblMensaje().setVisible(true);
	}
}
