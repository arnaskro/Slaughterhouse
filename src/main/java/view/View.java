package view;

import controller.Controller;

public interface View {

	public void start(Controller controller);
	public void show(String message);
}
