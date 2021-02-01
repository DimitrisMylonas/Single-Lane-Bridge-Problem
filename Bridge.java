package Package;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {

	//Queue<Cars> Q = new LinkedList<Cars>();
	private boolean redflag = true;
	private boolean blueflag = false;
	private volatile int count_red = 0; 
	private volatile int count_blue = 0; 

	/*public void AddToQueue(Cars cars) {

		Q.add(cars);
	}*/

	public void CrossRedCar(String car_name, String type) {
		synchronized (this) {

			System.out.printf("%s trying to cross the bridge.\n", car_name);

			try {

				count_red++; 											
				System.out.printf("-------------------------Red: " + count_red + " Blue " + count_blue + "\n");

				while (!(redflag))
					wait(); 								
			} catch (InterruptedException e) {
			}

			System.out.printf("				%s crossing the bridge.\n", car_name);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}

			System.out.printf("					%s crossed the bridge.\n",
					car_name);

			if (count_blue + 3 <= count_red) { 							
				System.out.println("Red cars have priority!");				 
				blueflag = false; 											
				redflag = true; 									
			} else {
				redflag = false;
				blueflag = true;
			}
			notifyAll();
		}

	}

	public void CrossBlueCar(String car_name, String type) {
		synchronized (this) {

			System.out.printf("%s trying to cross the bridge.\n", car_name);

			try {

				count_blue++; 																	
				System.out.printf("-------------------------Red: " + count_red + " Blue " + count_blue + "\n");

				while (!(blueflag))
					wait();
			} catch (InterruptedException e) {
			}

			System.out.printf("				%s crossing the bridge.\n", car_name);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
			System.out.printf("					%s crossed the bridge.\n",
					car_name);

			if (count_blue >= count_red + 3) { 										
				System.out.println("Blue cars have priority!");
				redflag = false;
				blueflag = true;
			} else {
				redflag = true;
				blueflag = false;
			}

			notifyAll();
		}
	}
}
