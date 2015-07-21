import java.util.List;


public class Signal {
	
	boolean greenSignal=false;
	int greenTime=0;
	int redTime=0;
	String roadName=null;
	List<Directions> directions;
	
	public Signal (int greenTime,int redTime,String name,List<Directions> directions)
	{
		this.greenTime=greenTime;
		this.redTime=redTime;
		this.roadName=name;
		this.directions=directions;
	}


	/**
	 * @return the directions
	 */
	public List<Directions> getDirections() {
		return this.directions;
	}


	/**
	 * @return the roadName
	 */
	public String getRoadName() {
		return roadName;
	}


	/**
	 * @return the greenSignal
	 */
	public boolean isGreenSignal() {
		return greenSignal;
	}


	/**
	 * @param greenSignal the greenSignal to set
	 */
	public void setGreenSignal(boolean greenSignal) {
		this.greenSignal = greenSignal;
	}


	/**
	 * @return the greenTime
	 */
	public int getGreenTime() {
		return greenTime;
	}


	/**
	 * @param greenTime the greenTime to set
	 */
	public void setGreenTime(int greenTime) {
		this.greenTime = greenTime;
	}


	/**
	 * @return the redTime
	 */
	public int getRedTime() {
		return redTime;
	}


	/**
	 * @param redTime the redTime to set
	 */
	public void setRedTime(int redTime) {
		this.redTime = redTime;
	}
	

}
