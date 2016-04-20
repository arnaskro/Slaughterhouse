package model;

import java.util.ArrayList;

public class Tray {
	private String type;
	private int trayId;
	private float maxWeight;
	private ArrayList<Part> partsId;
	
	public Tray(String type, int trayId, float maxWeight, ArrayList<Part> partsId) {
		this.type = type;
		this.trayId = trayId;
		this.maxWeight = maxWeight;
		this.partsId = partsId;
	}

	public Tray(String type, int trayId, float maxWeight) {
		this.type = type;
		this.trayId = trayId;
		this.maxWeight = maxWeight;
	}

	public String getType() {
		return this.type;
	}

	public int getTrayId() {
		return this.trayId;
	}

	public float getMaxWeight() {
		return this.maxWeight;
	}
	
	public ArrayList<Part> getParts(){
		return this.partsId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTrayId(int trayId) {

		this.trayId = trayId;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

}
