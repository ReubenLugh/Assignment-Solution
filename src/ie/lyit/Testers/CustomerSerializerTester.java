package ie.lyit.Testers;

import ie.lyit.serialize.CustomerSerializer;
import ie.lyit.serialize.Menu;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		//create customerserializer object
		CustomerSerializer customerSerializer = new CustomerSerializer();
		
		//deserialize
		customerSerializer.deserialize();
		
		//create menu object
		Menu menu = new Menu();
		
		//do while option selected is not 6 (quit)
		do
		{
			//display the menu
			menu.display();
			//read option into variable
			menu.readOption();
			//switch calls method corresponding to option
			switch(menu.getOption())
			{
			case 1: customerSerializer.add();
					break;
			case 2: customerSerializer.view();
					break;
			case 3: customerSerializer.list();
					break;
			case 4: customerSerializer.edit();
					break;
			case 5: customerSerializer.delete();
					break;
			case 6: break;
			
			default:System.out.println("This option doesn't exist, please enter a valid option. [1-6]");
			}
		}while(menu.getOption() != 6);
		
		//Serialize
		customerSerializer.serialize();

	}

}
