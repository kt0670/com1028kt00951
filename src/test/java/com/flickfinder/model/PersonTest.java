package com.flickfinder.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * TODO: Implement this class
 * 
 */

class PersonTest {
	private Person person;

	/**
	 * Set up the movie object before each test.
	 *
	 */
	@BeforeEach
	public void setUp() {
		person = new Person(1, "Anne", 1980);
	}

	/**
	 * Test the person object is created with the correct values.
	 */
	@Test
	public void testPersonCreated() {
		assertEquals(1, person.getPersonId());
		assertEquals("Anne", person.getName());
		assertEquals(1980, person.getBirth());
	}

	/**
	 * Test the person object is created with the correct values.
	 */
	@Test
	public void testPersonSetters() {
		person.setPersonId(2);
		person.setName("Anne Hathaway");
		person.setBirth(1982);
		assertEquals(2, person.getPersonId());
		assertEquals("Anne Hathaway", person.getName());
		assertEquals(1982, person.getBirth());
	}

}