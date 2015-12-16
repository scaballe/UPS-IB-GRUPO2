package edu.uoc.mije.carsharing.jsf;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.uoc.mije.carsharing.business.comms.CommunicationFacadeRemote;
import edu.uoc.mije.carsharing.integration.MessageJPA;

@ManagedBean(name = "showTripComments")
@RequestScoped
public class ShowTripCommentsBean {

	@EJB
	CommunicationFacadeRemote communicationRemote; 
	
	public ShowTripCommentsBean(){
		
	}
	
	
	
	Collection<MessageJPA> messages;
	public Collection<MessageJPA> getMessages() {
		return messages;
	}
	
	public String doAction(int tripId){
	
		Logger.getLogger("carsharing").info("ShowTripComments "+tripId);
		
		
		messages = communicationRemote.showTripComments(tripId);
		
		return "showTripComments";
	}
	
}
