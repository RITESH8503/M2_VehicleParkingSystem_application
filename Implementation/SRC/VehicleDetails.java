package Implementation.SRC;





import java.util.ArrayList;

public class VehicleDetails implements CarParkManager {

	
	private static int total_slots = 50;
	Vehicle[] slots;

	
	private static ArrayList<Vehicle> list = new ArrayList<Vehicle>(total_slots);

	
	private int occupied_slots = 0;

	
	public VehicleDetails() {
		
		slots = new Vehicle[total_slots];
	}


	
	public int addVehicle(Vehicle v) {
		int slot = getFreeSlotForParking(v.getType());
		if (slot == -2) {
			System.out.println("\nSorry, not enough space");
			
			return total_slots - occupied_slots;
		} else if (slot == -1) { 
			System.out.println("\nPark is Full");
			return 0;
		} else { 
			v.setVehicleEntryTime(new EntryDateTime());
			slots[slot] = v;
			list.add(v);

		
			System.out.println("\r" + v.getType() + " is Successfully Added");
			
			return total_slots - occupied_slots;
		}

	}


	
	public Vehicle deleteVehicle(String vehicleId) {
		for (int x = 0; x < slots.length; x++) {
			if (slots[x] != null) {
				if (slots[x].getVehicleId().equals(vehicleId)) {
					System.out.println("\nVehicle Id " + slots[x].getVehicleId() + " removed!");
					System.out.println("Vehicle Type " + slots[x].getType() + " removed!");
				
					if (slots[x].getType().equals("HeavyVehicle")) {
						occupied_slots = occupied_slots - 2;
					} else { 
						occupied_slots--;
					}

					
					for (int y = 0; y < list.size(); y++) {
						if (list.get(y).getVehicleId().equals(vehicleId)) {
							list.remove(y);
							break;
						}
					}
					
					Vehicle v = slots[x];
					v = slots[x];
					slots[x] = null;
					return v;
				}
			}
		}
		
		System.out.println("\nVehicle not found!\n");
		return null;
	}

	
	public int getFreeSlotForParking(String type) {
		for (int x = 0; x < slots.length; x++) {
			
			if (slots[x] == null) {
				if (x == 0) { 
					switch (type) {
					case "Car":
					case "Bike":
						occupied_slots++;
						return x;
					case "HeavyVehicle":
						if (slots[x + 1] == null) {
							occupied_slots += 2;
							return x;
						} else {
							return -2;
						}
					}
				} else { 
					if (slots[x - 1] != null) {
						
						if (!slots[x - 1].getType().equals("HeavyVehicle")) {
							switch (type) {
							case "Car":
							case "Bike":
								occupied_slots++;
								return x;
							case "HeavyVehicle":
								if (x + 1 < total_slots && slots[x + 1] == null) {
									occupied_slots += 2;
									return x;
								} else {
									return -2; 
								}
							}
						} 
					} else { 
						switch (type) {
						case "Car":
						case "Bike":
							occupied_slots++;
							return x;
						case "HeavyVehicle":
							if ((x + 1) < (total_slots - 1)) {
								if (slots[x + 1] == null) {
									occupied_slots += 2;
									return x;
								}
							} else {
								return -2; 
							}
						}
					}
				}
			}
		}
		return -1; 
	}

	
	
	public void printCurrentParked() {
		if (!isEmpty()) {
			System.out.println("\nCurrently parked vehicles\n");

			for (int x = list.size() - 1; x >= 0; x--) {
				if (list.get(x) != null) {
					
					Vehicle v = list.get(x);
					
					v.display();
				}
			}
		} else { 
			System.out.println("\nNo Vehicles are parked!\n");
		}
	}

	
	
	public void printStatistics() {
		if (!isEmpty()) {
			int car = 0;
			int HeavyVehicle = 0;
			int Bike = 0;
			int total = 0;

			
			for (int x = 0; x < slots.length; x++) {
				if (slots[x] != null) {
					if (slots[x].getType().equals("Car")) {
						car++;
					}
					if (slots[x].getType().equals("HeavyVehicle")) {
						HeavyVehicle++;
					}
					if (slots[x].getType().equals("Bike")) {
						Bike++;
					}
					total++;
				}
			}

			
			double carP = ((double) car / (double) total) * 100.0;
			double HeavyVehicleP = ((double) HeavyVehicle / (double) total) * 100.0;
			double BikeP = ((double) Bike / (double) total) * 100.0;

			
			Vehicle longestParked = list.get(0);
		
			Vehicle lastParked = list.get(list.size() - 1);

			System.out.println("\nCurrent parking percentages");
			System.out.println("Cars : " + (int) carP + "%");
			System.out.println("HeavyVehicles : " + (int) HeavyVehicleP + "%");
			System.out.println("Bikes : " + (int) BikeP + "%\n");

			System.out.println("Longest parked vehicle");
			longestParked.display();

			System.out.println("Last Parked vehicle");
			lastParked.display();
		} else { 
			System.out.println("\nNo Vehicles are parked!\n");
		}
	}



	public void chargeForAllParked() {
		for (int x = 0; x < slots.length; x++) {
			if (slots[x] != null) {
				System.out.println(slots[x].getVehicleId() + " " + slots[x].getType());
				chargeForPark(slots[x]);
			}
		}
	}

	
	
	public void chargeForPark(Vehicle vehicle) {
		EntryDateTime currTime = new EntryDateTime();
		long hours = currTime.getEpochTimeHours() - vehicle.getVehicleEntryTime().getEpochTimeHours();
		System.out.print("No of hours parked " + hours);

		int parking_charge = 0;

		
		if (hours == 0) {
			parking_charge = 100;
		} else if (hours <= 3) {
			parking_charge = 100 * (int) hours;
		} else { 
			parking_charge = 500 + ((int) hours - 3);
		}

		System.out.println("\nCharge is rupees" + parking_charge +"\n");

	}

	
	public boolean isEmpty() {
		int emptyCount = 0;

		for (int x = 0; x < slots.length; x++) {
			if (slots[x] == null) {
				emptyCount++; 
			}
		}
		return emptyCount == slots.length;
	}

	
	public boolean isFull() {
		int fullcount = 0;

		for (int x = 0; x < slots.length; x++) {
			if (slots[x] == null) {
			
			} else {
				if (slots[x].getType().equals("HeavyVehicle")) {
					fullcount += 2;
				} else {
					fullcount++; 
				}
			}
		}
		return fullcount == slots.length;
	}

	
	public boolean contains_id(String id_plate) {
		for (int x = 0; x < slots.length; x++) {
			if (slots[x] != null) {
				if (slots[x].getVehicleId().equals(id_plate)) {
					return true;
				}
			}
		}
		return false;
	}

}

