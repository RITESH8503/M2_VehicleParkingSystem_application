package Implementation.SRC;




public class Car extends Vehicle {

	private int number_of_doors;
	private String car_color;

	public Car() {
		super();
	}

	
	public Car(String vehicle_id, String vehicle_brand, int number_of_doors, String car_color) {
		super(vehicle_id, vehicle_brand);
		this.number_of_doors = number_of_doors;
		this.car_color = car_color;
		this.type = "Car";
	}

	public int getNumberOfDoors() {
		return number_of_doors;
	}


	public void setNumberOfDoors(int numberOfDoors) {
		this.number_of_doors = numberOfDoors;
	}

	
	public String getCarColor() {
		return car_color;
	}

	
	public void setCarColor(String carColor) {
		this.car_color = carColor;
	}

}