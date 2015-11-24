package edu.uoc.mije.carsharing.integration.util;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.EntityManager;

import edu.uoc.mije.carsharing.integration.CarJPA;
import edu.uoc.mije.carsharing.integration.CityJPA;
import edu.uoc.mije.carsharing.integration.DriverJPA;
import edu.uoc.mije.carsharing.integration.MessageJPA;
import edu.uoc.mije.carsharing.integration.TripJPA;

public class ExampleModel1 implements ExampleModel{

	public ExampleModel1() {
		// TODO Auto-generated constructor stub
	}

	public void loadExampleModel(EntityManager em){
		
		em.createQuery("delete from MessageJPA").executeUpdate();				
		em.createQuery("delete from TripJPA").executeUpdate();
		em.createQuery("delete from CarJPA").executeUpdate();
		em.createQuery("delete from UserJPA").executeUpdate();
		
		CityJPA madrid,barcelona,malaga;
		if( (madrid=em.find(CityJPA.class, "madrid")) == null){
			em.persist(madrid=new CityJPA("madrid"));
		}
		if( (barcelona=em.find(CityJPA.class, "barcelona")) == null){
			em.persist(barcelona=new CityJPA("barcelona"));
		}
		if( (malaga=em.find(CityJPA.class, "malaga")) == null){
			em.persist(malaga=new CityJPA("malaga"));
		}
		
		CarJPA car1 = new CarJPA("111", "brand", "model", "color");
		TripJPA trip1 = new TripJPA("trip1", madrid, "entrevias", Calendar.getInstance().getTime(), barcelona, "La Rambla", 4, 100);
		
		DriverJPA driver1 = new DriverJPA();
		driver1.setEmail("email");
		driver1.setName("name");
		driver1.setNif("nif");
		driver1.setPassword("password");
		driver1.setPhone("pone");
		driver1.setSurname("surname");
		
		driver1.addCar(car1);
		driver1.addTrip(trip1);
		
		em.persist(driver1);
	}

}
