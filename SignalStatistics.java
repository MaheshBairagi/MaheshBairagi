/**
 * 
 * @author mahesh
 *
 * This class stores the signal statistics
 */
public class SignalStatistics {

	private int second=0;
	private int northCount=0;
	private int southCount=0;
	private int eastCount=0;
	private int westCount=0;
	
	public SignalStatistics(int second,int ncount,int scount,int ecount,int wcount)
	{
		this.second=second;
		this.northCount=ncount;
		this.southCount=scount;
		this.eastCount=ecount;
		this.westCount=wcount;
	}

	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}

	/**
	 * @return the northCount
	 */
	public int getNorthCount() {
		return northCount;
	}

	/**
	 * @param northCount the northCount to set
	 */
	public void setNorthCount(int northCount) {
		this.northCount = northCount;
	}

	/**
	 * @return the southCount
	 */
	public int getSouthCount() {
		return southCount;
	}

	/**
	 * @param southCount the southCount to set
	 */
	public void setSouthCount(int southCount) {
		this.southCount = southCount;
	}

	/**
	 * @return the eastCount
	 */
	public int getEastCount() {
		return eastCount;
	}

	/**
	 * @param eastCount the eastCount to set
	 */
	public void setEastCount(int eastCount) {
		this.eastCount = eastCount;
	}

	/**
	 * @return the westCount
	 */
	public int getWestCount() {
		return westCount;
	}

	/**
	 * @param westCount the westCount to set
	 */
	public void setWestCount(int westCount) {
		this.westCount = westCount;
	}
	
	
}
