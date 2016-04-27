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
			
			System.out.println("{DatabaseServer} Models loaded from the database successfully!");
		} catch (Exception e) {
			e.getMessage();
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
		Animal[] result = new Animal[animals.size()];
		
		for (int i = 0; i < animals.size(); i++) {
			result[i] = animals.get(i);
		}
		
		return result;
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
			System.out.println("{DatabaseServer} Server running...");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
