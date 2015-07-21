import java.util.ArrayList;
import java.util.List;



public class Processor {

	private static List<SignalStatistics> result=null;
	//Assuming console application for solution
	public static void main(String[] args) {

		//Assuming that the time taken by car after signal transition is 2 sec 
		//which will be there in any case
		//Hence taking just green signal time and red signal time for roads
		int greenTime=0;
		int redTime=0;
		int printTime=0;
		if(args.length!=3)
		{
			
		  System.out.println("No signal time/ Invalid signal time provided ");
		  System.exit(0);
		}
		if(args.length==3)
		{
			try{
			greenTime=Integer.valueOf(args[0]);
			redTime=Integer.valueOf(args[1]);
			printTime=Integer.valueOf(args[2]);
			if(greenTime==0 || redTime==0)
			{
				System.out.println("Signal time cannot be zero");
				System.exit(0);
			}
			}
			catch(Exception e)
			{
	          System.out.println("Invalid signal time provided ");
	          System.exit(0);	
			}
		}
		
		activateSignal(greenTime, redTime, printTime);
	}

	public static void activateSignal(int greenTime, int redTime, int printTime) {
		
		result=new ArrayList<SignalStatistics>();
		//Counter for each road direction		
		int north = 0;
		int south = 0;
		int east = 0;
		int west = 0;
	
		Signal snellRoadSignal=new Signal(greenTime,redTime,Constants.SNELLROAD);
		Signal weaverRoadSignal=new Signal(greenTime,redTime,Constants.WEAVERROAD);

	
		String startRoad = Constants.SNELLROAD;
        //To track previous road signal
		String previous = "";
        int sgreen=snellRoadSignal.getGreenTime();
        int sred=snellRoadSignal.getRedTime();
        int wgreen=weaverRoadSignal.getGreenTime();
        int wred=weaverRoadSignal.getRedTime();
	
		//Start of the signal when no one is red or green
		if (!snellRoadSignal.isGreenSignal() && !weaverRoadSignal.isGreenSignal())

		{
			if (startRoad == Constants.SNELLROAD) {
			
				snellRoadSignal.setGreenSignal(true);

			} else {

			  weaverRoadSignal.setGreenSignal(true);
			}
		}
         
		//Printing initial position
		display(north,south,east,west,0);
		result.add(new SignalStatistics(0, north, south, east, west));
		
		for (int i = 1; i <= printTime; i++) {

			if (previous == "") {
				if (snellRoadSignal.isGreenSignal()) {
					east++;
					west++;

					sgreen--;
					if (sgreen == 0) {
						snellRoadSignal.setGreenSignal(false);
						previous =snellRoadSignal.getRoadName() ;

					}

				} else {
					north++;
					south++;
					wgreen--;
					if (wgreen == 0) {
						weaverRoadSignal.setGreenSignal(false);
						previous =weaverRoadSignal.getRoadName();
					}
				}
			} else {

				north++;
				south++;
				east++;
				west++;

				if (snellRoadSignal.isGreenSignal()) {
					if (sgreen != greenTime) {
						north--;
						south--;
					}
					sgreen--;
					if (sgreen == 0) {
						snellRoadSignal.setGreenSignal(false);
						sred = redTime;
					}

				}

				if (!snellRoadSignal.isGreenSignal() && previous.equalsIgnoreCase(snellRoadSignal.getRoadName())) {

					if (sgreen == 0 && sred == 0) {
						weaverRoadSignal.setGreenSignal(true);
						sgreen = greenTime;
						sred = redTime;
						previous = weaverRoadSignal.getRoadName();
					}
					sred--;
				}

				if (weaverRoadSignal.isGreenSignal()) {
					if (wgreen != greenTime) {
						east--;
						west--;
					}
					wgreen--;
					if (wgreen == 0) {
						weaverRoadSignal.setGreenSignal(false);
						wred = redTime;
					}
				}

				if (!weaverRoadSignal.isGreenSignal() && previous.equalsIgnoreCase(weaverRoadSignal.getRoadName())) {

					if (wgreen == 0 && wred == 0) {
						snellRoadSignal.setGreenSignal(true);
						wgreen = greenTime;
						wred = redTime;
						previous = snellRoadSignal.getRoadName();
					}
					wred--;

				}

			}

			result.add(new SignalStatistics(i, north, south, east, west));
			display(north, south, east, west, i);

		}
	}

	private static void display(int north, int south, int east, int west, int i) {
		System.out.println(i + ": N = " + north + " ; S = " + south + " ; E = " + east + " ; W = "
				+ west);
	}
	
	public static SignalStatistics getSignalStatAtInstance(int index)
	{
		return result.get(index);
	}
}
