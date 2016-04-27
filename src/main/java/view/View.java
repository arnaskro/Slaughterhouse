package view;

import controller.Controller;
import model.Animal;

public interface View {

	public void start(Controller controller);
	public void show(String message);
	
	public void showAllAnimals(Animal[] animals);
}
