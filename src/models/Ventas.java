package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.JDBC;

public class Ventas {
	private JDBC conn;
	private static ResultSet query;
	
	public Ventas(JDBC conn){
		this.conn = conn;
	}
	
	public ArrayList<Venta> getAllVentas(){
		query = conn.query("SELECT idventa FROM ventas");
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		
		try {
			while(query.next()){
				ventas.add(new Venta(conn, query.getInt("idventa")));
			}
			return ventas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<PVentas> getAllPlatillos(){
		query = conn.query("SELECT idplatillo, platillo, precio FROM platillos");
		ArrayList<PVentas> platillos = new ArrayList<PVentas>();
		
		try {
			int i=0;
			while(query.next()){
				platillos.add(new PVentas(query.getInt("idplatillo"), i, query.getString("platillo"), query.getFloat("precio")));
				i++;
			}
			
			return platillos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteVenta(Venta venta){
		String sql = "DELETE FROM ventas WHERE idventa = " + venta.getIdventa();
		return this.conn.queryUpdate(sql);
	}
	
	public static class Venta{

		private JDBC conn;
		private ResultSet idp, query;
		private int idventa, results, nummesa;
		private float subtotal, iva, total;
		private Date fecha;
		public Venta(JDBC conn, int idventa){
			this.conn = conn;
			query = this.conn.query("SELECT idventa, subtotal, iva, total, fecha, nummesa FROM ventas WHERE idventa = " + idventa);
			try {
				if(query.next()){
					this.idventa = idventa;
				 	subtotal = query.getFloat("subtotal");
				 	iva = query.getFloat("iva");
				 	total = query.getFloat("total");
				 	fecha = query.getDate("fecha");
					nummesa = query.getInt("nummesa");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public Venta(JDBC conn, float subtotal, float iva, float total, int nummesa, ArrayList<PVentas> platillos){
			this.conn = conn;
			String sql = "INSERT INTO ventas (subtotal, iva, total, nummesa, fecha) "
					+ "VALUES(" + subtotal + ", " + iva + ", " + total
					+ ", " + nummesa + ", {fn NOW()})";
			results = this.conn.queryUpdate(sql);
			if(results > 0){
				this.subtotal = subtotal;
				this.iva = iva;
				this.total = total;
				this.nummesa = nummesa;
				idp = this.conn.query("SELECT MAX(idventa) AS idventa FROM ventas");
				try {
					if(idp.next())
						idventa = idp.getInt("idventa");
					setPVentas(platillos);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public int getNummesa() {
			return nummesa;
		}
		public void setNummesa(int nummesa) {
			results = conn.queryUpdate("UPDATE ventas SET nummesa = " + 
					nummesa + " WHERE idventa = " + idventa);
			if(results > 0){
				this.nummesa = nummesa;
			}
		}
		public float getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(float subtotal) {
			results = conn.queryUpdate("UPDATE ventas SET subtotal = " + 
					subtotal + " WHERE idventa = " + idventa);
			if(results > 0){
				this.subtotal = subtotal;
			}
		}
		public float getIva() {
			return iva;
		}
		public void setIva(float iva) {
			results = conn.queryUpdate("UPDATE ventas SET iva = " + 
					iva + " WHERE idventa = " + idventa);
			if(results > 0){
				this.iva = iva;
			}
		}
		public float getTotal() {
			return total;
		}
		public void setTotal(float total) {
			results = conn.queryUpdate("UPDATE ventas SET total = " + 
						total + " WHERE idventa = " + idventa);
			if(results > 0){
				this.total = total;
			}
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public int getIdventa() {
			return idventa;
		}
		
		public void setPVentas(ArrayList<PVentas> v_platillos){
			String sql = "DELETE FROM venta_platillo WHERE idventa = " + idventa;
			this.conn.queryUpdate(sql);
			
			for(PVentas vp : v_platillos){
				sql = "INSERT INTO venta_platillo (idventa, idplatillo) VALUES (" + idventa + ", " + vp.idplatillo + ");";
				this.conn.queryUpdate(sql);
			}
		}
		public ArrayList<PVentas> getPVentas(){
			String sql = "SELECT venta_platillo.idplatillo, platillo, precio FROM venta_platillo "
					+ "INNER JOIN platillos ON venta_platillo.idplatillo = platillos.idplatillo "
					+ "WHERE idventa = " + idventa;
			query = conn.query(sql);
			ArrayList<PVentas> platillos = new ArrayList<PVentas>();
			try {
				int i=0;
				while(query.next()){
					platillos.add(new PVentas(query.getInt("idplatillo"), i, query.getString("platillo"), query.getFloat("precio")));
					i++;
				}
				
				return platillos;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public static class PVentas{
		public int idplatillo;
		public int cantidad;
		public String platillo;
		public float precio;
		public int index;
		
		public PVentas(int idplatillo, int index, String platillo, float precio){
			this.idplatillo = idplatillo;
			this.index = index;
			this.platillo = platillo;
			this.precio = precio;
		}
	}
	
}
