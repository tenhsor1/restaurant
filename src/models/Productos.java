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
				productos.add(new Producto(conn, query.getInt("idproducto")));
			}
			return productos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Categoria> getAllCategorias(){
		ResultSet query;
		query = conn.query("SELECT idcategoria FROM categorias");
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		try {
			while(query.next()){
				categorias.add(new Categoria(conn, query.getInt("idcategoria")));
			}
			return categorias;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteProducto(int idproducto){
		String sql = "DELETE FROM productos WHERE idproducto = " + idproducto;
		return this.conn.queryUpdate(sql);
	}
	
	public int deleteCategoria(int idcategoria){
		String sql = "DELETE FROM categorias WHERE idcategoria = " + idcategoria;
		return this.conn.queryUpdate(sql);
	}
	
	public static class Producto{

		private int idproducto;
		private String producto;
		private int idcategoria;
		private String categoria;
		private int results;
		private ResultSet idp, query;
		private JDBC conn;
		public Producto(JDBC conn, int idproductop) throws SQLException{
			this.conn = conn;
			 query = this.conn.query("SELECT idproducto, producto, productos.idcategoria, categoria "
			 		+ "FROM productos LEFT JOIN categorias ON productos.idcategoria = categorias.idcategoria" 
					 +" WHERE idproducto = "+ idproductop);
			 	if(query.next()){
			 		idproducto = query.getInt("idproducto");
				 	producto = query.getString("producto");
				 	idcategoria = query.getInt("idcategoria");
				 	categoria = query.getString("categoria");
			 	}
		}


		public Producto(JDBC conn, String productop, int idcategoriap){
			this.conn = conn;
			String sql = "INSERT INTO productos (producto, idcategoria) VALUES('" +
						productop + "', " + idcategoriap + ")";
			results = this.conn.queryUpdate(sql);
			if(results > 0){
				producto = productop;
				idcategoria = idcategoriap;
				idp = this.conn.query("SELECT MAX(idproducto) AS idproducto FROM productos");
				try {
					if(idp.next())
					idproducto = idp.getInt("idproducto");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public int getIndexCategoria(){
			query = this.conn.query("SELECT idcategoria FROM categorias");
			try {
				int index = 0;
				while(query.next()){
					if(idcategoria == query.getInt("idcategoria")){
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
	
		public String getCategoria() {
			return categoria;
		}
		
		public int getIdproducto() {
			return idproducto;
		}

		public String getProducto() {
			return producto;
		}

		public void setProducto(String producto) {
			results = conn.queryUpdate("UPDATE productos SET producto = '" + 
		producto + "' WHERE idproducto = " + idproducto);
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
	
	public static class Categoria{
		private int idcategoria;
		private String categoria;
		private int results;
		private ResultSet idc, query;
		private JDBC conn;
		
		public Categoria(JDBC conn, int idcategoria) throws SQLException{
			this.conn = conn;
			 query = this.conn.query("SELECT idcategoria, categoria FROM categorias WHERE idcategoria = " + idcategoria);
			 	if(query.next()){
			 		this.idcategoria = query.getInt("idcategoria");
			 		this.categoria = query.getString("categoria");
			 	}
		}
		
		public Categoria(JDBC conn, String categoria){
			this.conn = conn;
			String sql = "INSERT INTO categorias (categoria) VALUES('" + categoria + "')";
			results = this.conn.queryUpdate(sql);
			if(results > 0){
				this.categoria = categoria;
				idc = this.conn.query("SELECT MAX(idcategoria) AS idcategoria FROM categorias");
				try {
					idc.next();
					idcategoria = idc.getInt("idcategoria");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		public int getIdcategoria() {
			return idcategoria;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			results = conn.queryUpdate("UPDATE categorias SET categoria = '" + 
			categoria + "' WHERE idcategoria = " + idcategoria);
			if(results > 0){
				this.categoria = categoria;
			}
		}
	}
}

