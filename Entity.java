package fileAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entity {
	private ArrayList<Person> personArray = new ArrayList<Person>();
	private ArrayList<Animal> animalArray = new ArrayList<Animal>();

	public void processEntitys() {
		personArray.forEach(p -> animalArray.forEach(a -> {
		if(p.getName().equalsIgnoreCase("elliott") && (a.getSpecies().equalsIgnoreCase("cat") || a.getSpecies().equalsIgnoreCase("tortoise")))
			p.addPets(a);
		if(p.getName().equalsIgnoreCase("gareth") && (a.getSpecies().equalsIgnoreCase("cat") || a.getSpecies().equalsIgnoreCase("dolphin")))
			p.addPets(a);
		}));
	}
	public void processDialog() {
		formDialog.personDescription(personArray);
		formDialog.personPets(personArray);
		formDialog.personSalaryAverage(personArray, "cat");//  returns the average of pet owners salary's who own a specific species of pet. replace "cat" with any species.
		formDialog.occupationOfOwnerByAnimal(personArray, "cat");// returns occupations of persons whom own a specific species of pet. replace "cat" with any species.
		formDialog.animalOwnedByOccupation(personArray, "trainer");// returns pets of persons with specified occupation. replace "trainer" with any occupation.
	}
	public void addPersons(StringBuilder sb) {
		String[] Persons = splitStringToObjects(sb)[0];
		String[][] Person = new String[Persons.length][];
		Arrays.stream(Persons).forEach(p -> {
			int i = Arrays.asList(Persons).indexOf(p);
			Person[i] = Persons[i].replace("£", "").split(",");
			getPersonArray().add(new Person(Person[i][0], Person[i][1], Person[i][2], Integer.parseInt(Person[i][3])));
		});
	}
	public void addAnimals(StringBuilder sb) {
		String[] Pets = splitStringToObjects(sb)[1];
		String[][] Pet = new String[Pets.length][];
		Arrays.stream(Pets).forEach(a -> {
			int i = Arrays.asList(Pets).indexOf(a);
			Pet[i] = Pets[i].split(",");
			this.getAnimalArray().add(new Animal(Pet[i][0], Pet[i][1]));
		});
	}
	public String[][] splitStringToObjects(StringBuilder sb) {
		String[] seperateGroups = sb.toString().split("&,");
		String[][] objects = new String[seperateGroups.length][];
		Arrays.stream(seperateGroups).forEach(e 
				-> objects[Arrays.asList(seperateGroups).indexOf(e)] 
						= seperateGroups[Arrays.asList(seperateGroups).indexOf(e)].split("%,"));
		return objects;
	}
	public static int averagePetOwnerSalary(ArrayList<Person> personArray, String Species) {
		List<Integer> salarys = new ArrayList<Integer>();
		personArray.forEach((Person p) ->
			p.getPets().forEach((Animal a) -> {
				if(a.getSpecies().equalsIgnoreCase(Species))
					salarys.add(p.getSalary());
			}));
		return (int) salarys.stream().mapToInt(e -> e).average().getAsDouble();
	}
	
	
	public ArrayList<Person> getPersonArray() {
		return personArray;
	}
	public void setPersonArray(ArrayList<Person> personArray) {
		this.personArray = personArray;
	}
	public ArrayList<Animal> getAnimalArray() {
		return animalArray;
	}
	public void setAnimalArray(ArrayList<Animal> animalArray) {
		this.animalArray = animalArray;
	}
}
