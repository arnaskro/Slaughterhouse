package mediator;

import java.util.ArrayList;

import model.Animal;
import model.Part;
import model.Tray;

public class ModelManager {
	private Persistence database;
	private ArrayList<Animal> animals;
	private ArrayList<Part> parts;
	private ArrayList<Tray> trays;
	
	public ModelManager() throws ClassNotFoundException {
		database = new DatabaseAdapter();
		try {
			animals = database.loadAnimals();
			parts = database.loadParts();
			trays = database.loadTrays();
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println("Animals:");
		for(int i=0;i<animals.size();i++){
			System.out.println(animals.get(i).getWeight() + " " + animals.get(i).getAnimalId() + " " + animals.get(i).getType());
		}
		System.out.println("Parts:");
		for(int i=0;i<parts.size();i++){
			System.out.println(parts.get(i).getPartId() + " " + parts.get(i).getType() + " " + parts.get(i).getWeight());
		}
		System.out.println("Trays:");
		for(int i=0;i<trays.size();i++){
			System.out.println(trays.get(i).getType() + " " + trays.get(i).getTrayId() + " " + trays.get(i).getMaxWeight());
		}
	}
}
