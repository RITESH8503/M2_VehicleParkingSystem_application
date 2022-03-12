package Implementation.SRC;





public interface CarParkManager {
	
	
	int addVehicle(Vehicle v);
	
	
	Vehicle deleteVehicle(String vehicleId);
	
	
	void printCurrentParked();
	
	
	void printStatistics();
	
	
	void chargeForAllParked();
	
	
	void chargeForPark(Vehicle vehicle);
	
}