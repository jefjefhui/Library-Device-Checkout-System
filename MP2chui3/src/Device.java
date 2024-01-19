// MP2, Chi Heng Jeffrey Hui, CIS 340, T Th 3:00 PM
public class Device {
//Create all fields 
private String SKU;
private String name;
private boolean status=true;
private static int count=0;
int index;

//Create a constructor with three parameters 
public Device(String SKU, String name, boolean status ) {
	this.SKU=SKU;
	this.name=name;
	count++;
	index=count;
	this.status=status;
}
//Create the getter for SKU
public String getSKU() {
	return SKU;
}
//Create the setter for SKU
public void setSKU(String inputSKU) {
	this.SKU=inputSKU;
}
//Create the getter for name 
public String getName() {
	return name;
}
//Create the setter for name 
public void setName(String inputName) {
	this.name=inputName;
}
//Create the getter for status
public String getStatus() {
	//If the boolean is true, return available.Otherwise, return to checked out. 
	if(status)
		return "Available";
	else
		return "Checked Out";
}
// Create setter for status 
public void setStatus(boolean s) {
	status=s;
}
//Create getter for count
public static int getCount() {
	return count;
}
//Create setter for count
public static void setCount(int count) {
	Device.count = count;
}
//Create getter for index 
public int getIndex() {
	return index;
}
//Create setter for index
public void setIndex(int index) {
	this.index = index;
}

}
