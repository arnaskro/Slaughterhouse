package services;

import java.io.IOException;
import java.rmi.RemoteException;

import mediator.DatabaseAdapter;
import model.Animal;
import servers.DatabaseServer;
import servers.DatabaseServerInterface;

public class PublicWebService2 {
	
	private static Animal[] animals = loadAnimals();
		
	public Animal[] getAllAnimals() {
		return animals;
	}
	
	private static Animal[] loadAnimals() {
		Animal[] result = new Animal[2];

		result[0] = new Animal(75, 0, "Cow");
		result[1] = new Animal(100, 1, "Chicken");
		
		return result;
	}
	
}
