package servers;

import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;

public interface Model
{
	public boolean addAnimal(float weight, String type);
	public boolean addPart(int animalId, String type, float weight);
	public boolean addTray(String type, float maxWeight);
	public boolean addToTray(int partId, int trayId);
	public boolean addMarket(String address);
	public boolean packTraysToProduct(String type, float weight, Tray trays[]);
	public void transportProductToMarket(int productId, int marketId);
	
	public Animal[] getAllAnimals();
	public Part[] getAllParts();
	public Tray[] getAllTrays();
	public Product[] getAllProducts();
	public Market[] getAllMarkets();
	
	public Animal[] getAllAnimalsByType(String type);
	public Animal getAnimalbyId(int animalId);
	public Part[] getAllPartsByType(String type);
	public Part[] getAllPartsByAnimal(int animalId);
	public Part getPart(int partId);
	public Tray[] getAllTraysByType(String type);
	public Tray getTrayById(int trayId);
	public Tray[] getTraysByAnimal(int animalId);
	public Product[] getProductsByType(String type);
	public Product getProductById(int productId);
	public Market getMarketByProduct(int productId);
	public String trackAnimal(int animalId);
	
	
}
