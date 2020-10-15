package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		double ystep = MAPYSIZE / (Math.abs(maxlat - minlat));
		
		return ystep;
		
	}

	public void showRouteMap(int ybase) {

		double[] latitudes = GPSUtils.getLatitudes(gpspoints);
		double[] longitudes = GPSUtils.getLongitudes(gpspoints);
		
		int x, y;
			for(int i = 0; i < gpspoints.length; i++) {
				x = MARGIN + (int)((longitudes[i] - GPSUtils.findMin(longitudes)) * xstep());
				y = ybase - (int)((latitudes[i] - GPSUtils.findMin(latitudes)) * ystep());
				
			setColor(0,255,0);
			
			fillCircle(x, y, 5);
			
		}
		
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		drawString("Total time:          " + GPSUtils.formatTime(gpscomputer.totalTime()), TEXTDISTANCE, 50);
		drawString("Total distance:  " + GPSUtils.formatDouble(gpscomputer.totalDistance()/1000) + " km", TEXTDISTANCE, 70);
		drawString("Total elevation: " + GPSUtils.formatDouble(gpscomputer.totalElevation()) + " m", TEXTDISTANCE, 90);
		drawString("Max speed:       " + GPSUtils.formatDouble(gpscomputer.maxSpeed()) + " km/t", TEXTDISTANCE, 110);
		drawString("Average speed:   " + GPSUtils.formatDouble(gpscomputer.averageSpeed()) + " km/t", TEXTDISTANCE, 130);
		drawString("Energy:          " + GPSUtils.formatDouble(gpscomputer.kcal(80.0, gpscomputer.totalTime(),
												gpscomputer.averageSpeed() / 3.6)) + " kcal", TEXTDISTANCE, 150);
		
	}

}
