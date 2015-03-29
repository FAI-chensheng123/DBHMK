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

import edu.neu.cs5200.jdbc.ds.model.Actor;

public class ActorDAO {
DataSource ds;
	
	public ActorDAO()
	{
		System.out.println("actor...");
		try{
		Context ctx = new InitialContext();
		ds =(DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDatasourceAssignment");
		System.out.println(ds);
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	// create Actor
	public Actor create(Actor actor)
	{
		String sql ="insert into actor values (null,?,?,?)";
		try {
			Connection connection  = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actor.getLastname());
			statement.setString(2, actor.getFirstname());
			statement.setDate(3,  actor.getDateofbrith());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// retrieve all actors
	public List<Actor> findAllActors()
	{
		List<Actor> actors = new ArrayList<Actor>();
		String sql ="select * from actor";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Actor actor = new Actor();
				actor.setId(results.getInt("id"));
				actor.setLastname(results.getString("lastname"));
				actor.setFirstname(results.getString("firstname"));
				actor.setDateofbrith(results.getDate("dateofbrith"));
				actors.add(actor);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return actors;
	}
	// retrieve actor by id
	public Actor findById(int id)
	{
		Actor actor = new Actor();
		
		String sql ="select * from actor where id =?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				actor.setId(result.getInt("id"));
				actor.setLastname(result.getString("lastname"));
				actor.setFirstname(result.getString("firstname"));
				actor.setDateofbrith(result.getDate("dateofbrith", null));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actor;
	}
	// update actor by id
	public Actor updateActor(int id, Actor actor)
	{
		
		String sql ="update actor set lastname=?, firstname=?, dateofbrith=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actor.getLastname());
			statement.setString(2, actor.getFirstname());
			statement.setDate(3,  actor.getDateofbrith());
			statement.setInt(4,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return actor;
		
	}
	// delete actor by id 
	public int deleteActor(int id)
	{
		String sql ="delete from actor where id=?";
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
