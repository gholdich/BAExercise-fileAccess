package fileAccess;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class formDialog {
	static DecimalFormat formatter = new DecimalFormat("#,###,###,##0");
	
	public static void personDescription(ArrayList<Person> personArray) {
		personArray.forEach(p -> { System.out.println(p.getName()
				+", "+(2017-Integer.parseInt(p.getDob().substring(p.getDob().length()-4)))
				+" years old, earns £"+formatter.format(p.getSalary())+" in the job role of "+p.getOccupation()+"."); });
	}
	
	public static void personPets(ArrayList<Person> personArray) {
		personArray.forEach(p -> { p.getPets().forEach(a -> {
			if(p.getPets().indexOf(a) == 0)
				System.out.print(p.getName()+" has "+p.getPets().size()+" pets, including a "+a.getSpecies()+" called "+a.getName());
			else
				System.out.print(" and a "+a.getSpecies()+" called "+a.getName());
			if(p.getPets().indexOf(a) == p.getPets().size()-1)
				System.out.println(".");
			});
		});
	}
	
	public static void personSalaryAverage(ArrayList<Person> personArray, String Species) {
		System.out.println(Species.substring(0, 1).toUpperCase()+Species.substring(1)+"'s are possessed by owners with an average salary of £"+formatter.format(Entity.averagePetOwnerSalary(personArray, Species))+".");
	}
	
	public static void occupationOfOwnerByAnimal(ArrayList<Person> personArray, String Species) {
		List<String> occupations = new ArrayList<String>();
		personArray.forEach((Person p) -> {
			p.getPets().forEach((Animal a) -> {
				if(a.getSpecies().equalsIgnoreCase(Species)) {
					occupations.add(p.getOccupation());
				}
			});
		});
		occupations.forEach(e -> {
			if(occupations.indexOf(e) == 0)
				System.out.print(Species.substring(0, 1).toUpperCase()+Species.substring(1)+"'s are possessed by owners that have the job occupation "+e);
			else
				System.out.print(" and "+e);
			if(occupations.indexOf(e) ==  occupations.size()-1)
				System.out.println(".");				
		});
	}
	
	public static void animalOwnedByOccupation(ArrayList<Person> personArray, String Occupations) {
		List<String> pets = new ArrayList<String>();
		personArray.forEach((Person p) -> {
			if(p.getOccupation().equalsIgnoreCase(Occupations)) {
				p.getPets().forEach((Animal a) -> {
					pets.add(a.getSpecies());
				});
			}
		});
		pets.forEach(e -> {
			if(pets.indexOf(e) == 0)
				System.out.print(Occupations.substring(0, 1).toUpperCase()+Occupations.substring(1)+"'s own pets such as: "+e);
			else
				System.out.print(", "+e);
			if(pets.indexOf(e) ==  pets.size()-1)
				System.out.println(".");				
		});
	}
	
}
