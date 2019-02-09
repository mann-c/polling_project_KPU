/**This class contains all of the objects with the individual votes for 
 * each demographic group.*/
import java.io.*;

import javax.swing.JOptionPane;

public class OverallVote implements Serializable{
	
	//fields that hold the vote for each demographic group
	private DemographicVote youth;
	private DemographicVote workingAge;
	private DemographicVote elderly;
	private DemographicVote male;
	private DemographicVote female;
	private DemographicVote chinese;
	private DemographicVote caucasian;
	private DemographicVote asian;
	private DemographicVote other;
	
	//fields that holds whether the data has been saved
	private boolean saved;
	
	/**Constructor that will create the DemographicVote objects that will 
	 * hold the votes as they are cast*/
	public OverallVote()
	{
		//creates new objects and stores them in the fields
		youth=new DemographicVote();
		workingAge=new DemographicVote();
		elderly=new DemographicVote();
		male=new DemographicVote();
		female=new DemographicVote();
		chinese=new DemographicVote();
		caucasian=new DemographicVote();
		asian=new DemographicVote();
		other=new DemographicVote();
		saved=true;
	}
	
	/**Copy constructor that will create a copy of a OverallVote object that
	 * is passed as an argument.
	 * @param n the OverallVote object that is being copied*/
	public OverallVote(OverallVote n)
	{
		//these statements create a deep copy of the OverallVote object 
		youth=new DemographicVote(n.youth.getObject());
		workingAge=new DemographicVote(n.workingAge.getObject());
		elderly=new DemographicVote(n.elderly.getObject());
		male=new DemographicVote(n.male.getObject());
		female=new DemographicVote(n.female.getObject());
		chinese=new DemographicVote(n.chinese.getObject());
		caucasian=new DemographicVote(n.caucasian.getObject());
		asian=new DemographicVote(n.asian.getObject());
		other=new DemographicVote(n.other.getObject());
		saved=n.getSaved();
	}
	
	/**Method that allows the saved variable to be changed
	 * @param n the boolean value that will be stored in the saved variable*/
	public void changeSaved(boolean n)
	{
		saved=n;
	}
	
	/**Method that allows access to the saved variable*/
	public boolean getSaved()
	{
		return saved;
	}
	
	/**Method creates and returns a copy of the object.
	 * @return copy of current OverallVote object*/
	public OverallVote getObject()
	{
		//return statement that will return a deep copy of the object
		return new OverallVote(this);
	}

	/**Method that will add votes into the selected demographic choice
	 * @param n the number representing the demographic group
	 * @param m the number representing the candidate*/
	public void tallyVote(int n, int m)
	{
		
		//if else statements to determine which demographic group was chosen
		if(n==1)
		{
			if(m==1)
				youth.addVote(m);
			else if(m==2)
				youth.addVote(m);
			else if (m==3)
				youth.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else if(n==2)
		{
			//select the right candidate to who the vote was for
			//add vote to the candidate 
			if(m==1)
				workingAge.addVote(m);
			else if(m==2)
				workingAge.addVote(m);
			else if (m==3)
				workingAge.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else if(n==3)
		{
			//select the right candidate to who the vote was for
			//add vote to the candidate 
			if(m==1)
				elderly.addVote(m);
			else if(m==2)
				elderly.addVote(m);
			else if (m==3)
				elderly.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else if(n==4)
		{
			//select the right candidate to who the vote was for
			//add vote to the candidate 
			if(m==1)
				male.addVote(m);
			else if(m==2)
				male.addVote(m);
			else if (m==3)
				male.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else if(n==5)
		{
			//select the right candidate to who the vote was for
			//add vote to the candidate 
			if(m==1)
				female.addVote(m);
			else if(m==2)
				female.addVote(m);
			else if (m==3)
				female.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else if(n==6)
		{
			//select the right candidate to who the vote was for
			//add vote to the candidate 
			if(m==1)
				chinese.addVote(m);
			else if(m==2)
				chinese.addVote(m);
			else if (m==3)
				chinese.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else if(n==7)
		{
			//select the right candidate to who the vote was for
			//add vote to the candidate 
			if(m==1)
				caucasian.addVote(m);
			else if(m==2)
				caucasian.addVote(m);
			else if (m==3)
				caucasian.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else if(n==8)
		{
			//select the right candidate to who the vote was for
			//add vote to the candidate 
			if(m==1)
				asian.addVote(m);
			else if(m==2)
				asian.addVote(m);
			else if (m==3)
				asian.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else if(n==9)
		{
			//select the right candidate to who the vote was for
			//add vote to the candidate 
			if(m==1)
				other.addVote(m);
			else if(m==2)
				other.addVote(m);
			else if (m==3)
				other.addVote(m);
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
				System.exit(0);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
			System.exit(0);
		}
	}

	/**Method that will get the votes for the selected demographic group and candidate
	 * @param n the number representing each demographic and the candidate inside that demographic*/
	public int getVote(int n)
	{
		//if else if statements to select which candidate in which demographic group to return
		if(n==1)
			return youth.getLiberal();
		else if(n==2)
			return youth.getNDP();
		else if(n==3)
			return youth.getGreen();
		else if(n==4)
			return workingAge.getLiberal();
		else if(n==5)
			return workingAge.getNDP();
		else if(n==6)
			return workingAge.getGreen();
		else if(n==7)
			return elderly.getLiberal();
		else if(n==8)
			return elderly.getNDP();
		else if(n==9)
			return elderly.getGreen();
		else if(n==10)
			return male.getLiberal();
		else if(n==11)
			return male.getNDP();
		else if(n==12)
			return male.getGreen();
		else if(n==13)
			return female.getLiberal();
		else if(n==14)
			return female.getNDP();
		else if(n==15)
			return female.getGreen();
		else if(n==16)
			return chinese.getLiberal();
		else if(n==17)
			return chinese.getNDP();
		else if(n==18)
			return chinese.getGreen();
		else if(n==19)
			return caucasian.getLiberal();
		else if(n==20)
			return caucasian.getNDP();
		else if(n==21)
			return caucasian.getGreen();
		else if(n==22)
			return asian.getLiberal();
		else if(n==23)
			return asian.getNDP();
		else if(n==24)
			return asian.getGreen();
		else if(n==25)
			return other.getLiberal();
		else if(n==26)
			return other.getNDP();
		else if(n==27)
			return other.getGreen();
		else
		{
			JOptionPane.showMessageDialog(null, "Problem with Program. Progam terminating.");
			System.exit(0);
			return 0;
		}
		
	}
}
