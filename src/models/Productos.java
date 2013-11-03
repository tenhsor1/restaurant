package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.JDBC;


public class Productos {
	static ResultSet result;
	private JDBC conn;
	
	public Productos(JDBC conn){
			//new JDBC("127.0.0.1", "restaurant", "root", "abc123");
			this.conn = conn;
	}
	public ArrayList<Producto> getAllProductos(){
		ResultSet query;
		query = conn.query("SELECT idproducto FROM productos");
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		try {
			while(query.next()){
				productos.add(new Producto(query.getInt("idproducto")));
			}
			return productos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet insertProducto(int idproducto){
		return null;
	}
	
	
	public class Producto{
		

		private int idproducto;
		private String producto;
		private int idcategoria;
		private int results;
		private ResultSet idp, query;
	
		public Producto(int idproductop) throws SQLException{
			 query = conn.query("SELECT idproducto, producto, idcategoria FROM productos WHERE idproducto = " + idproductop);
				 idproducto = query.getInt("idproducto");
				 producto = query.getString("producto");
				 idcategoria = query.getInt("idcategoria");
		}
		
		public Producto(String productop, int idcategoriap){
			String sql = "INSERT INTO productos (producto, idcategoria) VALUES(" +
						productop + ", " + idcategoriap + ")";
			results = conn.queryUpdate(sql);
			if(results > 0){
				producto = productop;
				idcategoria = idcategoriap;
				idp = conn.query("SELECT MAX(idproducto) FROM productos");
				try {
					idproducto = idp.getInt(0);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		public int getIdproducto() {
			return idproducto;
		}

		public String getProducto() {
			return producto;
		}

		public void setProducto(String producto) {
			results = conn.queryUpdate("UPDATE productos SET producto = " + 
		producto + " WHERE idproducto = " + idproducto);
			if(results > 0){
				this.producto = producto;
			}
		}

		public int getIdcategoria() {
			return idcategoria;
		}

		public void setIdcategoria(int idcategoria) {
			results = conn.queryUpdate("UPDATE productos SET idcategoria = " + 
					idcategoria + " WHERE idproducto = " + idproducto);
			if(results > 0){
				this.idcategoria = idcategoria;
			}
		}
	}
}

