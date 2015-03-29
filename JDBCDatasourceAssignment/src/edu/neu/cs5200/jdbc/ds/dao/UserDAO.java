package edu.neu.cs5200.jdbc.ds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.cs5200.jdbc.ds.model.*;


public class UserDAO {

	DataSource ds;
	
	public UserDAO()
	{
		System.out.println("user...");
		try{
		Context ctx = new InitialContext();
		ds =(DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDatasourceAssignment");
		System.out.println(ds);
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	// create a user
	public User create(User user)
	{
		String sql ="insert into user values (null,?,?,?,?,?,?)";
		try {
			Connection connection  = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getFirstname());
			statement.setString(5, user.getEmail());
			statement.setDate(6,  user.getDateofbrith());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// retrieve all users
	public List<User> findAllUsers()
	{
		List<User> users = new ArrayList<User>();
		String sql ="select * from user";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				User user = new User();
				user.setId(results.getInt("id"));
				user.setUsername(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setLastname(results.getString("lastname"));
				user.setFirstname(results.getString("firstname"));
				user.setEmail(results.getString("email"));
				user.setDateofbrith(results.getDate("dateofbrith"));
				users.add(user);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	// retrieve a user by id
	public User findById(int id)
	{
		User user = new User();
		
		String sql ="select * from user where id =?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				user.setId(result.getInt("id"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setLastname(result.getString("lastname"));
				user.setFirstname(result.getString("firstname"));
				user.setEmail(result.getString("email"));
				user.setDateofbrith(result.getDate("dateofbrith", null));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	// update a user by id
	public User updateUser(int id, User user)
	{
		
		String sql ="update user set username=?, password=?, lastname=?, firstname=?, email=?, dateofbrith=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getFirstname());
			statement.setString(5, user.getEmail());
			statement.setDate(6,  user.getDateofbrith());
			statement.setInt(7,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	// delete a user by id
	public int deleteUser(int id)
	{
		String sql ="delete from user where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
}



