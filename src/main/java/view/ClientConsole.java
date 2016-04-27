package view;

import java.util.Scanner;

import controller.Controller;
import model.Animal;

public class ClientConsole implements View {
	private Scanner input;

	public ClientConsole() {
		input = new Scanner(System.in);
	}

	private int consoleMenu() {
		show("-------------- Client Menu -------------");
		show("\t1. Get all animals");
		show("\t0. quit");
		show("-----------------------------------------");
		show("* Type in your choice");
		System.out.print("> ");
		int choice= input.nextInt();

		return choice;
	}
	
	public void start(Controller controller) {
		int choice;
	      do
	      {
	         choice=consoleMenu();
	         show("\n");
	         
	         switch(choice)
	         {
	         case 1: 
	            controller.execute("getAllAnimals");
	            break;
	         default:
	             show("Shutting down");
	             choice=-1;
	         }
	         
	         show("\nPress any key to continue...");
	         try
	         {
	             System.in.read();
	         }  
	         catch(Exception e)
	         {}  
	         
	      } while(choice!=-1);
	}
	
	public void show(String message) {
		System.out.println(message);
	}

	@Override
	public void showAllAnimals(Animal[] animals) {
		String result = "All animals:";
		
		for (Animal animal : animals) {
			result += "\n[ID:" + animal.getAnimalId() + ", Type:" + animal.getType() + ", Weight:" + animal.getWeight() + "]";
		}
		
		show(result);
	}
	
}
