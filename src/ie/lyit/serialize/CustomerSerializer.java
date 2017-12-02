package ie.lyit.serialize;

import ie.lyit.Hotel.Customer;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CustomerSerializer {
	
	//filename for file
	final String FILENAME = "customers.bin";
	//arraylist of customers
	public ArrayList<Customer> customers;
	
	//default constructor
	public CustomerSerializer()
	{
		customers = new ArrayList<Customer>();
	}
	
	
	//add
	public void add()
	{
		//create customer object
		Customer customer = new Customer();
		//pass in array of customers, method will look for highest number and set customer number to largest + 1
		customer.assignCustomerNumber(customers);
		//read in customer details from user
		customer.read();
		//add to arraylist
		customers.add(customer);	
	}
	
	//view
	public Customer view()
	{
		//create scanner for keyboard
		Scanner kb = new Scanner(System.in);
		//variable for reading into
		int customerNo;
		
		//read in customer number of customer to view
		System.out.println("Enter Customer Number: ");
		customerNo = kb.nextInt();
		
		//for each customer in customers, if number that's read in equals number of current customer,
		//view customer details and return that customer
		for(Customer c : customers)
		{
			if(c.getNumber() == customerNo)
			{
				System.out.println(c);
				return c;
			}
		}
		//if customer isn't found, notify the user
		System.out.println("Customer not found.\n");
		return null;
	}
	
	//list
	public void list()
	{
		//if no customers to list, notify user
		if(customers.isEmpty())
		{
			System.out.println("No Customer Details Available.\n");
		}
		else
		{
			//for each customer in customers, show customer
			for(Customer c : customers)
			{
				System.out.println(c);
			}
		}

	}
	
	//edit
	public void edit()
	{
		//find customer by calling view() and assign the return to a temp variable
		Customer temp = view();
		
		//if customer found, store index to variable
		if(temp != null)
		{
			int index = customers.indexOf(temp);
		
			//read in new customer details
			temp.read();
			
			//set customer details at index to those of temp variable
			customers.set(index, temp);
		}
		
	}
	
	//delete
	public void delete()
	{
		//find customer and return with view()
		Customer temp = view();
		
		//if customer found, remove it from arraylist, notify user
		if(temp != null)
		{
			customers.remove(temp);
			System.out.println("Customer Deleted.\n");
		}
	}
	
	//Serialize
	public void serialize()
	{
		try{
			//create FOS to write to file at FILENAME
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			//create OOS to serialize objects and chain to FOS filestream
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			//serialize and writes customers array object to file
			os.writeObject(customers);
			//close the file
			os.close();
		}
		//if file not found, notify user
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store Customers.");
		}
		//display message of any other exception
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//Deserialize
	public void deserialize(){
		try{
			// Deserialize the ArrayList...
			//create FIS to read the file at FILENAME through
			FileInputStream fis = new FileInputStream(FILENAME);
			//OIS reads and deserializes data from the chained FIS
			ObjectInputStream is = new ObjectInputStream(fis);
			
			//sets the customers array's data to that of the OIS (Cast to type ArrayList<Customer> from generic object which readObject returns)
			//no instanceof operator required as arraylist is only data which was serialized
			customers = (ArrayList<Customer>)is.readObject();
			//closes the file
			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find file containing Customers.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}				
	}		
}
