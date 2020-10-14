package Package;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	static int numofcars;

	public static void main(String[] args) {

		Bridge bridge = new Bridge();
		int count1 = 1;
		int count2 = 1;
		int i = 0;
		ArrayList<Cars> cars = new ArrayList<Cars>(); 

		Scanner in = new Scanner(System.in);
		System.out.println("give number: "); 
		numofcars = in.nextInt(); 

		for (i = 0; i < numofcars; i++) {
			int rand = (int) (Math.random() * 1000); 
														

			if (rand % 2 == 0) {
				Cars car1 = new Cars(bridge, "blue");
				car1.setname("Blue car " + count1 + ":");
				cars.add(car1); 
				count1++; 

			} else if (rand % 2 == 1) {
				Cars car2 = new Cars(bridge, "red");
				car2.setname("Red car " + count2 + ":");
				cars.add(car2);
				count2++;

			}
		}

		for (i = 0; i < cars.size(); i++) { 
			cars.get(i).start(); 
		}

	}
}
