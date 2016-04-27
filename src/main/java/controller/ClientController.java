package controller;

import model.Animal;
import servers.Model;
import view.View;

public class ClientController implements Controller {
	private Model model;
	private View view;
	private String result;

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
		result = "?";
		
		Animal[] animals = model.getAllAnimals();
				
		result = "All animals:";
		
		for (Animal animal : animals) {
			result += "\n[ID:" + animal.getAnimalId() + ", Type:" + animal.getType() + ", Weight:" + animal.getWeight() + "]";
		}
		
		view.show(result);
	}
}
