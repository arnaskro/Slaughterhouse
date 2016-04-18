package model;

import java.util.ArrayList;

public class Product 
{
	private ArrayList<Part> parts;
	private int productId;
	private String type;
	
	public Product(ArrayList<Part> parts, int productId, String type) 
	{
		this.parts = parts;
		this.productId = productId;
		this.type = type;
	}
	
	
	
}
