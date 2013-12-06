package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import conn.JDBC;

public class Usuarios {
	static ResultSet result, query;
	private JDBC conn;
	
	public Usuarios(JDBC conn){
			this.conn = conn;
	}
	public ArrayList<Usuario> getAllUsuarios(){
		query = conn.query("SELECT idusuario FROM usuarios WHERE idstatus = 1");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			while(query.next()){
				usuarios.add(new Usuario(conn, query.getInt("idusuario")));
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Usuario authUsuario(String username, String password){
		result = conn.query("SELECT idusuario FROM usuarios WHERE username = '" + username + "' AND password = '" + password
							+ "' AND idstatus = 1");
		try {
			if(result.next()){
				int idusuario = result.getInt("idusuario");
				return new Usuario(conn, idusuario);
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteUsuario(Usuario usuario){
		String sql = "UPDATE usuarios SET idstatus = 0 WHERE idusuario = " + usuario.getIdusuario();
		return this.conn.queryUpdate(sql);
	}
	
	public static class Usuario{


		private JDBC conn;
		private int numResults, results;
		private ResultSet query, idu;
		private String username, password, nombre, appat, apmat;
		private int idusuario, idstatus;
		private boolean error;
		public Usuario(JDBC conn, int idusuariop){
			this.conn = conn;
			query = conn.query("SELECT idusuario, username, password,nombre, appat, apmat, idstatus FROM usuarios WHERE idusuario = " + idusuariop);
			try {
				if(query.next()){ 	
				 	idusuario = query.getInt("idusuario");
					 username = query.getString("username");
					 password = query.getString("password");
					 nombre = query.getString("nombre");
					 appat = query.getString("appat");
					 apmat = query.getString("apmat");
					 idstatus = query.getInt("idstatus");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Usuario(JDBC conn, String username, String password, String nombre, String appat, String apmat){
			this.conn = conn;
			if(!existeUsuario(username)){
				String sql = "INSERT INTO usuarios (username, password, nombre, appat, apmat, idstatus) VALUES('" +
						username + "', '" + password + "', '" + nombre + "', '" + appat + "', '" + apmat + "', 1)";
				numResults = conn.queryUpdate(sql);
				if(numResults > 0){
					idu = conn.query("SELECT MAX(idusuario) AS idusuario FROM usuarios");
					try {
						idu.next();
						idusuario = idu.getInt("idusuario");
						this.username = username; 
						this.password = password; 
						this.nombre = nombre; 
						this.appat = appat; 
						this.apmat = apmat; 
						this.idstatus = 1;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}else{
				this.error = true;
			}
		}
	
	
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			if(!existeUsuario(username)){
				this.error = true;
			}else{
				results = conn.queryUpdate("UPDATE usuarios SET username = '" + 
						username + "' WHERE idusuario = " + idusuario);
				if(results > 0){
					this.username = username;
				}
			}
		}
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			results = conn.queryUpdate("UPDATE usuarios SET nombre = '" + 
					nombre + "' WHERE idusuario = " + idusuario);
			if(results > 0){
				this.nombre = nombre;
			}
		}

		public String getAppat() {
			return appat;
		}

		public void setAppat(String appat) {
			results = conn.queryUpdate("UPDATE usuarios SET appat = '" + 
					appat + "' WHERE idusuario = " + idusuario);
			if(results > 0){
				this.appat = appat;
			}
		}

		public String getApmat() {
			return apmat;
		}

		public void setApmat(String apmat) {
			results = conn.queryUpdate("UPDATE usuarios SET apmat = '" + 
					apmat + "' WHERE idusuario = " + idusuario);
			if(results > 0){
				this.apmat = apmat;
			}
		}


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			results = conn.queryUpdate("UPDATE usuarios SET password = '" + 
					password + "' WHERE idusuario = " + idusuario);
			if(results > 0){
				this.password = password;
			}
		}
		
		public int getIdusuario() {
			return idusuario;
		}


		public int getIdstatus() {
			return idstatus;
		}
		
		public boolean isError() {
			return error;
		}
		
		public void setPermisos(HashMap<Integer, Boolean> permisos){
			this.conn.queryUpdate("DELETE FROM permisos WHERE idusuario = " + idusuario);
			String sql = "";
			for (Integer key : permisos.keySet()) {
				if(permisos.get(key)){
					sql = "INSERT INTO permisos (idusuario, iditem) VALUES(" + idusuario + ", " + key + ")";
					conn.queryUpdate(sql);
				}
			}
		}
		
		public HashMap<Integer, Boolean> getPermisos(){
			String sql = "SELECT iditem FROM permisos WHERE idusuario = " + idusuario;
			HashMap<Integer, Boolean> permisos = new HashMap<Integer, Boolean>();
			result = conn.query(sql);
			try {
				while(result.next()){
					permisos.put(result.getInt("iditem"), true);
				}
				return permisos;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		private boolean existeUsuario(String username){
			result = this.conn.query("SELECT COUNT(*) AS usrcount FROM usuarios WHERE username = '" + username +"'");
			int band = 0;
			try {
				if(result.next()){
					band = result.getInt("usrcount");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return band != 0;
		}
		
	}
	
	
}
