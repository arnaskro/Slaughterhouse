package dk.slaughterhouse.services;

import dk.slaughterhouse.model.*;

public interface Tracking {

	public Animal[] getAnimals();
	
	public String trackAnimal(int animalId);
	
}
