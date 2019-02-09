/**This class is designed to store the vote of different demographic groups.
 * The class will tally the votes then return them when the program asks.*/
import java.io.*;

public class DemographicVote implements Serializable{
	
	//private fields to hold the votes for each party
	private int liberal;
	private int ndp;
	private int green;
	
	/**The constructor will initialize the votes for each private field to zero*/
	public DemographicVote()
	{
		//initialize the votes to zero
		liberal=0;
		ndp=0;
		green=0;
	}
	
	/**Copy constructor will create a copy of the object in new memory space*/
	public DemographicVote(DemographicVote n)
	{
		//copy all three private fields from object that was passed
		liberal=n.getLiberal();
		ndp=n.getNDP();
		green=n.getGreen();
		
	}
	/**This method will add the votes to a particular political party*/
	public void addVote(int n)
	{
		//if statements to determine where vote will be placed
		if(n==1)
			liberal++;
		if(n==2)
			ndp++;
		if(n==3)
			green++;
	}
	
	/**This method will return the number of votes the liberal party received
	 * from the particular demographic group
	 * @return the number of liberal votes for particular demographic*/
	public int getLiberal()
	{
		return liberal;
	}
	
	/**This method will return the number of votes the ndp party received
	 * from the particular demographic group
	 *  @return the number of ndp votes for particular demographic*/
	public int getNDP()
	{
		return ndp;
	}
	
	/**This method will return the number of votes the green party received
	 * from the particular demographic group
	 *  @return the number of green votes for particular demographic*/
	public int getGreen()
	{
		return green;
	}
	
	/**This method will return a copy of the current object
	 * @return copy of current DemographicVote object*/
	public DemographicVote getObject()
	{
		//statement that will return a copy of the data in this object
		return new DemographicVote(this);
	}

}
