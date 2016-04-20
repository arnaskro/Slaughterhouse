package model;

public class Part 
{	
	private int animalId;
	private String type; //what part from the animal
	private int partId;  //ID to that part
	private float weight;
	
	public Part(int animalId, String type, int partId, float weight)
	{
		this.animalId = animalId; // or Animal.getAnimalId();
		this.type = type;
		this.partId = partId;
		this.weight = weight;		
	}

	public float getWeight() 
	{
		return weight;
	}

	public int getPartId()
	{
		return partId;
	}

	public String getType() 
	{
		return type;
	}	
}
