package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	@SuppressWarnings("unused")
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	/*Data has been read from file in form of String need to convert from string
	 Integers and Double data types, implement a method that represents time into seconds,
	 using substring method to extract numbers as indexes from string
	 (from 11 to and with 13, 11 < x <= 13) etc.)*/
	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		hr = Integer.parseInt(timestr.substring(11,13));
		min = Integer.parseInt(timestr.substring(14,16));
		sec = Integer.parseInt(timestr.substring(17,19));
		
		secs = hr * 60 * 60 + min * 60 + sec;
		
		return secs;
	}

	/*In this method we take String from file that represents time, latitude, 
	 longitude and height. Then converts them into Integer and Double data types, 
	 then creates GPSPoint-object with the same data. Method return and poke too 
	 GPSPoint-object that have been created */
	
	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		
		int sec = toSeconds(timeStr); //toSeconds because time must be in seconds!
		double dobLat = Double.parseDouble(latitudeStr);
		double dobLong = Double.parseDouble(longitudeStr);
		double dobEle = Double.parseDouble(elevationStr);
		
		/*creating new object, calling it gpspoint and point our 
		new variables into that object*/
		
		GPSPoint gpspoint = new GPSPoint(sec, dobLat, dobLong, dobEle);
		return gpspoint;
		
	    
	}
	
}
