package com.flickfinder.model;

public class Person {
	private int id;
	private String name;
	private int birth;
	
	public Person(int id, String name, int birth) {
		this.id = id;
		this.name = name;
		this.birth = birth;
	}
	
	public int getPersonId() {
		return this.id;
	}
	
	public void setPersonId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBirth() {
		return this.birth;
	}
	
	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birth=" + birth + "]";
	}
}
