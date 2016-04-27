package controller;

import model.Animal;
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
		switch (what) {
		case "getAllAnimals":
			getAllAnimals();
		break;		
		default: break;
		}
	}

	private void getAllAnimals() {
		Animal[] animals = model.getAllAnimals();
		view.showAllAnimals(animals);
	}
}
