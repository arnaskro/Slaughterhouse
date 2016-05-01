package dk.slaughterhouse;

import java.rmi.RemoteException;

import dk.slaughterhouse.controller.ClientController;
import dk.slaughterhouse.controller.Controller;
import dk.slaughterhouse.servers.ApplicationServer;
import dk.slaughterhouse.servers.Model;
import dk.slaughterhouse.view.ClientConsole;
import dk.slaughterhouse.view.View;

public class ClientMain {

	public static void main(String[] args) {
		try {
			Model model = new ApplicationServer();
			View view = new ClientConsole();
			Controller controller = new ClientController(model, view);
			
			System.out.println("* Starting Client View *\n");
			view.start(controller);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
