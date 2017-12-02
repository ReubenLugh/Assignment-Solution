package ie.lyit.serialize;

import java.util.Scanner;

public class Menu {
	
   private int option;
   
   //display menu options
   public void display(){
     System.out.println("1. Add Customer");
	 System.out.println("2. View Customer Details");
	 System.out.println("3. List All Customers");
	 System.out.println("4. Edit Customer Details");
	 System.out.println("5. Delete Customer");
	 System.out.println("6. Quit");		
   }
	
   public void readOption(){
	  //create scanner object to read in user option
      Scanner kb = new Scanner(System.in);
      
      //prompt input and assign it to option
  	  System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
   	  option=kb.nextInt();
   }
	//return option				
	public int getOption(){
	   return option;
	}	
}