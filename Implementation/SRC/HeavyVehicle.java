/**
 * 
 */


package Implementation.SRC;



public class HeavyVehicle extends Vehicle  {

	private double cargoVolume;

	public HeavyVehicle() {
		super();
	}

	//constructor
	public HeavyVehicle(String vehicleId, String vehicleBrand, double cargoVolume) {
		super(vehicleId, vehicleBrand);
		this.cargoVolume = cargoVolume;
		this.type = "HeavyVehicle";
	}
	
	//getter for cargo volume
	public double getCargoVolume() {
		return cargoVolume;
	}

	//setter for cargo volume
	public void setCargoVolume(double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

}