package view;

import controller.Controller;
import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;

public interface View {

	public void start(Controller controller);
	public void show(String message);

	public void showAllAnimals(Animal[] animals);
	public void showAllParts(Part[] parts);
	public void showAllTrays(Tray[] trays);
	public void showAllProducts(Product[] products);
	public void showAllMarkets(Market[] markets);
}
