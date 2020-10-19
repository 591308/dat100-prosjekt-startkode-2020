package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

	/*Here we gona need to create GPS points that will bhe read from FILE and then converted
	 * by using referance tabel, tabel where elements that are saved and pointed (referred)
	 * to GPSPoint-object*/

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		antall = 0;
		gpspoints = new GPSPoint[n];
	
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		
		if(antall <gpspoints.length) {
			gpspoints[antall] = gpspoint;
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
