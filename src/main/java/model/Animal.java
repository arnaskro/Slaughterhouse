package model;

import java.util.ArrayList;

public class Animal 
{
	private float weight;
	private int animalId;
	private String type;
	
	public Animal() {
		this(0, 0, "?");
	}
	
	public Animal (float weight, int animalId, String type)
	{
		this.weight = weight;
		this.animalId = animalId;
		this.type = type;
	}

	public float getWeight() 
	{
		return weight;
	}

	public int getAnimalId()
	{
		return animalId;
	}

	public String getType()
	{
		return type;
	}
	
	
	
	

}
