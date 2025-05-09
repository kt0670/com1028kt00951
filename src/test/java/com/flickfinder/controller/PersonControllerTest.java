package com.flickfinder.controller;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Person;

import io.javalin.http.Context;

class PersonControllerTest {
	private Context ctx;
	private PersonDAO personDAO;
	
	private PersonController personController;

	@BeforeEach
	void setUp() throws SQLException {
		personDAO = mock(PersonDAO.class);
		ctx = mock(Context.class);
		personController = new PersonController(personDAO);
		
		
	    List<Person> mockPeople = List.of(
	        new Person(1, "Tim Robbins", 1958),
	        new Person(2, "Morgan Freeman", 1937),
	        new Person(3, "Cristopher Nolan", 1970),
	        new Person(4, "Al Pacino", 1940),
	        new Person(5, "Henry Fonda", 1905)
	    );
	    when(personDAO.getAllPeople(5)).thenReturn(mockPeople);

	   
	    when(personDAO.getPersonById(1)).thenReturn(new Person(1, "Tim Robbins", 1958));
	    when(personDAO.getPersonById(1500)).thenReturn(null); 
	}
	
	@Test
	void testGetAllPeople() throws SQLException {
		personController.getAllPeople(ctx);
		verify(personDAO).getAllPeople(5);
        verify(ctx).json(anyList());
		}
	
	
	@Test
	void testThrows500ExceptionWhenGetAllDatabaseError() throws SQLException {
		when(personDAO.getAllPeople(5)).thenThrow(new SQLException());
		personController.getAllPeople(ctx);
		verify(ctx).status(500);
	}

	@Test
	void testGetPersonById() throws SQLException {
		when(ctx.pathParam("id")).thenReturn("1");
		personController.getPersonById(ctx);
		verify(personDAO).getPersonById(1);
        verify(ctx).json(any(Person.class));
	}

	@Test
	void testThrows500ExceptionWhenGetByIdDatabaseError() throws SQLException {
		when(ctx.pathParam("id")).thenReturn("1");
		when(personDAO.getPersonById(1)).thenThrow(new SQLException());
		personController.getPersonById(ctx);
		verify(ctx).status(500);
	}

	@Test
	void testThrows404ExceptionWhenNoPersonFound() throws SQLException {
		when(ctx.pathParam("id")).thenReturn("1500");
		when(personDAO.getPersonById(1500)).thenReturn(null);
		when(ctx.status(404)).thenReturn(ctx);
		personController.getPersonById(ctx);
		verify(ctx).status(404);
	}
	
	@Test
	void testGetMoviesStarringPerson() {
		when(ctx.pathParam("id")).thenReturn("1");
		personController.getMoviesStarringPerson(ctx);
		try {
			verify(personDAO).getMoviesStarringPerson(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}