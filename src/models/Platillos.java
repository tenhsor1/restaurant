package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.JDBC;

public class Platillos {

	private static ResultSet query;
	private JDBC conn;
	
	public Platillos(JDBC conn){
		this.conn = conn;
	}
	
	public ArrayList<Platillo> getAllPlatillos(){
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
	
	public ArrayList<Unidad> getAllUnidades(){
		ArrayList<Unidad> unidades = new ArrayList<Unidad>();
		query = this.conn.query("SELECT idunidad, unidad FROM unidades"); 
		try {
			while(query.next()){
				unidades.add(new Unidad(query.getInt("idunidad"), query.getString("unidad"))); 
			}
			return unidades;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deletePlatillo(Platillo platillo){
		String sql = "DELETE FROM platillos WHERE idplatillo = " + platillo.getIdplatillo();
		int band1 = this.conn.queryUpdate(sql);
		sql = "DELETE FROM producto_platillo WHERE idplatillo = " + platillo.getIdplatillo();
		int band2 = this.conn.queryUpdate(sql);
		return band1 + band2;
	}
	
	public static class Platillo{
		
		private JDBC conn;
		private int idplatillo;
		private String platillo;
		private float precio;
		private ArrayList<ProdPlatillo> productos_platillo;
		private ResultSet idp, query;
		private int results;
		public Platillo(JDBC conn, int idplatillo){
			this.conn = conn;
			query = this.conn.query("SELECT idplatillo, platillo, precio FROM platillos WHERE idplatillo = " + idplatillo); 
			try {
				if(query.next()){
					this.idplatillo = idplatillo;
				 	platillo = query.getString("platillo");
				 	precio = query.getFloat("precio");
				 	this.productos_platillo = getProdPlatillosDB();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public Platillo(JDBC conn, String platillo, float precio, ArrayList<ProdPlatillo> prod_platillos){
			this.conn = conn;
			String sql = "INSERT INTO platillos (platillo, precio) VALUES('" + platillo+ "', " + precio  +")";
			results = this.conn.queryUpdate(sql);
			if(results > 0){
				this.platillo = platillo;
				this.precio = precio;
				idp = this.conn.query("SELECT MAX(idplatillo) AS idplatillo FROM platillos");
				try {
					if(idp.next())
						idplatillo = idp.getInt("idplatillo");
					
					for(final ProdPlatillo pp : prod_platillos){
						if(pp.idproducto != 0){
							sql = "INSERT INTO producto_platillo (idplatillo, idproducto, cantidad, idunidad) "
								+ "VALUES(" + idplatillo + ", " + pp.idproducto + ", " 
								+ pp.cantidad + ", " + pp.idunidad   + ")";
							results = this.conn.queryUpdate(sql);
						}
					}
					this.productos_platillo = prod_platillos;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		private ArrayList<ProdPlatillo> getProdPlatillosDB(){
			ArrayList<ProdPlatillo> productos = new ArrayList<ProdPlatillo>();
			query = this.conn.query("SELECT idproducto_platillo, productos.idproducto, unidades.idunidad, cantidad, producto, unidad "
									+ "FROM producto_platillo LEFT JOIN productos ON producto_platillo.idproducto = productos.idproducto "
									+ "LEFT JOIN unidades ON producto_platillo.idunidad = unidades.idunidad " 	
									+ "WHERE idplatillo = " + this.idplatillo); 
			try {
				while(query.next()){
					productos.add(new ProdPlatillo(query.getInt("idproducto_platillo"), query.getInt("idproducto"), 
							query.getInt("idunidad"), query.getFloat("cantidad"), query.getString("producto"), query.getString("unidad"))); 
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

		public String getPlatillo() {
			return platillo;
		}
		public void setPlatillo(String platillo) {
			results = conn.queryUpdate("UPDATE platillos SET platillo = '" + 
					platillo + "' WHERE idplatillo = " + idplatillo);
						if(results > 0){
							this.platillo = platillo;
			}
		}
		
		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			results = conn.queryUpdate("UPDATE platillos SET precio = '" + 
					precio + "' WHERE idplatillo = " + idplatillo);
						if(results > 0){
							this.precio = precio;
			}
		}
		
		public ArrayList<ProdPlatillo> getProductos_platillo() {
			return productos_platillo;
		}
		public void setProductos_platillo(ArrayList<ProdPlatillo> productos_platillo) {
			ArrayList<ProdPlatillo> errorProd = new ArrayList<ProdPlatillo>();
			for(ProdPlatillo pp : productos_platillo){
				if(pp.idproducto != 0){
					if(pp.idproducto_platillo != 0){
						results = conn.queryUpdate("UPDATE producto_platillo SET idproducto = " + 
								pp.idproducto + ", cantidad = " + pp.cantidad + ", idunidad = " + pp.idunidad
								+ " WHERE idproducto_platillo = " + pp.idproducto_platillo);
					}else{
						String sql = "INSERT INTO producto_platillo (idplatillo, idproducto, cantidad, idunidad) "
								+ "VALUES(" + idplatillo + ", " + pp.idproducto + ", " 
								+ pp.cantidad + ", " + pp.idunidad   + ")";
							results = this.conn.queryUpdate(sql);
						sql = "SELECT MAX(idproducto_platillo) AS idproducto_platillo FROM producto_platillo WHERE idplatillo = " + idplatillo;
						query = this.conn.query(sql);
						try {
							if(query.next()){
								pp.idproducto_platillo = query.getInt("idproducto_platillo");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}else{
					errorProd.add(pp);
				}
			}
			for(ProdPlatillo p : errorProd){
				productos_platillo.remove(p);
			}
			this.productos_platillo = productos_platillo;
		}
	}
	
	
	public static class ProdPlatillo{
		public int idproducto, idunidad, idproducto_platillo;
		public float cantidad;
		public String producto, unidad;
		public ProdPlatillo(int idproducto, int idunidad, float cantidad){
			this.idproducto = idproducto;
			this.idunidad = idunidad;
			this.cantidad = cantidad;
		}
		public ProdPlatillo(int idproducto_platillo, int idproducto, int idunidad, float cantidad, String producto, String unidad){
			this.idproducto_platillo = idproducto_platillo;
			this.idproducto = idproducto;
			this.idunidad = idunidad;
			this.cantidad = cantidad;
			this.producto = producto;
			this.unidad = unidad;
		}
	}
	
	public static class Unidad{
		public int idunidad;
		public String unidad;
		public Unidad(int idunidad, String unidad){
			this.idunidad = idunidad;
			this.unidad = unidad;
		}
	}
	
}
