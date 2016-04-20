package mediator;

import java.io.IOException;
import java.util.ArrayList;

import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;
import utility.persistence.MyDatabase;

public class DatabaseAdapter implements Persistence {
	private MyDatabase db;
	private static final String DB_NAME = "Slaughterhouse";

	public DatabaseAdapter() throws ClassNotFoundException {
		this.db = new MyDatabase(DB_NAME);
	}

	public ArrayList<Animal> loadAnimals() throws IOException {
		ArrayList<Animal> array = new ArrayList<Animal>();

		String sql = "SELECT * FROM animal";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				float weight = Float.parseFloat(row[0].toString());
				int animalId = Integer.parseInt(row[1].toString());
				String type = row[2].toString();

				array.add(new Animal(weight, animalId, type));
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return array;
	}

	public ArrayList<Part> loadParts() throws IOException {
		ArrayList<Part> array = new ArrayList<Part>();

		String sql = "SELECT * FROM part";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				float weight = Float.parseFloat(row[0].toString());
				int partId = Integer.parseInt(row[1].toString());
				String type = row[2].toString();
				int animalId = Integer.parseInt(row[3].toString());
				array.add(new Part(animalId, type, partId, weight));
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return array;
	}

	public ArrayList<Tray> loadTrays() throws IOException {
		ArrayList<Tray> array = new ArrayList<Tray>();

		String sql = "SELECT * FROM tray";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				String type = row[0].toString();
				int trayId = Integer.parseInt(row[1].toString());
				float maxWeight = Float.parseFloat(row[2].toString());

				array.add(new Tray(type, trayId, maxWeight));
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return array;
	}

	@Override
	public ArrayList<Market> loadMarkets() throws IOException {
		ArrayList<Market> array = new ArrayList<Market>();
		
		String sql = "SELECT * FROM market";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int marketId = Integer.parseInt(row[0].toString());
				String address = row[1].toString();

				array.add(new Market(marketId, address));
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return array;
	}

	@Override
	public ArrayList<Product> loadProducts() throws IOException {
		ArrayList<Product> array = new ArrayList<Product>();
		
		String sql = "SELECT * FROM product";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int productId = Integer.parseInt(row[0].toString());
				String type = row[1].toString();
				float weight = Float.parseFloat(row[2].toString());


				array.add(new Product(productId, type, weight));
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return array;
	}
}
