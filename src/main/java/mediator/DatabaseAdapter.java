package mediator;

import java.io.IOException;
import java.sql.SQLException;
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

	public Animal[] loadAnimals() throws IOException {
		ArrayList<Animal> array = new ArrayList<Animal>();
		Animal[] result = null;
		
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
			
			result = new Animal[array.size()];
			
			for (int i = 0; i < array.size(); i++) {
				result[i] = array.get(i);
			}
			
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}

	public Part[] loadParts() throws IOException {
		ArrayList<Part> array = new ArrayList<Part>();
		Part[] result = null;

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

			result = new Part[array.size()];
			
			for (int i = 0; i < array.size(); i++) {
				result[i] = array.get(i);
			}
			
			
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}

	public Tray[] loadTrays() throws IOException {
		ArrayList<Tray> trays = new ArrayList<Tray>();

		Tray[] result = null;
		
		String sql = "SELECT * FROM tray";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				String type = row[0].toString();
				int trayId = Integer.parseInt(row[1].toString());
				float maxWeight = Float.parseFloat(row[2].toString());
				
				ArrayList<Part> parts = new ArrayList<Part>();
				String sql2 = "SELECT * FROM part WHERE tray_id = " + trayId;
				ArrayList<Object[]> results2 = db.query(sql2);
				for (int j = 0; j < results2.size(); j++) {
					Object[] row2 = results2.get(j);
					float weight = Float.parseFloat(row2[0].toString());
					int partId = Integer.parseInt(row2[1].toString());
					String type2 = row2[2].toString();
					int animalId = Integer.parseInt(row2[3].toString());
					parts.add(new Part(animalId, type2, partId, weight));
				}

				trays.add(new Tray(type, trayId, maxWeight, parts));
			}

			result = new Tray[trays.size()];
			
			for (int i = 0; i < trays.size(); i++) {
				result[i] = trays.get(i);
			}
			
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}

	public Market[] loadMarkets() throws IOException {
		ArrayList<Market> markets = new ArrayList<Market>();
		Market[] result = null;
		
		String sql = "SELECT * FROM market";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int marketId = Integer.parseInt(row[0].toString());
				String address = row[1].toString();
				
				ArrayList<Product> products = new ArrayList<Product>();
				String sql2 = "SELECT * FROM product WHERE market_id = " + marketId;
				ArrayList<Object[]> results2 = db.query(sql2);
				for (int j = 0; j < results2.size(); j++) {
					Object[] row2 = results2.get(j);
					int productId = Integer.parseInt(row2[0].toString());
					String type = row2[1].toString();
					float weight = Float.parseFloat(row2[3].toString());
					
					products.add(new Product(productId, type, weight));
				}

				markets.add(new Market(marketId, address, products));
			}

			result = new Market[markets.size()];
			
			for (int i = 0; i < markets.size(); i++) {
				result[i] = markets.get(i);
			}
			
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}
	
	public Product[] loadProducts() throws IOException {
		ArrayList<Product> products = new ArrayList<Product>();
		Product[] result = null;
		
		String sql = "SELECT * FROM product";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int productId = Integer.parseInt(row[0].toString());
				String type = row[1].toString();
				float weight = Float.parseFloat(row[3].toString());
				
				ArrayList<Part> parts = new ArrayList<Part>();
				String sql2 = "SELECT tray_id FROM packing WHERE product_id  = " + productId;
				ArrayList<Object[]> results2 = db.query(sql2);
				for (int j = 0; j < results2.size(); j++) {
					Object[] row2 = results2.get(j);
					int trayId = Integer.parseInt(row2[0].toString());
					
					String sql3 = "SELECT * FROM part WHERE tray_id  = " + trayId;
					ArrayList<Object[]> results3= db.query(sql3);
					for (int k = 0; k < results3.size(); k++) {
						Object[] row3 = results3.get(k);
						float weight2 = Float.parseFloat(row3[0].toString());
						int partId = Integer.parseInt(row3[1].toString());
						String type2 = row3[2].toString();
						int animalId = Integer.parseInt(row3[3].toString());
						parts.add(new Part(animalId, type2, partId, weight2));
					}
					
				}
				products.add(new Product(parts, productId, type, weight));
			}
			
			result = new Product[products.size()];
			
			for (int i = 0; i < products.size(); i++) {
				result[i] = products.get(i);
			}
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}
	public void saveAnimal(float weight, String type){
		String sql = "INSERT INTO animal VALUES (" + weight + ", 1, '" + type + "');";
		try {
			db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
