package ie.lyit.Hotel;

import java.io.*;

public abstract class Person implements Serializable {

	//instance variables
	protected Name name;
	protected String address;
	protected String phoneNumber;
	
	//default
	public Person() {
		name = new Name();
		address=null;
		phoneNumber=null;
	}
	//initialisation
	public Person(String t, String fN, String sN, String address, String phoneNumber) {
		name = new Name(t, fN, sN);
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return name + "," + address + "," + phoneNumber;
	}
	@Override
	public boolean equals(Object obj) {
		Person pObject;
		if (obj instanceof Person)
			pObject = (Person)obj;
		else
			return false;
		
		return (name.equals(pObject.name)&&
				address.equals(pObject.address)&&
				phoneNumber.equals(pObject.phoneNumber));
				
	}
	
	
	//GET AND SET
	public void setName(Name nameIn) {
		name = nameIn;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setAddress(String addressIn) {
		address = addressIn;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setPhoneNumber(String phoneNumberIn) {
		phoneNumber = phoneNumberIn;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
