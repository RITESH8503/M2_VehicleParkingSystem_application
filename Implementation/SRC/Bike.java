package Implementation.SRC;





public class Bike extends Vehicle {
	private int engineSize;

	
	public Bike() {
		super();
	}

	
	public Bike(String vehicleId, String vehicleBrand, int engineSize) {
		super(vehicleId, vehicleBrand);
		this.engineSize = engineSize;
		this.type = "Bike";
	}


	public int getEngineSize() {
		return engineSize;
	}

	
	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

}