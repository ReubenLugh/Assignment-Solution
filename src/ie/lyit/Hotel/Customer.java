package ie.lyit.Hotel;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Customer extends Person implements Serializable{
	
	//instance variables
	private String emailAddress;
	private int number;
	
	private static int nextNumber;
	
	//default constructor
	public Customer() {
		super();
		emailAddress = null;
	}
	
	//initialisation constructor
	public Customer(String t, String fN,String sN, String address,
			String pNo, String email) {
		super(t,fN, sN, address,pNo);
		emailAddress = email;
	}
	
	//altered TOSTRING
	@Override
	public String toString() {
		return "#" + number+ ", "+ super.toString() +","+emailAddress;
	}
	
	//equals compares customer numbers(overrides object equals)
	@Override
	public boolean equals(Object obj) {
		Customer cObject;
		if (obj instanceof Customer)
			cObject = (Customer)obj;
		else
			return false;
		
		return (this.number==cObject.number);
		
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress()
	{
		return this.emailAddress;
	}
	public int getNumber()
	{
		return number;
	}
	
	//NEW METHODS
	
	//read method takes in customer details from the user
	public void read(){

		//creating textfield objects for optionpane
		JTextField txtCustomerNo = new JTextField();
		txtCustomerNo.setText("" + this.getNumber());
		txtCustomerNo.setEditable(false);
		JTextField txtTitle = new JTextField();
		txtTitle.requestFocus();
		JTextField txtFName = new JTextField();
		JTextField txtSName = new JTextField();
		JTextField txtAddress = new JTextField();
		JTextField txtPhoneNo = new JTextField();
		JTextField txtEmail = new JTextField();
	    
		//array of objects (strings and JTextFields) to display
		Object[] message = {
				"Customer Number: ", txtCustomerNo,
				"Title: ", txtTitle,
				"First Name: ", txtFName,
				"Surname: ", txtSName,
				"Address: ", txtAddress,
				"Phone Number: ", txtPhoneNo,
				"Email: ", txtEmail
				};
	      
		//generates default frame with specified fields and OK and Cancel buttons which prompts for customer details
		int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer details", JOptionPane.OK_CANCEL_OPTION);
		//if OK is chosen, take text from the textfields and use it to set the customer variables
		if (option == JOptionPane.OK_OPTION){
			setName(new Name(txtTitle.getText(), txtFName.getText(), txtSName.getText()));
		    setAddress(txtAddress.getText());
		    setPhoneNumber(txtPhoneNo.getText());
		    emailAddress = txtEmail.getText();
		}
	}
	
	//assign non repeating numbers
	public void assignCustomerNumber(ArrayList<Customer> customers)
	{
		//if array is empty, number is first number
		if(customers.isEmpty())
		{
			number = 1;
		}
		//else, check array for largest number and set customer number to largest number + 1
		else
		{
			for(Customer c : customers)
			{
				if(nextNumber < c.number)
				{
					nextNumber = c.number;
				}
			}
			number = nextNumber + 1;
		}
	}
}
