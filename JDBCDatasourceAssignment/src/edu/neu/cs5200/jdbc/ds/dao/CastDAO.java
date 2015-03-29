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

import edu.neu.cs5200.jdbc.ds.model.Cast;

public class CastDAO {
DataSource ds;
	
	public CastDAO()
	{
		System.out.println("cast...");
		try{
		Context ctx = new InitialContext();
		ds =(DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDatasourceAssignment");
		System.out.println(ds);
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	// create cast
	public Cast create(Cast cast)
	{
		String sql ="insert into cast values (null, ?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cast.getCharacterName());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	// retrieve all cast
	public List<Cast> findAllCasts()
	{
		List<Cast> casts = new ArrayList<Cast>();
		String sql ="select * from cast";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getInt("id"));
				cast.setCharacterName(results.getString("characterName"));
				casts.add(cast);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return casts;
	}
	// retrieve cast by id
	public Cast findById(int id)
	{
		Cast cast = new Cast();
		
		String sql ="select * from cast where id =?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				cast.setId(result.getInt("id"));
				cast.setCharacterName(result.getString("characterName"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return cast;
	}
	// update cast by id
	public Cast updateCast(int id, Cast cast)
	{
		
		String sql ="update cast set characterName=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cast.getCharacterName());				
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cast;
		
	}
	// delete cast by id
	public int deleteComment(int id)
	{
		String sql ="delete from cast where id=?";
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
