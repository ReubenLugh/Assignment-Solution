package ie.lyit.Testers;

import ie.lyit.Hotel.Date;
import java.util.Scanner;

public class DateTester{
	public static void main(String[] args) {
	
		//SETTER
		Date d1 = new Date();
		System.out.println(d1); 
		
	    d1.setDay(4);
		d1.setMonth(6);
		d1.setYear(1941);
		
		System.out.println(d1); 

		//CONSTRUCTOR
		Date d2 = new Date(28, 12, 1982);
        System.out.println(d2);
        
        //CHECK FOR EQUALITY
		if(d1.equals(d2))
			System.out.println("Dates are equal.");
		else
			System.out.println("Dates are not equal.");
        
		//WRONG VALUES
		Date myDate1 = new Date();
		int day=32, month=13, year=-2009;
        boolean goodInput = false;
        Scanner kb = new Scanner(System.in);

        do 
        {
	        try 
	        {
	    		myDate1.setDay(day);
	    		myDate1.setMonth(month);
	    		myDate1.setYear(year);

				goodInput = true;
	        }
	        catch(IllegalArgumentException iEA)
	        {
	        	//ILLEGAL ARGUMENT PROMPTS NEW INPUTS
	        	System.out.println("Incorrect day, month or year.");
	        	
	        	System.out.print("Enter day [1-31]:");
	        	day = kb.nextInt();
	        	
	        	System.out.print("Enter month [1-12]:");
	        	month = kb.nextInt();
	        	
	        	System.out.print("Enter year [after 1900]:");
	        	year = kb.nextInt();
	        }
	        
        }while(!goodInput);
		System.out.println(d1);
      
		goodInput = false;
		day = 15;
		month = 33;
		year = 2017;
		
		do {
			try {
				Date myDate2 = new Date(day,month,year);
				System.out.println(myDate2);
				goodInput = true;
			}
			catch(IllegalArgumentException iEA){
	        	//ILLEGAL ARGUMENT PROMPTS NEW INPUTS
	        	System.out.println("Incorrect day, month or year.");
	        	
	        	System.out.print("Enter day [1-31]:");
	        	day = kb.nextInt();
	        	
	        	System.out.print("Enter month [1-12]:");
	        	month = kb.nextInt();
	        	
	        	System.out.print("Enter year [after 1900]:");
	        	year = kb.nextInt();			
			}
		}while(!goodInput);
		kb.close();		
		


   }
}
