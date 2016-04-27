package servers;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import model.*;
import servers.DatabaseServerInterface;

@SuppressWarnings("serial")
public class DatabaseServer extends UnicastRemoteObject implements DatabaseServerInterface
{

	protected DatabaseServer() throws RemoteException 
	{
		super();
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
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
			System.out.println("{DatabaseServer} Starting started...");
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
