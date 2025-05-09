package com.flickfinder.controller;

import java.sql.SQLException;
import java.util.List;

import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;

import io.javalin.http.Context;

public class PersonController {
	
	private final PersonDAO personDAO;
	
	public PersonController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	public void getAllPeople(Context ctx) {
		try {
			List<Person> people = personDAO.getAllPeople(5);
			ctx.json(people);
		} catch (SQLException e) {
			ctx.status(500);
			ctx.result("Database error");
			e.printStackTrace();
		}
	}
	
	
	public void getPersonById(Context ctx) {
		try {
			int id = Integer.parseInt(ctx.pathParam("id"));
			
			Person person = personDAO.getPersonById(id);
			if (person != null) {
				ctx.json(person);
			} else {
				ctx.status(404);
			}
		} catch (SQLException e) {
			ctx.status(500);
			ctx.result("Database error");
			e.printStackTrace();
		}
	}
	
	public void getMoviesStarringPerson(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		try {
			List<Person> movies = personDAO.getMoviesStarringPerson(id);
			if (movies == null) {
				ctx.status(404);
				ctx.result("Stars not found");
				return;
			}
			ctx.json(movies);
		} catch (SQLException e) {
			ctx.status(500);
			ctx.result("Database error");
			e.printStackTrace();
		}
	}
	
}