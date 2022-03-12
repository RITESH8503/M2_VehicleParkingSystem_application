/**
 * 
 */


package Implementation.SRC;



public class HeavyVehicle extends Vehicle  {

	private double cargovolume;

	public HeavyVehicle() {
		super();
	}


	public HeavyVehicle(String vehicleId, String vehicleBrand, double cargovolume) {
		super(vehicleId, vehicleBrand);
		this.cargovolume = cargovolume;
		this.type = "HeavyVehicle";
	}
	
	
	public double getCargovolume() {
		return cargovolume;
	}

	
	public void setCargovolume(double cargovolume) {
		this.cargovolume = cargovolume;
	}

}