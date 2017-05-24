package com.example.inventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps?useSSL=false", "root",
					"xxyyxyyx");
			return conn;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create(Inventory inventory) {
		Connection connection = getConnection();
		String sql = "insert into inventory (name,qty,price) values(?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, inventory.getName());
			stmt.setInt(2, inventory.getQty());
			stmt.setDouble(3, inventory.getPrice());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
		closeConnection(connection);
		}
	}
	
	public List<Inventory> selectAll(){
		List<Inventory> inventories = new ArrayList<>();
		String sql = "Select * from inventory";
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet results = stmt.executeQuery();
			while(results.next()){
				inventories.add(new Inventory(results.getInt("id"),results.getString("name"),results.getInt("qty"),results.getDouble("price")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
		closeConnection(conn);
		}
		return inventories;
	}
	public void update(int id,String name,int qty,double price){
		Connection conn = getConnection();
		String sql = "update inventory set name = ?, qty = ?, price = ? where id = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setInt(2, qty);
			stmt.setDouble(3, price);
			stmt.setInt(4, id);
			stmt.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			closeConnection(conn);
		}
	}
	public void remove(int id){
		Connection conn = getConnection();
		String sql = "Delete from inventory where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeConnection(conn);
		}
		
	}
	public Inventory selectOne(int id){
		Inventory inventory = null;
		String sql = "Select * from inventory where id = ?";
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if(result.next()){
				inventory = new Inventory(id,result.getString("name"),result.getInt("qty"),result.getDouble("price"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeConnection(conn);
		}
		
		return inventory;
	}
}
