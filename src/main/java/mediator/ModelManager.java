package mediator;

import java.util.ArrayList;

import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;

public class ModelManager {
	private Persistence database;
	private ArrayList<Animal> animals;
	private ArrayList<Part> parts;
	private ArrayList<Tray> trays;
	private ArrayList<Product> products;
	private ArrayList<Market> markets;

	public ModelManager() throws ClassNotFoundException {
		database = new DatabaseAdapter();
		try {
			animals = database.loadAnimals();
			parts = database.loadParts();
			trays = database.loadTrays();
			products = database.loadProducts();
			markets = database.loadMarkets();
		} catch (Exception e) {
			e.getMessage();
		}

		System.out.println("Animals:");
		for (int i = 0; i < animals.size(); i++) {
			System.out.println(
					animals.get(i).getWeight() + " " + animals.get(i).getAnimalId() + " " + animals.get(i).getType());
		}
		System.out.println("Parts:");
		for (int i = 0; i < parts.size(); i++) {
			System.out
					.println(parts.get(i).getPartId() + " " + parts.get(i).getType() + " " + parts.get(i).getWeight());
		}
		System.out.println("Trays:");
		for (int i = 0; i < trays.size(); i++) {
			System.out.println(
					trays.get(i).getType() + " " + trays.get(i).getTrayId() + " " + trays.get(i).getMaxWeight());
			System.out.println("Trays Parts:");
			for (int j = 0; j < trays.get(i).getParts().size(); j++) {
				System.out.println("     " + trays.get(i).getParts().get(j).getPartId() + " "
						+ trays.get(i).getParts().get(j).getType() + " " + trays.get(i).getParts().get(j).getWeight());
			}
		}
		System.out.println("Products:");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i).getProductId() + " " + products.get(i).getType() + " "
					+ products.get(i).getWeight());
		}
		System.out.println("Markets:");
		for (int i = 0; i < markets.size(); i++) {
			System.out.println(markets.get(i).getMarketId() + " " + markets.get(i).getAddress());
		}
	}
}
