package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

	/*Here we gona need to create GPS points that will bhe read from FILE and then converted
	 * by using referance tabel, tabel where elements that are saved and pointed (referred)
	 * to GPSPoint-object*/

public class GPSData {

	//creating object with tabell
	
	private GPSPoint[] gpspoints; //will be used to poke to referance tabel of GPSPoints
	protected int antall = 0;   
	/* ^ will be used for inserting and to hold controll over where in which positions, 
	 * indexes next point will be putted in*/
	//antall will after time give us locatiojn of each GPSPoint!
	
	
	/*this is a constructor for class, Konstructor willl create a tabel of GPS points
	with size given by "n" and given "antall" = 0, since first elements location will be 0*/
	public GPSData(int n) {

		antall = 0;
		gpspoints = new GPSPoint[n];
	
	}
	
	//here its told taht tabell msut return GPSPoint tabell with GPSPoitns from, GPSPoints method
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	/*Here we put GPS points "gpspoint" in gpspoints-tabel in position given by objectvariable antall*/
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false; 
		/*Method inckrements antall so that next point will be placed in next position
		*method will only insert "gpspoint" while there is place in array, 
		*which means that "antall" is shorter then gpspoints.length
		*returns true if all gpspints were placed as if loop tells and false if there'
		*wasnt enough place*/
		
		if(antall < gpspoints.length) { 
			gpspoints[antall] = gpspoint; //gpspoint calls to method (GPSPoint gpspoint) which goes back to object GPPoint array of "gsppoints"
			antall++;
			inserted = true;
		}
		return inserted;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		
		boolean gpspoints = insertGPS(GPSDataConverter.convert(time, latitude, longitude, elevation));
		return gpspoints;
	}


	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		for(int i = 0; i < gpspoints.length; i++) {
			GPSPoint gpspoint = gpspoints[i];
			System.out.print(gpspoint.toString());
		}
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
