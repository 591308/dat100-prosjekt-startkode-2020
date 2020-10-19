package no.hvl.dat100ptc.oppgave1;

public class GPSPoint {

	
	/* Private variables can only be accessed within the same class(However, 
	it is possible to access them if we provide public get and set methods*/
	
	//Object variables, create an object
	private int time;
	private double latitude;
	private double longitude;
	private double elevation;

	public GPSPoint(int time, double latitude, double longitude, double elevation) {
		
	/*constructor, is special method that is called when and object is instantiated.
	The purpose of constructor is to initialize the object of a class while the 
	purpose of a method is to perform a task by executing java code. 
	Constructors cannot be abstract, final, static and synchronised while methods can be
	Constructors do not have return types while methods do*/	
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
	}
	
	/*The get method returns the variable value, and the set method sets the value.
	 The most common use of the this keyword is to eliminate the confusion between
	 class attributes and parameters with the same name 
	 (because a class attribute is shadowed by a method or constructor parameter).*/
	public int getTime() {
		
		return time;
		
	}

	public void setTime(int time) {
			
		this.time = time;
		
	}

	public double getLatitude() {
		
		return latitude;
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
		
	}

	public double getLongitude() {
		
		return longitude;
		
	}

	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
	
	}

	public double getElevation() {
		
		return elevation;
		
	}

	public void setElevation(double elevation) {
		
		this.elevation = elevation;
		
	}
	
	//Return String representation of GPSPoint-object
	public  String toString() {
		
		return time + " (" + latitude + "," + longitude + ") " + elevation + "\n";
		
	}
}
