package model;

import java.util.ArrayList;

public class Product 
{
	private ArrayList<Part> parts;
	private int productId;
	private String type;
	private float weight;
	
	public Product(ArrayList<Part> parts, int productId, String type, float weight) 
	{
		this.parts = parts;
		this.productId = productId;
		this.type = type;
		this.weight = weight;
	}

	public int getProductId() 
	{
		return productId;
	}

	public String getType() 
	{
		return type;
	}

	public float getWeight() 
	{
		return weight;
	}
	
	
	
	
}