package servers;

import java.rmi.Naming;
import java.rmi.RemoteException;

import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;

public class ApplicationServerClient implements ApplicationServerInterface
{
	private DatabaseServerInterface server;
	
	public ApplicationServerClient() throws RemoteException
	{
		super();
		try 
		{
			server = (DatabaseServerInterface) Naming.lookup("rmi://localhost:1099/SlaughterHouse");
			System.out.println(server.addAnimal(123, "Pig")); //TEST: Return false
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) throws RemoteException
	{
		ApplicationServerClient client = new ApplicationServerClient();
	}

	@Override
	public boolean addAnimal(float weight, String type)
	{
		try 
		{
			server.addAnimal(weight, type);
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addPart(int animalId, String type, float weight) 
	{
		try 
		{
			server.addPart(animalId, type, weight);
		} 
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addTray(String type, float maxWeight) 
	{
		try 
		{
			server.addtray(type, maxWeight);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addToTray(int partId, int trayId) 
	{
		try 
		{
			server.addToTray(partId, trayId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addMarket(String address) 
	{
		try 
		{
			server.addMarket(address);
		} 
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean packTraysToProduct(String type, float weight, Tray[] trays)
	{
		try 
		{
			server.packTraysToProduct(type, weight, trays);
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void transportProductToMarket(int productId, int marketId) 
	{
		try
		{
			server.transportTomarket(productId, marketId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}

	@Override
	public Animal[] getAllAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Part[] getAllParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tray[] getAllTrays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Market[] getAllMarkets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animal[] getAllAnimalsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animal getAnimalbyId(int animalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Part[] getAllPartsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Part[] getAllPartsByAnimal(int animalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Part getPart(int partId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tray[] getAllTraysByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tray getTrayById(int trayId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tray[] getTraysByAnimal(int animalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] getProductsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Market getMarketByProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String trackAnimal(int animalId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
