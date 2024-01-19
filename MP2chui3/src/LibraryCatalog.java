// MP2, Chi Heng Jeffrey Hui, CIS 340, T Th 3:00 PM
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCatalog {
	
	static Scanner scanner = new Scanner (System.in );
	//Declare and instantiate ArrayList
	private ArrayList<Device> listOfDevice=new ArrayList<Device>();
	public static void main(String[] args) {
		//Create object reference
		 LibraryCatalog newLibraryCatalog=new LibraryCatalog();
		 //Call all required methods 
		newLibraryCatalog.loadSampleData();
		newLibraryCatalog.displayMenu();
		
		 
			

	}
	
	//Create the displayMenu method
	private  void displayMenu() {
		//Declare variable
		 String input;
	//Use the do while loop, since it will at least execute once	
	do {
		//Print out all the content in the menu
		System.out.print("\t\tLibrary Device Checkout System\n\n");
		System.out.print("\n1. List Devices by Title\n");
		System.out.print("2. Add New Devices\n");
		System.out.print("3. Edit Device Information\n");
		System.out.print("4. Search by Device Name\n");
		System.out.print("5. Check Out Devices\n");
		System.out.print("6. Check In Devices\n");
		System.out.print("7. Exit\n\n\n");
		System.out.print("Select menu options 1-7:");
		//Ask for input
		input=scanner.nextLine();
		// Use the if else statement to lead the program to the appropriate method 
		if (input.equals("1")) {
			System.out.print("\n\n\n\n\n\n");
			listDevicesByTitle();
			pressEnterToContinue();
		}else if (input.equals("2")) {
			addNewDevices();
			pressEnterToContinue();
		}else if(input.equals("3")) {
			editDeviceInformation();
			pressEnterToContinue();
		}else if (input.equals("4")) {
			searchByDeviceName();
			pressEnterToContinue();
		}else if(input.equals("5")) {
			checkOutDevices();
			pressEnterToContinue();
		}else if(input.equals("6")) {
			checkInDevices();
			pressEnterToContinue();
		}
		
	//The code in line 63 is the condition, it will terminate when we type 7	
	}while(!input.equals("7"));
	//The code below will show after the do while loop ends
	System.out.print("Good bye!");
	}
	//Create the loadSampleData method. This method will add all the sample data to the ArrayList
	private void loadSampleData() {
		
	 //Add all the sample to the ArrayList
	 Device newDevice1=new Device("6757A","Apple 9.7-inch iPad Pro",true);
	 listOfDevice.add(newDevice1);
	 Device newDevice2=new Device("93P51B","Amazon Kindle Fire Kids Edition",true);
	 listOfDevice.add(newDevice2);
	 Device newDevice3=new Device("10N8C","LeapFrog Epic Learning Tablet",true);
	 listOfDevice.add(newDevice3);
	 Device newDevice4=new Device("85U2O","Amazon Kindle Fire HD 8",false);
	 listOfDevice.add(newDevice4);
	 Device newDevice5=new Device("91H2D","HP Envy 8 Note",true);
	 listOfDevice.add(newDevice5);
	 
	}
	//Create the listDevicesByTitle method
	private void listDevicesByTitle() {
		//Print out the header and the column title 
		System.out.print("\t\t\tLibrary Device Checkout System - List\n\n\n");
		System.out.print("#       SKU  Name\n");
		//Loop through each device in the listOfDevice and print all of them out
		for (Device D:listOfDevice) {
			System.out.printf("%d  %8s  %-33s  %20s",D.getIndex(),D.getSKU(),D.getName(),D.getStatus() );
			System.out.println();
			System.out.println();
			
		}
		
	}
	//Create the addNewDevices method 
	private void addNewDevices() {
		//Declare required variables 
		String Sku;
		String name;
	//Print out the header 
		System.out.print("\n\n\n\n\t\t\t Library Device Checkout System - Add New Device");
		//Ask user to enter SKU
		System.out.print("\n\n\nSku:");
		Sku=scanner.nextLine().toUpperCase();
		//Ask user to enter name 
		System.out.print("Name:");
		name=scanner.nextLine();
		//Declare and instantiate new object
		Device newDevice=new Device(Sku,name,true);
		//Add the new object to the ArrayList 
		listOfDevice.add(newDevice);
		System.out.printf("\nAdded %s to Catalog.",name);
		
		
	}
	//Create editDeviceInformation method 
	private void editDeviceInformation() {
		//Declare all variables 
		int input;
		String SKU;
		String name;
		System.out.println();
		System.out.println();
		System.out.println();
		//Call the listDevicesByTitle method 
		listDevicesByTitle();
		//Ask the user to enter device number to edit 
		System.out.printf("Enter Device number to edit (1-%d):",listOfDevice.size());
		input=Integer.parseInt(scanner.nextLine());
		//need to minus one, since array starts from 0
		int index=input-1;
		//if the input is smaller or equal to the size of the ArrayList and input is larger than 0, perform the statement in the brackets 
		if(input<=listOfDevice.size() && input>0 ) {
		//Ask for SKU
			System.out.print("Sku:");
		SKU=scanner.nextLine();
		//Ask for name 
		System.out.print("Name:");
		name=scanner.nextLine();
		//Get the actual position in the  arrayList
		Device tmp = listOfDevice.get(index);
		//Use the setter to set SKU and name 
		tmp.setSKU(SKU);
		tmp.setName(name);
		//Overwrite the content in specific index 
		listOfDevice.set(index, tmp);
		System.out.print("\nDevice information updated.\n");
		}
		//Otherwise, print out "Invalid Number"
		else {
			System.out.print("Invalid Number\n");
		}
		
	}
	//Create searchByDeviceName method 
	private void searchByDeviceName() {
		//Declare required variable 
		String input;
		//Print out header 
		System.out.print("\n\n\n\n\t\t\tLibrary Device Checkout System- Search\n\n");
		//Ask user to enter device to search for 
		System.out.print("Enter Device to search for:");
		input=scanner.nextLine();
		System.out.printf("\nListing for '%s'\n",input);
		//Print out column header 
		System.out.print("#  SKU          Name");
		//Using for each loop to loop through the arrayList.
		//Use the if statement and contains to check if the name in the arrayList contains the input
		for(Device D:listOfDevice) {
			if(D.getName().toLowerCase().contains(input.toLowerCase())) {
				System.out.printf("\n%d %s %38s\n",D.getIndex(),D.getSKU(),D.getName());
			}
		}
		
		
	}
	//Create the checkOutDevices method 
	private void checkOutDevices() {
		//Create required variable
		int i;
		//Print out the header 
		System.out.print("\n\n\t\t\tLibrary Device Checkout System - Check Out Device\n\n\n");
		System.out.print("Available Devices\n\n");
		System.out.print("#   SKU      Name\n");
		//Use the for each loop to loop through every device in listOfDevice 
		//if the status equal to available, print out their contents 
		for(Device D:listOfDevice) {
			if(D.getStatus().equals("Available") ) {
				System.out.printf("%d   %s   %-30s\n", D.getIndex(),D.getSKU(),D.getName());
			
}
		}
		//Ask user to enter device number 
		System.out.print("\nEnter device number:");
			i=Integer.parseInt(scanner.nextLine());
			//Set flag equals to true 
			boolean flag=true;
			//Use the for each loop to loop through every device in listOfDevice 
			for (Device D:listOfDevice) {
				//If the status not equals to available and the index is within the range of the ArrayList,change the status to false and print out "This device is already checked out" 
				if(!D.getStatus().equals("Available") && D.getIndex()==i) {
					D.setStatus(false);
					flag=false;
					System.out.print("This device is already checked out.\n");
				//Statement in line 208 will execute when the first if statement doesn't execute. If the status equals to available and the index is within range, set the status and flag to false and print out "device checked out".	
				}else if (D.getStatus().equals("Available") && D.getIndex()==i) {
					D.setStatus(false);
					flag=false;
					System.out.print("Device Checked Out.\n");
					
				}
				
			}
			//If flag is true, which means the device number is not in the ArrayList, so print out "Invalid Number" 
			if(flag==true)
			{
				System.out.print("Invalid Number\n");
			}
			
		}
		
	
		
		
		
	//Create checkInDevices method 
	private void checkInDevices() {
		//Declare required variable 
		int i;
		//Print out the header 
		System.out.print("\n\n\n\t\t\tLibrary Device Checkin System - Check In Device\n\n\n");
		System.out.print("Checked Out Devices\n\n");
		System.out.print("#   SKU                Name\n");
		//Use the for each loop to loop through everything in listOfDevice 
		for(Device D:listOfDevice) {
			//If the status is equal to "Checked Out",print out all of its contents  
			if(D.getStatus().equals("Checked Out") ) {
				System.out.printf("%d %-20s %s\n", D.getIndex(),D.getSKU(),D.getName());
			
}
		}
		//Ask the user to enter device number 
		System.out.print("\nEnter device number:");
			i=Integer.parseInt(scanner.nextLine());
			//Set flag to true 
			boolean flag=true;
			//Use the for each loop to loop through everything in listOfDevice 
			for (Device D:listOfDevice) {
				//If the status is equal to "Checked Out" and the index is within range, set status to true and flag to false.Afterwards, print out "Device Checked In".
				if(D.getStatus().equals("Checked Out") && D.getIndex()==i) {
					D.setStatus(true);
					flag=false;
					System.out.print("Device Checked In.\n");
				}
				//If the first if statement doesn't execute, it will go to the else if statement. If the status is not equal to checked out and the index is within the ArrayList range, set the status to true and flag to false.Afterwards,print out "This device is not checked out".
				else if (!D.getStatus().equals("Checked Out") && D.getIndex()==i) {
					D.setStatus(true);
					flag=false;
					System.out.print("This device is not checked out.\n");
				}
				
			}
			//If the flag equals to true, it means the device number is not in the ArrayList, so print out "Invalid Number".
			if(flag==true)
			{
				System.out.print("Invalid Number\n");
			}
			
	}
	//Create pressEnterToContinue method 
	private void pressEnterToContinue() {
		System.out.print("\nPress Enter to continue...");
		scanner.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	

}
