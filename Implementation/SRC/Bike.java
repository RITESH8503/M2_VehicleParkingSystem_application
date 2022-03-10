package Implementation.SRC;





public class Bike extends Vehicle {
	private int engineSize;

	//default constructor
	public Bike() {
		super();
	}

	//constructor
	public Bike(String vehicleId, String vehicleBrand, int engineSize) {
		super(vehicleId, vehicleBrand);
		this.engineSize = engineSize;
		this.type = "Bike";
	}

	//getter for engine size
	public int getEngineSize() {
		return engineSize;
	}

	//setter for engine size
	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

}