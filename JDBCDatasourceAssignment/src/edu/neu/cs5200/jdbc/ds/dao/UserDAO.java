package edu.neu.cs5200.jdbc.ds.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.cs5200.jdbc.ds.model.User;

public class UserDAO {

	DataSource ds;
	
	public UserDAO()
	{
		System.out.println("comingin..");
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
			while()
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	// retrieve a user by id
	// update a user by id
	// delete a user by id
}
