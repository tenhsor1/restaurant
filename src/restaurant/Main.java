package restaurant;

import java.sql.SQLException;

import views.VLogin;
import models.Usuarios;
import conn.JDBC;
import controllers.CLogin;

public class Main {
	private static JDBC conn;
	private static Usuarios usuarios;
	private static VLogin vLogin;
	private static CLogin cLogin;
	
	public static void main(String[] args) {
		try {
			conn = new JDBC("127.0.0.1", "restaurant", "root", "abc123");
			usuarios = new Usuarios(conn);
			vLogin = new VLogin();
			cLogin = new CLogin(vLogin, usuarios);
			cLogin.iniciarVista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
