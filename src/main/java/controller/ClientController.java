package controller;

import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;
import servers.Model;
import view.View;

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
		} else {
			// Do nothing
			view.show("Execution error");
		}
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
