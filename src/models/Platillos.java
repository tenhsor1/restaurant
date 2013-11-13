package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Productos.Producto;
import conn.JDBC;

public class Platillos {

	private static ResultSet result;
	private JDBC conn;
	
	public Platillos(JDBC conn){
		this.conn = conn;
	}
	
	public ArrayList<Platillo> getAllPlatillos(){
		ResultSet query;
		query = conn.query("SELECT idplatillo FROM platillos");
		ArrayList<Platillo> platillos = new ArrayList<Platillo>();
		
		try {
			while(query.next()){
				platillos.add(new Platillo(conn, query.getInt("idplatillo")));
			}
			return platillos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static class Platillo{
		
		private JDBC conn;
		private int idplatillo;
		private String platillo;
		private ArrayList<ProdPlatillo> productos_platillo;
		private ResultSet query;
		
		public Platillo(JDBC conn, int idplatillo){
			this.conn = conn;
			query = this.conn.query("SELECT idplatillo, platillo FROM platillos WHERE idplatillo = " + idplatillo); 
			try {
				if(query.next()){
					this.idplatillo = idplatillo;
				 	platillo = query.getString("platillo");
				 	this.productos_platillo = getProdPlatillosDB();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		private ArrayList<ProdPlatillo> getProdPlatillosDB(){
			ArrayList<ProdPlatillo> productos = new ArrayList<ProdPlatillo>();
			query = this.conn.query("SELECT idproducto, idunidad, cantidad FROM producto_platillo WHERE idplatillo = " + this.idplatillo); 
			try {
				while(query.next()){
					productos.add(new ProdPlatillo(query.getInt("idproducto"), query.getInt("idunidad"), query.getFloat("cantidad"))); 
				}
				return productos;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public int getIdplatillo() {
			return idplatillo;
		}
		public void setIdplatillo(int idplatillo) {
			this.idplatillo = idplatillo;
		}
		public String getPlatillo() {
			return platillo;
		}
		public void setPlatillo(String platillo) {
			this.platillo = platillo;
		}
		public ArrayList<ProdPlatillo> getProductos_platillo() {
			return productos_platillo;
		}
		public void setProductos_platillo(ArrayList<ProdPlatillo> productos_platillo) {
			this.productos_platillo = productos_platillo;
		}
	}
	
	
	public static class ProdPlatillo{
		public int idproducto, idunidad;
		public float cantidad;
		public ProdPlatillo(int idproducto, int idunidad, float cantidad){
			this.idproducto = idproducto;
			this.idunidad = idunidad;
			this.cantidad = cantidad;
		}
	}
	
	
	/*
	public static class ProdPlatillo{

		private int idplatillo, idproducto, idunidad, results, idproducto_platillo;
		private float cantidad;
		private String unidad;
		private JDBC conn;
		private ResultSet query;
	
		public ProdPlatillo(JDBC conn, int idproducto_platillo) throws SQLException{
			this.conn = conn;
			 query = this.conn.query("SELECT idplatillo, idproducto, unidades.idunidad, unidad, cantidad "
			 		+ "FROM producto_platillo LEFT JOIN unidades ON producto_platillo.idunidad = producto_platillo.idunidad" 
					 +" WHERE idproducto_platillo = "+ idproducto_platillo);
			 	if(query.next()){
			 		this.idproducto_platillo = idproducto_platillo;
			 		idproducto = query.getInt("idproducto");
				 	idplatillo = query.getInt("idplatillo");
				 	idunidad = query.getInt("idunidad");
				 	unidad = query.getString("unidad");
				 	cantidad = query.getFloat("cantidad");
			 	}
		}
		
		public ProdPlatillo(JDBC conn, int idplatillo, int idproducto, int idunidad, float cantidad){
			this.conn = conn;
		
			String sql = "INSERT INTO producto_platillo (idplatillo, idproducto, idunidad, cantidad) VALUES(" +
					idplatillo + ", " + idproducto + ", " + idunidad + ", " + cantidad + ")";
			results = this.conn.queryUpdate(sql);
			if(results > 0){
				this.idplatillo = idplatillo;
				this.idproducto = idproducto;
				this.idunidad = idunidad;
				this.cantidad = cantidad;
				
				query = this.conn.query("SELECT MAX(idproducto_platillo) AS idproducto_platillo FROM producto_platillo");
				try {
					if(query.next())
					idproducto_platillo = query.getInt("idproducto_platillo");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public int getIdplatillo() {
			return idplatillo;
		}

		public void setIdplatillo(int idplatillo) {
			this.idplatillo = idplatillo;
		}

		public int getIdproducto() {
			return idproducto;
		}

		public void setIdproducto(int idproducto) {
			this.idproducto = idproducto;
		}

		public int getIdunidad() {
			return idunidad;
		}

		public void setIdunidad(int idunidad) {
			this.idunidad = idunidad;
		}

		public int getIdproducto_platillo() {
			return idproducto_platillo;
		}

		public void setIdproducto_platillo(int idproducto_platillo) {
			this.idproducto_platillo = idproducto_platillo;
		}

		public float getCantidad() {
			return cantidad;
		}

		public void setCantidad(float cantidad) {
			this.cantidad = cantidad;
		}
		
		public String getUnidad() {
			return unidad;
		}

		public void setUnidad(String unidad) {
			this.unidad = unidad;
		}
	}
	*/
}
