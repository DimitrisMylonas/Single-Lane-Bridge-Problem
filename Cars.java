package Package;

public class Cars extends Thread {

	private String type;
	private Bridge bridge;
	private String name;

	public Cars(Bridge bridge, String type) {

		this.type = type;
		this.bridge = bridge;
	}

	public void run() {
		bridge.AddToQueue(this);
		if(type == "red") {
		bridge.CrossRedCar(this.name, this.type);
		}
		else if (type == "blue") {
		bridge.CrossBlueCar(this.name, this.type);
		}
	}

	public void setname(String name) {
		this.name = name;
	}

	public Bridge getBridge() {
		return bridge;
	}

	public void setBridge(Bridge bridge) {
		this.bridge = bridge;
	}

}