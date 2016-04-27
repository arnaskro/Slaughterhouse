package mediator;

import java.io.IOException;
import java.util.ArrayList;

import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;

public interface Persistence {

	   public Animal[] loadAnimals() throws IOException;
	   public Part[] loadParts() throws IOException;
	   public Tray[] loadTrays() throws IOException;
	   public Product[] loadProducts() throws IOException;
	   public Market[] loadMarkets() throws IOException;
	   public void saveAnimal(float weight, String type) throws IOException;
}
