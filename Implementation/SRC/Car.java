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
		//this.type = "Car";
	}

	//getter for doors
	public int getNumberOfDoors() {
		return number_of_doors;
	}

	//setter for doors
	public void setNumberOfDoors(int numberOfDoors) {
		this.number_of_doors = numberOfDoors;
	}

	//getter for color
	public String getCarColor() {
		return car_color;
	}

	//setter for color
	public void setCarColor(String carColor) {
		this.car_color = carColor;
	}

}