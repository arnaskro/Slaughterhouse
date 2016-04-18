package model;

import java.util.ArrayList;

public class Tray 
{
	private String type;
	private int trayId;
	private float maxWeight;
	private ArrayList<Part> partsId;
	
	public Tray(String type, int trayId, float maxWeight)
	{
		this.type = type;
		this.trayId = trayId;
		this.maxWeight = maxWeight;
	}
	
}
