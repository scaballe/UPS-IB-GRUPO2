package edu.uoc.mije.carsharing.jsf.trip;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.uoc.mije.carsharing.business.trip.TripFacadeRemote;

@ManagedBean(name = "addpassenger")
@RequestScoped
public class RegisterInTripMBean {
	@EJB
	TripFacadeRemote tripRemote; 
	
	String passengerId;
	int tripId;
	
	public String getPassengerId() {
		return passengerId;
	}
	
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	
	public int gettripId() {
		return tripId;
	}
	public void setDriverId(int tripId) {
		this.tripId = tripId;
	}
	
	public String registerInTrip() throws Exception{
		register();
		return "listTripsView";
	}
	
	public void register() throws Exception{  
		//Properties props = System.getProperties();
		//Context ctx = new InitialContext(props);
		//showPetRemote = (CatalogFacadeRemote) ctx.lookup("java:app/PracticalCaseStudyJEE.jar/CatalogFacadeBean!ejb.CatalogFacadeRemote");
		tripRemote.registerInTrip(tripId, passengerId);
		
	}
	
}
