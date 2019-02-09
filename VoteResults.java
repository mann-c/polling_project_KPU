/**Class will create window on which the voting results will be shown*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VoteResults extends JFrame {
	
	//fields for panel and label objects
	//generic names are used because each panel and label will represent
	//something different in each method in this class
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel heading;
	private JPanel results;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel header;
	
	//variable that will hold the OverallVote object
	private OverallVote voteData;
	
	
	/**Constructor, will store OverallVote object
	 * @param n OverallVote object that will be stored in the class*/
	public VoteResults(OverallVote n)
	{
		//store the data object 
		voteData=n;
		
		//set layout of content pane 
		setLayout(new BorderLayout());
		
		//create result panel and heading panel and put them into the content pane, set layout
		results=new JPanel();
		results.setLayout(new FlowLayout());
		add(results,BorderLayout.CENTER);
		
		heading=new JPanel();
		add(heading,BorderLayout.NORTH);
		
		//set window to visible
		setVisible(true);
	}

	/**Method that will create result window when total result is clicked*/
	public void total()
	{
		//variable initialized with total vote
		double total = voteData.getVote(13)+voteData.getVote(14)+voteData.getVote(15)+
				voteData.getVote(10)+voteData.getVote(11)+voteData.getVote(12);
		
		//variable with percentage of vote to liberal
		double liberal = (voteData.getVote(13)+voteData.getVote(10))/total;
		
		//variable with percentage of vote to ndp
		double ndp = (voteData.getVote(14)+voteData.getVote(11))/total;
		
		//variable with percentage of vote to green
		double green = (voteData.getVote(15)+voteData.getVote(12))/total;
		
		//create panels to store labels in 
		panel1=new JPanel();
		panel2=new JPanel();
		
		//set layout of panels
		panel1.setLayout(new GridLayout(3,1));
		panel2.setLayout(new GridLayout(3,1));
		
		//create borders for panels
		panel1.setBorder(BorderFactory.createTitledBorder("Candidates:"));
		panel2.setBorder(BorderFactory.createTitledBorder("Percentage of vote:"));
		
		//create labels 
		label1=new JLabel(String.format("%6.1f", liberal*100));
		label2=new JLabel(String.format("%6.1f", ndp*100));
		label3=new JLabel(String.format("%6.1f", green*100));
		header=new JLabel("Results of the poll:");
		label4=new JLabel("Teresa Wat (Liberal)");
		label5=new JLabel("Lyren Chiu (NDP)");
		label6=new JLabel("Ryan Marciniw (Green)");
		
		//add labels to panels
		heading.add(header);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		
		//set size for content pane
		setSize(500,200);
		
		//set dimensions for panels
		panel2.setPreferredSize(new Dimension(200,100));
		panel1.setPreferredSize(new Dimension(200,100));
		
		//add panels to the content pane
		results.add(panel1);
		results.add(panel2);
		
	}
	
	/**Method that will create the results window when prompted for results based on gender*/
	public void gender()
	{
		//variable initialized with total vote
		double totalFemale = voteData.getVote(13)+voteData.getVote(14)+voteData.getVote(15);
		double totalMale = voteData.getVote(10)+voteData.getVote(11)+voteData.getVote(12);	
		
		//variable with percentage of vote to liberal
		double liberalFemale = voteData.getVote(13)/totalFemale;
				
		//variable with percentage of vote to ndp
		double ndpFemale = voteData.getVote(14)/totalFemale;
				
		//variable with percentage of vote to green
		double greenFemale = voteData.getVote(15)/totalFemale;
				
		//variable with percentage of vote to liberal
		double liberalMale = voteData.getVote(10)/totalMale;
				
		//variable with percentage of vote to ndp
		double ndpMale = voteData.getVote(11)/totalMale;
				
		//variable with percentage of vote to green
		double greenMale = voteData.getVote(12)/totalMale;
				
		//create panels to store labels in 
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
				
		//set layout of panels
		panel1.setLayout(new GridLayout(3,1));
		panel2.setLayout(new GridLayout(3,1));
		panel3.setLayout(new GridLayout(3,1));
				
		//create borders for panels
		panel1.setBorder(BorderFactory.createTitledBorder("Candidates:"));
		panel2.setBorder(BorderFactory.createTitledBorder("Females (%)"));
			panel3.setBorder(BorderFactory.createTitledBorder("Males (%)"));
				
		//create labels 
		label1=new JLabel(String.format("%6.1f", liberalFemale*100));
		label2=new JLabel(String.format("%6.1f", ndpFemale*100));
		label3=new JLabel(String.format("%6.1f", greenFemale*100));
		header=new JLabel("Results of the poll broken down by gender:");
		label4=new JLabel("Teresa Wat (Liberal)");
		label5=new JLabel("Lyren Chiu (NDP)");
		label6=new JLabel("Ryan Marciniw (Green)");
		label7=new JLabel(String.format("%6.1f", liberalMale*100));
		label8=new JLabel(String.format("%6.1f", ndpMale*100));
		label9=new JLabel(String.format("%6.1f", greenMale*100));
				
		//add labels to panels
		heading.add(header);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel3.add(label7);
		panel3.add(label8);
		panel3.add(label9);
				
		//set size for content pane
		setSize(500,200);
				
		//set dimensions for panels
		panel2.setPreferredSize(new Dimension(100,100));
		panel1.setPreferredSize(new Dimension(200,100));
		panel3.setPreferredSize(new Dimension(100,100));
				
		//add panels to the content pane
		results.add(panel1);
		results.add(panel2);
		results.add(panel3);
	}
	
	/**Method that will create the results window when prompted for results based on age*/
	public void age()
	{
		//variable initialized with total vote
		double totalYouth = voteData.getVote(1)+voteData.getVote(2)+voteData.getVote(3);
		double totalWorkingAge = voteData.getVote(4)+voteData.getVote(5)+voteData.getVote(6);
		double totalElderly = voteData.getVote(7)+voteData.getVote(8)+voteData.getVote(9);	
		
		//variable with percentage of vote to liberal
		double liberalYouth = voteData.getVote(1)/totalYouth;
				
		//variable with percentage of vote to ndp
		double ndpYouth = voteData.getVote(2)/totalYouth;
				
		//variable with percentage of vote to green
		double greenYouth = voteData.getVote(3)/totalYouth;
				
		//variable with percentage of vote to liberal
		double liberalWorkingAge = voteData.getVote(4)/totalWorkingAge;
				
		//variable with percentage of vote to ndp
		double ndpWorkingAge = voteData.getVote(5)/totalWorkingAge;
				
		//variable with percentage of vote to green
		double greenWorkingAge = voteData.getVote(6)/totalWorkingAge;
		
		//variable with percentage of vote to liberal
		double liberalElderly = voteData.getVote(7)/totalElderly;
						
		//variable with percentage of vote to ndp
		double ndpElderly = voteData.getVote(8)/totalElderly;
						
		//variable with percentage of vote to green
		double greenElderly = voteData.getVote(9)/totalElderly;
				
		//create panels to store labels in 
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
				
		//set layout of panels
		panel1.setLayout(new GridLayout(3,1));
		panel2.setLayout(new GridLayout(3,1));
		panel3.setLayout(new GridLayout(3,1));
		panel4.setLayout(new GridLayout(3,1));
				
		//create borders for panels
		panel1.setBorder(BorderFactory.createTitledBorder("Candidates:"));
		panel2.setBorder(BorderFactory.createTitledBorder("18-35 (%)"));
		panel3.setBorder(BorderFactory.createTitledBorder("36-65 (%)"));
		panel4.setBorder(BorderFactory.createTitledBorder("65< (%)"));
				
		//create labels 
		label1=new JLabel(String.format("%6.1f", liberalYouth*100));
		label2=new JLabel(String.format("%6.1f", ndpYouth*100));
		label3=new JLabel(String.format("%6.1f", greenYouth*100));
		header=new JLabel("Results of the poll broken down by age:");
		label4=new JLabel("Teresa Wat (Liberal)");
		label5=new JLabel("Lyren Chiu (NDP)");
		label6=new JLabel("Ryan Marciniw (Green)");
		label7=new JLabel(String.format("%6.1f", liberalWorkingAge*100));
		label8=new JLabel(String.format("%6.1f", ndpWorkingAge*100));
		label9=new JLabel(String.format("%6.1f", greenWorkingAge*100));
		label10=new JLabel(String.format("%6.1f", liberalElderly*100));
		label11=new JLabel(String.format("%6.1f", ndpElderly*100));
		label12=new JLabel(String.format("%6.1f", greenElderly*100));
				
		//add labels to panels
		heading.add(header);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel3.add(label7);
		panel3.add(label8);
		panel3.add(label9);
		panel4.add(label10);
		panel4.add(label11);
		panel4.add(label12);
				
		//set size for content pane
		setSize(600,200);
				
		//set dimensions for panels
		panel2.setPreferredSize(new Dimension(100,100));
		panel1.setPreferredSize(new Dimension(200,100));
		panel3.setPreferredSize(new Dimension(100,100));
		panel4.setPreferredSize(new Dimension(100,100));
				
		//add panels to the content pane
		results.add(panel1);
		results.add(panel2);
		results.add(panel3);
		results.add(panel4);
	}
	
	/**Method that will create the results window when prompted for results based on ethnicity*/
	public void ethnicity()
	{
		//variable initialized with total vote
		double totalChinese = voteData.getVote(16)+voteData.getVote(17)+voteData.getVote(18);
		double totalAsian = voteData.getVote(22)+voteData.getVote(23)+voteData.getVote(24);
		double totalCaucasian = voteData.getVote(19)+voteData.getVote(20)+voteData.getVote(21);
		double totalOther = voteData.getVote(25)+voteData.getVote(26)+voteData.getVote(27);
		
		//variable with percentage of vote to liberal
		double liberalChinese = voteData.getVote(16)/totalChinese;
				
		//variable with percentage of vote to ndp
		double ndpChinese = voteData.getVote(17)/totalChinese;
				
		//variable with percentage of vote to green
		double greenChinese = voteData.getVote(18)/totalChinese;
				
		//variable with percentage of vote to liberal
		double liberalAsian = voteData.getVote(22)/totalAsian;
				
		//variable with percentage of vote to ndp
		double ndpAsian = voteData.getVote(23)/totalAsian;
				
		//variable with percentage of vote to green
		double greenAsian = voteData.getVote(24)/totalAsian;
		
		//variable with percentage of vote to liberal
		double liberalCaucasian = voteData.getVote(19)/totalCaucasian;
						
		//variable with percentage of vote to ndp
		double ndpCaucasian = voteData.getVote(20)/totalCaucasian;
						
		//variable with percentage of vote to green
		double greenCaucasian = voteData.getVote(21)/totalCaucasian;
		
		//variable with percentage of vote to liberal
		double liberalOther = voteData.getVote(25)/totalOther;
								
		//variable with percentage of vote to ndp
		double ndpOther = voteData.getVote(26)/totalOther;
								
		//variable with percentage of vote to green
		double greenOther = voteData.getVote(27)/totalOther;
				
		//create panels to store labels in 
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
				
		//set layout of panels
		panel1.setLayout(new GridLayout(3,1));
		panel2.setLayout(new GridLayout(3,1));
		panel3.setLayout(new GridLayout(3,1));
		panel4.setLayout(new GridLayout(3,1));
		panel5.setLayout(new GridLayout(3,1));
				
		//create borders for panels
		panel1.setBorder(BorderFactory.createTitledBorder("Candidates:"));
		panel2.setBorder(BorderFactory.createTitledBorder("Chinese (%)"));
		panel3.setBorder(BorderFactory.createTitledBorder("Asian (non-Chinese) (%)"));
		panel4.setBorder(BorderFactory.createTitledBorder("Caucasian (%)"));
		panel5.setBorder(BorderFactory.createTitledBorder("Other (%)"));
				
		//create labels 
		label1=new JLabel(String.format("%6.1f", liberalChinese*100));
		label2=new JLabel(String.format("%6.1f", ndpChinese*100));
		label3=new JLabel(String.format("%6.1f", greenChinese*100));
		header=new JLabel("Results of the poll broken down by ethnicity:");
		label4=new JLabel("Teresa Wat (Liberal)");
		label5=new JLabel("Lyren Chiu (NDP)");
		label6=new JLabel("Ryan Marciniw (Green)");
		label7=new JLabel(String.format("%6.1f", liberalAsian*100));
		label8=new JLabel(String.format("%6.1f", ndpAsian*100));
		label9=new JLabel(String.format("%6.1f", greenAsian*100));
		label10=new JLabel(String.format("%6.1f", liberalCaucasian*100));
		label11=new JLabel(String.format("%6.1f", ndpCaucasian*100));
		label12=new JLabel(String.format("%6.1f", greenCaucasian*100));
		label13=new JLabel(String.format("%6.1f", liberalOther*100));
		label14=new JLabel(String.format("%6.1f", ndpOther*100));
		label15=new JLabel(String.format("%6.1f", greenOther*100));
		
				
		//add labels to panels
		heading.add(header);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel3.add(label7);
		panel3.add(label8);
		panel3.add(label9);
		panel4.add(label10);
		panel4.add(label11);
		panel4.add(label12);
		panel5.add(label13);
		panel5.add(label14);
		panel5.add(label15);
				
		//set size for content pane
		setSize(850,200);
				
		//set dimensions for panels
		panel2.setPreferredSize(new Dimension(100,100));
		panel1.setPreferredSize(new Dimension(200,100));
		panel3.setPreferredSize(new Dimension(200,100));
		panel4.setPreferredSize(new Dimension(150,100));
		panel5.setPreferredSize(new Dimension(100,100));
				
		//add panels to the content pane
		results.add(panel1);
		results.add(panel2);
		results.add(panel3);
		results.add(panel4);
		results.add(panel5);
	}	
}
