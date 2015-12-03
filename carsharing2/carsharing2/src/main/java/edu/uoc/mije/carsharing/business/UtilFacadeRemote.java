package edu.uoc.mije.carsharing.business;

import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;

import edu.uoc.mije.carsharing.integration.CityJPA;

@Remote
public interface UtilFacadeRemote {
	
	public void loadModel(int exampleId) throws Exception;

	public Collection<CityJPA> listCities();
	
}
