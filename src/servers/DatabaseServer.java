package servers;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;

public class DatabaseServer extends UnicastRemoteObject implements DatabaseServerInterface
{

	protected DatabaseServer() throws RemoteException 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addAnimal(float weight, String type) throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPart(int animalId, String type, float weight)
			throws RemoteException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addtray(String type, float maxWeight) throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addToTray(int partId, int trayId) throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMarket(String address) throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean packTraysToProduct(String type, float weight, Tray[] trays)
			throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void transportTomarket(int productId, int marketId)
			throws RemoteException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Animal[] getAllAnimals() throws RemoteException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Part[] getAllParts() throws RemoteException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tray[] getAllTrays() throws RemoteException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] getAllProducts() throws RemoteException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Market[] getAllMarkets() throws RemoteException 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) 
	{
		try
		{
			Registry reg = LocateRegistry.createRegistry(1099);
			DatabaseServerInterface rmiServer = new DatabaseServer();
			Naming.rebind("SlaughterHouse", rmiServer);
			System.out.println("Starting server...");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
