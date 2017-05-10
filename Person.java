package fileAccess;

import java.util.ArrayList;

public class Person {

	private String name;
	private String dob;
	private String occupation;
	private int salary;
	private ArrayList<Animal> pets = new ArrayList<Animal>();
	
	public Person(String name, String dob, String occupation, int salary) {
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.salary = salary;
	}
	
	public void addPets(Animal pet) {
		this.pets.add(pet);
	}

	public String getName() {
		return name;
	}
	public String getDob() {
		return dob;
	}
	public String getOccupation() {
		return occupation;
	}
	public int getSalary() {
		return salary;
	}
	public ArrayList<Animal> getPets() {
		return pets;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setPets(ArrayList<Animal> pets) {
		this.pets = pets;
	}
	
}
