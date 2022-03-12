/**
 * ritesh kumar
 */
package Implementation.SRC;

import java.io.Serializable;


public abstract class Vehicle implements Serializable {

	String vehicle_id;
	String vehicle_brand;
	EntryDateTime vehicleEntryTime;
	String type;

	
	public Vehicle() {
		super();
	}

	
	public Vehicle(String vehicle_id, String vehicle_brand) {
		super();
		this.vehicle_id = vehicle_id;
		this.vehicle_brand = vehicle_brand;
	}

	
	public void display() {
		System.out.println("Vehicle Id : " + vehicle_id);
		System.out.println("Vehicle type : " + type);
		System.out.println("Vehicle Brand : " + vehicle_brand);
		System.out.println("Vehicle entry time : " + vehicleEntryTime.getDateTime() + "\n");
	}


	public String getType() {
		return type;
	}

	
	public void setType(String type) {
		this.type = type;
	}

	
	public EntryDateTime getVehicleEntryTime() {
		return vehicleEntryTime;
	}

	
	public void setVehicleEntryTime(EntryDateTime vehicleEntryTime) {
		this.vehicleEntryTime = vehicleEntryTime;
	}

	
	public String getVehicleId() {
		return vehicle_id;
	}

	
	public void setVehicleId(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	
	public String getVehicleBrand() {
		return vehicle_brand;
	}

	
	public void setVehicleBrand(String vehicle_brand) {
		this.vehicle_brand = vehicle_brand;
	}

}