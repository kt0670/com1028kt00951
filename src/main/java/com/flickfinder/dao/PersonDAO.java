package com.flickfinder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flickfinder.model.Person;
import com.flickfinder.util.Database;

public class PersonDAO {
	private final Connection connection;
	
	public PersonDAO() {
		Database database = Database.getInstance();
		connection = database.getConnection();
	}
	
	public List<Person> getAllPeople(int limit) throws SQLException {
		List<Person> people = new ArrayList<>();
		
		if (limit <= 0) {
			limit = 10;
		}
		
		String statement = ("select * from people LIMIT ?");
		PreparedStatement ps = connection.prepareStatement(statement);
		ps.setInt(1, limit);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			people.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birth")));
		}

		return people;
	}
	
	public Person getPersonById(int id) throws SQLException {
		String statement = "select * from people where id = ?";
		PreparedStatement ps = connection.prepareStatement(statement);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			return new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birth"));
		}

		return null;
	}
	
	public List<Person> getMoviesStarringPerson(int personId) throws SQLException {
		List<Person> movies = new ArrayList<>();
		String statement = ("select m.id, m.title, m.year from movies m inner join stars s on m.id = s.movie_id where s.person_id = ?");
		PreparedStatement ps = connection.prepareStatement(statement);
		ps.setInt(1, personId);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			movies.add(new Person(rs.getInt("id"), rs.getString("title"), rs.getInt("year")));
		}
		
		return movies;
	}
	
}
		
