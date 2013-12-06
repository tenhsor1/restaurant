package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.JDBC;

public class Compras {

	private static ResultSet query;
	private JDBC conn;
	
	public Compras(JDBC conn){
		this.conn = conn;
	}
	
	public ArrayList<Compra> getAllCompras(){
		query = conn.query("SELECT idcompra FROM compras");
		ArrayList<Compra> compras = new ArrayList<Compra>();
		
		try {
			while(query.next()){
				compras.add(new Compra(conn, query.getInt("idcompra")));
			}
			return compras;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteCompra(Compra compra){
		String sql = "DELETE FROM compras WHERE idcompra = " + compra.getIdcompra();
		return this.conn.queryUpdate(sql);
	}
	
	
	public static class Compra{

		private JDBC conn;
		private ResultSet idp, query;
		private int idcompra, results, idproducto, idunidad;
		private float cantidad;
		private String producto, unidad;
		private Date fechacompra, fechacad;
		
		public Compra(JDBC conn, int idcompra){
			this.conn = conn;
			query = this.conn.query("SELECT idcompra, compras.idproducto, compras.idunidad, cantidad, producto, unidad, fechacompra, fechacad "
								+ "FROM compras INNER JOIN productos ON  compras.idproducto = productos.idproducto "
								+ "INNER JOIN unidades ON compras.idunidad = unidades.idunidad WHERE idcompra = " + idcompra); 
			try {
				if(query.next()){
					this.idcompra = idcompra;
				 	idproducto = query.getInt("idproducto");
				 	idunidad = query.getInt("idunidad");
					producto = query.getString("producto");
				 	unidad = query.getString("unidad");
				 	cantidad = query.getFloat("cantidad");
				 	fechacompra = query.getDate("fechacompra");
				 	fechacad = query.getDate("fechacad");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public Compra(JDBC conn, int idproducto, int idunidad, float cantidad, java.util.Date fechacad){
			this.conn = conn;
			Date fc = new Date(fechacad.getTime());
			String sql = "INSERT INTO compras (idproducto, idunidad, cantidad, fechacompra, fechacad) "
					+ "VALUES(" + idproducto + ", " + idunidad + ", " + cantidad
					+ ", {fn NOW()}, '" + fc + "')";
			results = this.conn.queryUpdate(sql);
			if(results > 0){
				this.idproducto = idproducto;
				this.idunidad = idunidad;
				this.cantidad = cantidad;
				this.fechacad = fc;
				idp = this.conn.query("SELECT idcompra, fechacompra, producto, unidad FROM compras "
						+ "INNER JOIN productos ON compras.idproducto = productos.idproducto "
						+ "INNER JOIN unidades ON compras.idunidad = unidades.idunidad "
						+"WHERE idcompra = (SELECT MAX(idcompra) FROM compras);");
				try {
					if(idp.next())
						idcompra = idp.getInt("idcompra");
						fechacompra = idp.getDate("fechacompra");
						producto = idp.getString("producto");
						unidad = idp.getString("unidad");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public int getIdcompra() {
			return idcompra;
		}

		public int getIdproducto() {
			return idproducto;
		}

		public void setIdproducto(int idproducto) {
			results = conn.queryUpdate("UPDATE compras SET idproducto = " + 
					idproducto + " WHERE idcompra = " + idcompra);
			if(results > 0){
				this.idproducto = idproducto;
			}
		}

		public int getIdunidad() {
			return idunidad;
		}

		public void setIdunidad(int idunidad) {
			results = conn.queryUpdate("UPDATE compras SET idunidad = " + 
					idunidad + " WHERE idcompra = " + idcompra);
			if(results > 0){
				this.idunidad = idunidad;
			}
		}

		public float getCantidad() {
			return cantidad;
		}

		public void setCantidad(float cantidad) {
			results = conn.queryUpdate("UPDATE compras SET cantidad = " + 
					cantidad + " WHERE idcompra = " + idcompra);
			if(results > 0){
				this.cantidad = cantidad;
			}
		}

		public String getProducto() {
			return producto;
		}

		public String getUnidad() {
			return unidad;
		}

		public Date getFechacompra() {
			return fechacompra;
		}


		public Date getFechacad() {
			return fechacad;
		}

		public int getIndexUnidad(){
			query = this.conn.query("SELECT idunidad FROM unidades");
			try {
				int index = 0;
				while(query.next()){
					if(idunidad == query.getInt("idunidad")){
						break;
					}
					index++;
				}
				return index;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		public int getIndexProducto(){
			query = this.conn.query("SELECT idproducto FROM productos");
			try {
				int index = 0;
				while(query.next()){
					if(idproducto == query.getInt("idproducto")){
						break;
					}
					index++;
				}
				return index;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		public void setFechacad(java.util.Date fechacad) {
			Date fc = new Date(fechacad.getTime());
			results = conn.queryUpdate("UPDATE compras SET fechacad = '" + 
					fc + "' WHERE idcompra = " + idcompra);
			if(results > 0){
				this.fechacad = fc;
			}
		}
	}
}
