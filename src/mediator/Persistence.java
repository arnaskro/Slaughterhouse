package mediator;

import java.io.IOException;
import java.util.ArrayList;

import model.Animal;
import model.Market;
import model.Part;
import model.Tray;

public interface Persistence {

	   public ArrayList<Animal> loadAnimals() throws IOException;
	   public ArrayList<Part> loadParts() throws IOException;
	   public ArrayList<Tray> loadTrays() throws IOException;
	   public ArrayList<Market> loadMarkets() throws IOException;
}
