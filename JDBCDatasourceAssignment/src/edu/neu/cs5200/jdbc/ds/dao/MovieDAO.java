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

import edu.neu.cs5200.jdbc.ds.model.Movie;

public class MovieDAO {
DataSource ds;
	
	public MovieDAO()
	{
		System.out.println("movie...");
		try{
		Context ctx = new InitialContext();
		ds =(DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDatasourceAssignment");
		System.out.println(ds);
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	//create Movie
	public Movie create(Movie movie)
	{
		String sql ="insert into movie values (null,?,?,?)";
		try {
			Connection connection  = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getPosterImage());
			statement.setDate(3,  movie.getRelaseDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//Retrieve all movies
	public List<Movie> findAllMovies()
	{
		List<Movie> movies = new ArrayList<Movie>();
		String sql ="select * from movie";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Movie movie = new Movie();
				movie.setId(results.getInt("id"));
				movie.setTitle(results.getString("title"));
				movie.setPosterImage(results.getString("posterImage"));
				movie.setRelaseDate(results.getDate("releaseDate"));
				movies.add(movie);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movies;
	}
	//Retrieve movie by id
	public Movie findById(int id)
	{
		Movie movie = new Movie();
		
		String sql ="select * from movie where id =?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				movie.setId(result.getInt("id"));
				movie.setTitle(result.getString("title"));
				movie.setPosterImage(result.getString("posterImage"));
				movie.setRelaseDate(result.getDate("releaseDate", null));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movie;
	}
	//update movie by id
	public Movie updateMovie(int id, Movie movie)
	{
		
		String sql ="update movie set title=?, posterImage=?, releaseDate=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getPosterImage());
			statement.setDate(3,  movie.getRelaseDate());
			statement.setInt(4,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movie;
		
	}
	//delete movie by id
	public int deleteUser(int id)
	{
		String sql ="delete from movie where id=?";
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
