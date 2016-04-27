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
	private Animal[] animals;
	private Part[] parts;
	private Tray[] trays;
	private Product[] products;
	private Market[] markets;
		
	public DatabaseServer() throws RemoteException 
	{
		super();
		
		try {
			database = new DatabaseAdapter();
			addAnimal(50, "cow");
			
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
		try {
			database.saveAnimal(weight, type);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
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
		return animals;
	}

	public Part[] getAllParts() throws RemoteException
	{
		return parts;
	}

	public Tray[] getAllTrays() throws RemoteException
	{
		return trays;
	}

	public Product[] getAllProducts() throws RemoteException 
	{
		return products;
	}

	public Market[] getAllMarkets() throws RemoteException 
	{
		return markets;
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
