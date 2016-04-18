package model;

import java.util.ArrayList;

public class Market 
{
	private int marketId;
	private String address;
	private  ArrayList<Product> product;
	
	public Market(int marketId, String address, ArrayList<Product> product)
	{
		this.marketId = marketId;
		this.address = address;
		this.product = product;
	}
	
	
}
