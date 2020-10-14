package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];
		
		for(double i = 0; i < latitudes.length; i++) {
			latitudes[(int) i] = gpspoints[(int) i].getLatitude();
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];
		
		for(double i = 0; i < longitudes.length; i++) {
			longitudes[(int) i] = gpspoints[(int) i].getLongitude();
		}
		return longitudes;
	}



	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
        latitude2 = gpspoint2.getLatitude();
        longitude1 = gpspoint1.getLongitude();
        longitude2 = gpspoint2.getLongitude();
        
        double deltaLat = toRadians(latitude2 - latitude1);
        double deltaLong = toRadians(longitude2 - longitude1);
        
        double a = pow(sin(deltaLat/2.0),2) + cos(toRadians(latitude1)) * cos(toRadians(latitude2)) 
                * pow(sin(deltaLong/2.0),2);
        double c = 2.0 * atan2(sqrt(a), sqrt(1-a));
        d = R * c;
        return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		double timer = secs / 3600;
		
		double km = (distance(gpspoint1, gpspoint2)/1000.0);
		double speed = km / timer;

        
        return speed;
	}

	public static String formatTime(int secs) {
		
		return String.format("  %02d:%02d:%02d", secs/3600, (secs % 3600) / 60, secs % 60);

	}

	public static String formatDouble(double d) {

		double str =  ( d / 100.0 ) * 100.0 ;

		String avrundet = String.format("      %.2f", str); 
		
		return avrundet;
	}
}
