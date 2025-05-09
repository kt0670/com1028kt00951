package com.flickfinder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flickfinder.model.Movie;
import com.flickfinder.model.Movie.MovieRating;
import com.flickfinder.model.Person;
import com.flickfinder.util.Database;

/**
 * The Data Access Object for the Movie table.
 * 
 * This class is responsible for getting data from the Movies table in the
 * database.
 * 
 */
public class MovieDAO {

	/**
	 * The connection to the database.
	 */
	private final Connection connection;

	/**
	 * Constructs a SQLiteMovieDAO object and gets the database connection.
	 * 
	 */
	public MovieDAO() {
		Database database = Database.getInstance();
		connection = database.getConnection();
	}

	/**
	 * Returns a list of all movies in the database.
	 * 
	 * @return a list of all movies in the database
	 * @throws SQLException if a database error occurs
	 */

	public List<Movie> getAllMovies(int limit) throws SQLException {
		List<Movie> movies = new ArrayList<>();
		if (limit <= 0) {
			limit = 50;
		}
		
		String statement = ("select * from movies LIMIT ?");
		PreparedStatement ps = connection.prepareStatement(statement);
		ps.setInt(1, limit);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			movies.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getInt("year")));
		}
		
		System.out.println("Contents of movies list:");
	    for (Movie movie : movies) {
	        System.out.println(movie);
	    }

		return movies;
	}

	/**
	 * Returns the movie with the specified id.
	 * 
	 * @param id the id of the movie
	 * @return the movie with the specified id
	 * @throws SQLException if a database error occurs
	 */
	public Movie getMovieById(int id) throws SQLException {

		String statement = "select * from movies where id = ?";
		PreparedStatement ps = connection.prepareStatement(statement);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			return new Movie(rs.getInt("id"), rs.getString("title"), rs.getInt("year"));
		}

		return null;

	}
	
	public List<Person> getPeopleByMovieId(int movieId) throws SQLException {
		List<Person> stars = new ArrayList<>();
		
		String statement = "select p.id, p.name, p.birth from people p inner join stars s on p.id = s.person_id where s.movie_id = ?";
		PreparedStatement ps = connection.prepareStatement(statement);
		ps.setInt(1, movieId);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			stars.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birth")));
		}
		
		return stars;
	}
	
	public List<MovieRating> getMoviesByYearAndRating(int year, int limit, int minvotes) throws SQLException {
		
		if (limit <= 0) {
            limit = 10;
        }
		if (minvotes <= 0) {
            minvotes = 100;
        }
		
		List<MovieRating> movieRatings = new ArrayList<>();
		
		String statement = "select m.id, m.title, m.year, avg(r.rating) as avg_rating, sum(r.votes) as votes from movies m left join ratings r on m.id = r.movie_id where m.year = ? and r.votes >= ? group by m.id, m.title, m.year order by avg_rating desc limit ?";
		
		PreparedStatement ps = connection.prepareStatement(statement);
	    ps.setInt(1, year);
	    ps.setInt(2, minvotes);
	    ps.setInt(3,  limit);

	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
	        movieRatings.add(new MovieRating(
	            rs.getInt("id"),
	            rs.getString("title"),
	            rs.getInt("year"),
	            rs.getFloat("avg_rating"),
	            rs.getInt("votes")
	        ));
	    }
	    System.out.println("Movies: " + movieRatings);

	    return movieRatings;
	}

}
