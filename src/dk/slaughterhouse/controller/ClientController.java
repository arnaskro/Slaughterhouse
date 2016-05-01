package dk.slaughterhouse.controller;

import dk.slaughterhouse.model.Animal;
import dk.slaughterhouse.model.Market;
import dk.slaughterhouse.model.Part;
import dk.slaughterhouse.model.Product;
import dk.slaughterhouse.model.Tray;
import dk.slaughterhouse.servers.Model;
import dk.slaughterhouse.view.View;

public class ClientController implements Controller {
	private Model model;
	private View view;

	public ClientController(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void execute(String what) {
		if (what.equals("getAllAnimals")) {
			getAllAnimals();
		} else if (what.equals("getAllParts")) {
			getAllParts();
		} else if (what.equals("getAllProducts")) {
			getAllProducts();
		} else if (what.equals("getAllTrays")) {
			getAllTrays();
		} else if (what.equals("getAllMarkets")) {
			getAllMarkets(); 
		} else if (what.equals("addAnimal")) {
			addAnimal(); 
		} else {
			// Do nothing
			view.show("Execution error");
		}
	}

	private void addAnimal() {
		Float weight = Float.parseFloat(view.get("weight"));
		String type = view.get("type");
		
		view.show(""+model.addAnimal(weight, type));
		
	}
	
	private void getAllMarkets() {
		Market[] animals = model.getAllMarkets();
		view.showAllMarkets(animals);
	}

	private void getAllTrays() {
		Tray[] animals = model.getAllTrays();
		view.showAllTrays(animals);
	}

	private void getAllProducts() {
		Product[] animals = model.getAllProducts();
		view.showAllProducts(animals);
	}

	private void getAllParts() {
		Part[] animals = model.getAllParts();
		view.showAllParts(animals);
		
	}

	private void getAllAnimals() {
		Animal[] animals = model.getAllAnimals();
		view.showAllAnimals(animals);
	}
}
