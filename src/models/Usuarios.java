package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import conn.JDBC;

public class Usuarios {
	static ResultSet result;
	private JDBC conn;
	
	public Usuarios(JDBC conn){
			this.conn = conn;
	}
	public ResultSet getAllUsuarios(){
		return conn.query("SELECT * FROM usuarios");
	}
	
	public Usuario authUsuario(String username, String password){
		result = conn.query("SELECT idusuario FROM usuarios WHERE username = '" + username + "' AND password = '" + password
							+ "' AND idstatus = 1");
		try {
			if(result.next()){
				int idusuario = result.getInt("idusuario");
				return new Usuario(idusuario);
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public class Usuario{

		private int numResults;
		private ResultSet query, idu;
		private String username, password, nombre, appat, apmat, direccion, tel;
		private int idusuario, idstatus;
		public Usuario(int idusuariop) throws SQLException{
			query = conn.query("SELECT idusuario, username, password,nombre, appat, apmat, direccion, tel, idstatus FROM usuarios WHERE idusuario = " + idusuariop);
			if(query.next()){ 	
			 	idusuario = query.getInt("idusuario");
				 username = query.getString("username");
				 password = query.getString("password");
				 nombre = query.getString("nombre");
				 appat = query.getString("appat");
				 apmat = query.getString("apmat");
				 direccion = query.getString("direccion");
				 tel = query.getString("tel");
				 idstatus = query.getInt("idstatus");
			}
		}
		
		public Usuario(String username, String password, String nombre, String appat, String apmat, String direccion, String tel, int idstatus){
			String sql = "INSERT INTO usuarios (username, password,nombre, appat, apmat, direccion, tel, idstatus) VALUES(" +
					username + ", " + password + ", " + nombre + ", " + appat + ", " + apmat + ", " + direccion +
					 ", " + tel + ", " + idstatus + ")";
			numResults = conn.queryUpdate(sql);
			if(numResults > 0){
				idu = conn.query("SELECT MAX(idusuario) FROM usuarios");
				try {
					idusuario = idu.getInt(0);
					this.username = username; 
					this.password = password; 
					this.nombre = nombre; 
					this.appat = appat; 
					this.apmat = apmat; 
					this.direccion = direccion; 
					this.tel = tel;
					this.idstatus = idstatus;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getAppat() {
			return appat;
		}

		public void setAppat(String appat) {
			this.appat = appat;
		}

		public String getApmat() {
			return apmat;
		}

		public void setApmat(String apmat) {
			this.apmat = apmat;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = tel;
		}
		
		public int getIdusuario() {
			return idusuario;
		}

		public void setIdusuario(int idusuario) {
			this.idusuario = idusuario;
		}

		public int getIdstatus() {
			return idstatus;
		}

		public void setIdstatus(int idstatus) {
			this.idstatus = idstatus;
		}
		
	}
	
	
}
