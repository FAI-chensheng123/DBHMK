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

import edu.neu.cs5200.jdbc.ds.model.Comment;

public class CommentDAO {
DataSource ds;
	
	public CommentDAO()
	{
		System.out.println("comment...");
		try{
		Context ctx = new InitialContext();
		ds =(DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDatasourceAssignment");
		System.out.println(ds);
		}catch(NamingException e){
			e.printStackTrace();
		}
	}

	// create comment
		public Comment create(Comment comment)
		{
			String sql ="insert into comment values (null, ?,?)";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, comment.getComment());
				statement.setDate(2, comment.getDate());
				statement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
	// retrieve all comments
		public List<Comment> findAllComments()
		{
			List<Comment> comments = new ArrayList<Comment>();
			String sql ="select * from comment";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Comment comment = new Comment();
					comment.setId(results.getInt("id"));
					comment.setComment(results.getString("comment"));
					comment.setDate(results.getDate("date"));
					comments.add(comment);	
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return comments;
		}
		
		//retrieve comments by id
		public Comment findById(int id)
		{
			Comment comment = new Comment();
			
			String sql ="select * from comment where id =?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					comment.setId(result.getInt("id"));
					comment.setComment(result.getString("comment"));
					comment.setDate(result.getDate("comment", null));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return comment;
		}
		//update comment by id
		public Comment updateComment(int id, Comment comment)
		{
			
			String sql ="update comment set comment=?, date=? where id=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, comment.getComment());				
				statement.setDate(2,  comment.getDate());
				statement.setInt(3,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return comment;
			
		}
		//delete comment by id 
		public int deleteComment(int id)
		{
			String sql ="delete from comment where id=?";
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
