package dk.slaughterhouse.controller;

import java.util.ArrayList;

import dk.slaughterhouse.model.*;
import dk.slaughterhouse.view.*;
import dk.slaughterhouse.servers.*;

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
		} else if (what.equals("transportProducts")) {
			transportProducts();
		} else if (what.equals("trackProducts")) {
			trackProducts();
		} else if (what.equals("packProduct")) {
			packProduct();
		}  else {
			// Do nothing
			view.show("Execution error");
		}
	}

	private void addAnimal() {
		Float weight = Float.parseFloat(view.get("weight"));
		String type = view.get2("type");

		view.show("" + model.addAnimal(weight, type));

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

	private void transportProducts() {
		Product[] products = model.getAllProducts();
		Market[] markets = model.getAllMarkets();
		view.showAllProducts(products);
		int productId = Integer.parseInt(view.get("product id:"));
		view.showAllMarkets(markets);
		int marketId = Integer.parseInt(view.get2("market id:"));

		model.transportProductToMarket(productId, marketId);
	}

	private void trackProducts() {
		Animal[] animals = model.getAllAnimals();
//		Part[] parts = model.getAllParts();
//		Tray[] trays = model.getAllTrays();
		Product[] products = model.getAllProducts();
		ArrayList<Integer> productIds = new ArrayList<Integer>();
//		ArrayList<Integer> trayIds = new ArrayList<Integer>();

		view.showAllAnimals(animals);
		int animalId = Integer.parseInt(view.get("animal id:"));

//		// For getting bad trays
//		for (int i = 0; i < parts.length; i++) {
//			if (animalId == parts[i].getAnimalId()) {
//				for (int k = 0; k < trays.length; k++) {
//					for (int j = 0; j < trays[k].getParts().size(); j++) {
//						if (trays[k].getParts().get(j).getPartId() == parts[i].getPartId()) {
//							trayIds.add(trays[k].getTrayId());
//							break;
//						}
//					}
//				}
//				// partIds.add(parts[i].getPartId());
//			}
//		}

		for (int k = 0; k < products.length; k++) {
			for (int j = 0; j < products[k].getParts().size(); j++) {
				if (products[k].getParts().get(j).getAnimalId() == animalId) {
					productIds.add(products[k].getProductId());
				}
			}
		}
		view.show("Bad products:");
		for (int i = 0; i < productIds.size(); i++) {
			view.show("" + productIds.get(i));
		}
	}
	
	private void packProduct(){
		Tray[] trays = model.getAllTrays();
		String type = view.get("type:");
		Float weight = Float.parseFloat(view.get2("weight"));
		
		view.showAllTrays(trays);
		String trayIds = view.get2("tray id(if more than 1 use , to separate)");
		String[] split = trayIds.split("\\D\\s", -1);
		Tray[] usedTrays = new Tray[split.length];
		for(int i=0;i<split.length;i++){
			for(int j=0;j<trays.length;j++){
				if(Integer.parseInt(split[i]) == trays[j].getTrayId()){
					usedTrays[i] = trays[j];
					break;
				}
			}
		}
		model.packTraysToProduct(type, weight, usedTrays);
//		for(int i=0;i<split.length;i++){
//			view.show(split[i]);
//		}
//		view.show(type);
//		view.show("" + weight);
	}
}
