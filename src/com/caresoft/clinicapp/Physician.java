package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;


public class Physician extends User implements HIPAACompliantUser {

	private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
	}
	
    // TO DO: Implement HIPAACompliantUser!

	@Override
	public boolean assignPin(int pin) {
		if( (pin > 9999) || (pin < 1000)) {
			return false;
		}
		else {
			this.pin = pin;
			return true;
		}
	}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format("Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
        
    @Override
    public boolean accessAuthorized(Integer id) {
    	if(this.id != id) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    //get and set
    public Integer getId() {
    	return id;
    }
 
    public void setId(Integer id) {
    	this.id = id;
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;

	}
//	@Override
//	public boolean assignPin(int pin) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean accessAuthorized(Integer confirmedAuthID) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	
}
