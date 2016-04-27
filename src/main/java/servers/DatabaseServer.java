package servers;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import mediator.DatabaseAdapter;
import mediator.Persistence;
import model.*;
import servers.DatabaseServerInterface;

@SuppressWarnings("serial")
public class DatabaseServer extends UnicastRemoteObject implements DatabaseServerInterface
{
	private Persistence database;
	private ArrayList<Animal> animals;
	private ArrayList<Part> parts;
	private ArrayList<Tray> trays;
	private ArrayList<Product> products;
	private ArrayList<Market> markets;
		
	public DatabaseServer() throws RemoteException 
	{
		super();
		
		try {
			database = new DatabaseAdapter();
			
			animals = database.loadAnimals();
			parts = database.loadParts();
			trays = database.loadTrays();
			products = database.loadProducts();
			markets = database.loadMarkets();
			
			System.out.println("{DatabaseServer} Loaded models from the database!");
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		printDatabase();
	
	}
	
	private void printDatabase()
	{
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
			System.out.println("Product parts:");
			for (int j = 0; j < products.get(i).getParts().size(); j++) {
				System.out.println(products.get(i).getParts().get(j).getPartId() + " "
						+ products.get(i).getParts().get(j).getType() + " "
						+ products.get(i).getParts().get(j).getWeight());
			}
		}
		System.out.println("Markets:");
		for (int i = 0; i < markets.size(); i++) {
			System.out.println(markets.get(i).getMarketId() + " " + markets.get(i).getAddress());
			System.out.println("Markets products:");
			for (int j = 0; j < markets.get(i).getProducts().size(); j++) {
				System.out.println(markets.get(i).getProducts().get(j).getProductId() + " "
						+ markets.get(i).getProducts().get(j).getType() + " "
						+ markets.get(i).getProducts().get(j).getWeight());
			}
		}
	}
	
	public boolean addAnimal(float weight, String type) throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addPart(int animalId, String type, float weight)
			throws RemoteException
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addtray(String type, float maxWeight) throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addToTray(int partId, int trayId) throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addMarket(String address) throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean packTraysToProduct(String type, float weight, Tray[] trays)
			throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void transportTomarket(int productId, int marketId)
			throws RemoteException 
	{
		// TODO Auto-generated method stub
		
	}

	public Animal[] getAllAnimals() throws RemoteException 
	{
		return animals.toArray(new Animal[animals.size()]);
	}

	public Part[] getAllParts() throws RemoteException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Tray[] getAllTrays() throws RemoteException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Product[] getAllProducts() throws RemoteException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Market[] getAllMarkets() throws RemoteException 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("{DatabaseServer} Starting server...");
			Registry reg = LocateRegistry.createRegistry(1099);
			DatabaseServerInterface rmiServer = new DatabaseServer();
			Naming.rebind("SlaughterHouse", rmiServer);
			System.out.println("{DatabaseServer} Server started...");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
