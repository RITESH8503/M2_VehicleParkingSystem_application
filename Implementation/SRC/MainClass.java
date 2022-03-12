

package Implementation.SRC;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass implements Serializable {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] a) throws IOException {

		VehicleDetails parkingsys = new VehicleDetails();

	
		ArrayList<Vehicle> list1 =  deserializeList();
		int free_slots = 20;

		String selection = "Y";

		
		while (!selection.equals("X")) {
			System.out.println("~ Welcome to  Car Park ~" + "\nPress desired key to continue "
			+ "\n(A)Add Vehicle" + "\n(D) Delete vehicle" + "\n(P),print current list of vehicles"
			+ "\nStatistics of vehicles" + "\n(L)List parkings on a selected day" 
			+ "\nCharge for all parked" + "\n(X) to Exit");

			System.out.print("Enter a procedure : ");
			selection = sc.next().toUpperCase();
			Vehicle v = null;

			try {
				
				switch (selection) {
				
				case "A":
					
					if (!parkingsys.isFull()) {
						System.out.print("Enter vehicle ID : ");
						String s = sc.next();
						String id_plate = validateInput(s);

						
						if (parkingsys.containsID(id_plate)) {
							System.out.print("\nVehicle ID already exists\n");
							break;
						}

						System.out.print("Enter vehicle brand : ");
						String brand = validateInput(sc.next());

						selection = "1";
						boolean is_added = false;

						while (!is_added) {
							System.out.print("Enter vehicle type (1.Car, 2.HeavyVehicle, 3.bike): ");
							selection = sc.next();

							try {
							
								switch (selection) {
								case "1":
									System.out.print("Add Door Count: ");
									int number_of_door = sc.nextInt();
									System.out.print("Add Color: ");
									String color = sc.next();
									v = new Car(id_plate, brand, number_of_door, color);
									is_added = true;
									break;
								case "2":
									System.out.print("Add Cargo Volume: ");
									double cargovolume = sc.nextDouble();
									v = new HeavyVehicle (id_plate, brand, cargovolume);
									is_added = true;
									break;
								case "3":
									System.out.print("Add Engine Size: ");
									int enginesize = sc.nextInt();
									v = new Bike(id_plate, brand, enginesize);
									is_added = true;
									break;
								default:
									System.out.println("\nInvalid Vehicle Type! Re-enter Type\n");
									break;
								}
							} catch (Exception e) {
								System.out.println("Wrong Input! Re-enter Data");
								sc.nextLine();
							}
						}

						int temp = free_slots;

					
						free_slots = parkingsys.addVehicle(v);

					
						if (temp != free_slots) {
							
							list1.add(v);
						}

						if (free_slots >= 0) {
							
							System.out.println("Available slots " + free_slots + "\n");
						}
					} else {
						System.out.println("\nParking is full!\n"); 
					}
					break;
				
				case "D":
					if (!parkingsys.isEmpty()) {
						System.out.print("Enter Plate number : ");
						String id_plate1 = sc.next();
						v = parkingsys.deleteVehicle(id_plate1);
						if (v != null) {
							parkingsys.chargeForPark(v);
						}
					} else {
						System.out.println("\nPark is empty!\n"); 
					}
					break;
				
				case "P":
					parkingsys.printCurrentParked();
					break;
			
				case "S":
					parkingsys.printStatistics();
					break;
				
				case "L":
					System.out.print("Enter date and year (yyyy-mm-dd) : ");
					String date = sc.next();
					printVehicleList(list1, date);
					break;
				
				case "C":
					if (!parkingsys.isEmpty()) {
						parkingsys.chargeForAllParked();
					} else {
						System.out.println("\nPark is empty!\n");
					}
					break;
			
				case "X":
			
					serializeList(list1);
					System.out.print("Good bye!");
					break;
				default:
					System.out.println("\nInvalid Procedure! Try Again \n");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				sc.nextLine();
			}
		}
		sc.close();
	}


	private static void printVehicleList(ArrayList<Vehicle> list1, String filterDate) {
		if (!list1.isEmpty()) {
			boolean isPrinted = false;
			for (int x = 0; x < list1.size(); x++) {
				if (list1.get(x) != null) {
					if (list1.get(x).getVehicleEntryTime().getDate().equals(filterDate)) {
						isPrinted = true;
						list1.get(x).display();
					}
				}
			}

			if (!isPrinted) {
				System.out.println("\nNo parkings on " + filterDate + "\n");
			}

		} else {
			System.out.println("\nNo parkings on " + filterDate + "\n");
		}
	}


	public static String validateInput(String value) {
		boolean contain = true;
		boolean isValid = true;

		while (contain) { 

			char[] ch = value.toCharArray(); 
			for (char c : ch) { 
				isValid = (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')) || (c == '-')
						|| ((c >= '0') && (c <= '9')));
				
				if (!isValid) {
					System.out.print("Input contains other characters. Please re-enter : ");
					value = sc.next();
					break;
				} else {
					contain = false;
				}
			}
		}
		return value;
	}

	// write object to file
	public static void serializeList(ArrayList<Vehicle> list) throws IOException {
		
		FileOutputStream file = new FileOutputStream("data.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(file);
		oos.writeObject(list); 
		oos.flush();
		oos.close();
	}

	
	public static ArrayList<Vehicle> deserializeList() throws IOException {
		try {
			
			FileInputStream file = new FileInputStream("data.txt");
			
			ObjectInputStream ois = new ObjectInputStream(file);

	
			ArrayList<Vehicle> list = new ArrayList<Vehicle>();

			ois.close();
			return list; 
		} catch (Exception e) {
		
		}
		return new ArrayList<Vehicle>(); 
	}

}