/**
 * TrackingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package dk.slaughterhouse.services.skeleton;

import java.rmi.RemoteException;

import dk.slaughterhouse.model.xsd.Animal;
import dk.slaughterhouse.servers.*;
import dk.slaughterhouse.services.*;

/**
 *  TrackingSkeleton java skeleton for the axisService
 */
public class TrackingSkeleton implements TrackingSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param getAnimals0
     * @return getAnimalsResponse1
     */
    public dk.slaughterhouse.services.GetAnimalsResponse getAnimals(
        dk.slaughterhouse.services.GetAnimals getAnimals0) {

    	System.out.println("{Tracking} getAnimals called");    	
    	
    	GetAnimalsResponse response = new GetAnimalsResponse();
    	
    	DatabaseServerInterface db = null;
    	dk.slaughterhouse.model.Animal[] animalsFromDB = null;
    	
    	try {
			db = new DatabaseServer();
			animalsFromDB = db.getAllAnimals();
			System.out.println("{Tracking} Connection to DB was successful!");
		} catch (RemoteException e) {
			System.out.println("{Tracking} ERROR! Connection to DB failed!");
			System.out.println(""+e.getMessage());
		} 
    	
    	Animal[] animals = new Animal[animalsFromDB.length];
    	Animal animal = null;
    	
    	for (int i = 0; i < animalsFromDB.length; i++) {
    		animal = new Animal();
    		
    		animal.setAnimalId(animalsFromDB[i].getAnimalId());
    		animal.setType(animalsFromDB[i].getType());
    		animal.setWeight(animalsFromDB[i].getWeight());
    		
    		animals[i] = animal;
    	}
    	
    	response.set_return(animals);
    	
    	return response;
    }

    /**
     * Auto generated method signature
     *
     * @param trackAnimal2
     * @return trackAnimalResponse3
     */
    public dk.slaughterhouse.services.TrackAnimalResponse trackAnimal(
        dk.slaughterhouse.services.TrackAnimal trackAnimal2) {
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#trackAnimal");
    }
}
