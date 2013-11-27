package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import conn.JDBC;

public class Empleados {

	private static ResultSet query;
	private JDBC conn;
	
	public Empleados(JDBC conn){
		this.conn = conn;
	}
	
	public ArrayList<Empleado> getAllEmpleados(){
		query = conn.query("SELECT idempleado FROM empleados");
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			while(query.next()){
				empleados.add(new Empleado(conn, query.getInt("idempleado")));
			}
			return empleados;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteEmpleado(Empleado empleado){
		String sql = "DELETE FROM empleados WHERE idempleado = " + empleado.getIdempleado();
		return this.conn.queryUpdate(sql);
	}
	
	public static class Empleado{
		private JDBC conn;
		private ResultSet idp, query;
		private int idempleado, results;
		private String nombre, appat, apmat, tel, direccion, puesto, horain, horaout;
		
		public Empleado(JDBC conn, int idempleado){
			this.conn = conn;
			query = this.conn.query("SELECT idempleado, nombre, appat, apmat, "
								+ "tel, direccion, puesto, horain, horaout FROM empleados WHERE idempleado = " + idempleado); 
			try {
				if(query.next()){
					this.idempleado = idempleado;
				 	nombre = query.getString("nombre");
				 	appat = query.getString("appat");
				 	apmat = query.getString("apmat");
				 	tel = query.getString("tel");
				 	direccion = query.getString("direccion");
				 	puesto = query.getString("puesto");
				 	horain = query.getString("horain");
				 	horaout = query.getString("horaout");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		public Empleado(JDBC conn, HashMap<String, String>  datos){
			this.conn = conn;
			String sql = "INSERT INTO empleados (nombre, appat, apmat, tel, direccion, puesto, horain, horaout) "
					+ "VALUES('" + datos.get("nombre") + "', '" + datos.get("appat") + "', '" + datos.get("apmat")
					+ "', '" + datos.get("tel") + "', '" + datos.get("direccion") + "', '" + datos.get("puesto") + "', '" 
					+ datos.get("horain") + "', '" + datos.get("horaout") +"')";
			results = this.conn.queryUpdate(sql);
			if(results > 0){
				this.nombre = datos.get("nombre");
				this.appat = datos.get("appat");
				this.apmat = datos.get("apmat");
				this.tel = datos.get("tel");
				this.direccion = datos.get("direccion");
				this.puesto = datos.get("puesto");
				this.horain = datos.get("horain");
				this.horaout = datos.get("horaout");
				idp = this.conn.query("SELECT MAX(idempleado) AS idempleado FROM empleados");
				try {
					if(idp.next())
						idempleado = idp.getInt("idempleado");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			results = conn.queryUpdate("UPDATE empleados SET nombre = '" + 
					nombre + "' WHERE idempleado = " + idempleado);
			if(results > 0){
				this.nombre = nombre;
			}
		}
		public String getAppat() {
			return appat;
		}
		public void setAppat(String appat) {
			results = conn.queryUpdate("UPDATE empleados SET appat = '" + 
					appat + "' WHERE idempleado = " + idempleado);
			if(results > 0){
				this.appat = appat;
			}
		}
		public String getApmat() {
			return apmat;
		}
		public void setApmat(String apmat) {
			results = conn.queryUpdate("UPDATE empleados SET apmat = '" + 
					apmat + "' WHERE idempleado = " + idempleado);
			if(results > 0){
				this.apmat = apmat;
			}
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			results = conn.queryUpdate("UPDATE empleados SET tel = '" + 
					tel + "' WHERE idempleado = " + idempleado);
			if(results > 0){
				this.tel = tel;
			}
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			results = conn.queryUpdate("UPDATE empleados SET direccion = '" + 
					direccion + "' WHERE idempleado = " + idempleado);
			if(results > 0){
				this.direccion = direccion;
			}
		}
		public String getPuesto() {
			return puesto;
		}
		public void setPuesto(String puesto) {
			results = conn.queryUpdate("UPDATE empleados SET puesto = '" + 
					puesto + "' WHERE idempleado = " + idempleado);
			if(results > 0){
				this.puesto = puesto;
			}
		}
		public String getHorain() {
			return horain;
		}
		public void setHorain(String horain) {
			results = conn.queryUpdate("UPDATE empleados SET horain = '" + 
					horain + "' WHERE idempleado = " + idempleado);
			if(results > 0){
				this.horain = horain;
			}
		}
		public String getHoraout() {
			return horaout;
		}
		public void setHoraout(String horaout) {
			results = conn.queryUpdate("UPDATE empleados SET horaout = '" + 
					horaout + "' WHERE idempleado = " + idempleado);
			if(results > 0){
				this.horaout = horaout;
			}
		}
		public int getIdempleado() {
			return idempleado;
		}
	}
}
