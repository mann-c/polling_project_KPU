/**Class is going to be implemented to produce the voting screen.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VoteFrame extends JFrame{

	//fields for panels in the GUI
	private JPanel ageVote;
	private JPanel genderVote;
	private JPanel ethnicVote;
	private JPanel voteChoice;
	private JPanel votingPanel;
	private JPanel headerPanel;
	private JPanel submitPanel;
	
	//fields for the JRadioButtons
	private JRadioButton voteYouth;
	private JRadioButton voteWorkingAge;
	private JRadioButton voteElderly;
	private JRadioButton voteMale;
	private JRadioButton voteFemale;
	private JRadioButton voteChinese;
	private JRadioButton voteAsian;
	private JRadioButton voteCaucasian;
	private JRadioButton voteOther;
	private JRadioButton voteLiberal;
	private JRadioButton voteNDP;
	private JRadioButton voteGreen;
	
	//field to hold the menu bar
	private JMenuBar mBar;
	
	//the object will have the voting data
	private OverallVote voteData;
	
	//constants to hold the size of the window
	private final int WINDOW_WIDTH=600;
	private final int WINDOW_HEIGHT=250;
	
	/**Constructor to create the voting window.
	 * @param n holds OverallVote object is passed into the constructor*/
	public VoteFrame(OverallVote n)
	{
		//store the OverallVote object into the voteData variable
		voteData=n;
		
		//set title of name, size of window
		setTitle("Richmond North Centre: Voting");
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		//create the panels to hold the buttons and panels
		ageVote = new JPanel();
		genderVote = new JPanel();
		ethnicVote = new JPanel();
		voteChoice = new JPanel();
		votingPanel = new JPanel();
		headerPanel = new JPanel();
		submitPanel = new JPanel();
		
		//set layout for the panels and content pane
		ageVote.setLayout(new GridLayout(3,1));
		genderVote.setLayout(new GridLayout(2,1));
		ethnicVote.setLayout(new GridLayout(4,1));
		voteChoice.setLayout(new GridLayout(3,1));
		votingPanel.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		//set titles for the panels
		ageVote.setBorder(BorderFactory.createTitledBorder("Age:"));
		genderVote.setBorder(BorderFactory.createTitledBorder("Gender:"));
		ethnicVote.setBorder(BorderFactory.createTitledBorder("Ethnicity:"));
		voteChoice.setBorder(BorderFactory.createTitledBorder("Choice:"));
		
		//create radio buttons and add them to the appropriate panels
		voteYouth=new JRadioButton("18-35",true);
		ageVote.add(voteYouth);
		
		voteWorkingAge=new JRadioButton("36-65");
		ageVote.add(voteWorkingAge);
		
		voteElderly=new JRadioButton("65<");
		ageVote.add(voteElderly);
		
		voteFemale=new JRadioButton("Female",true);
		genderVote.add(voteFemale);
		
		voteMale=new JRadioButton("Male");
		genderVote.add(voteMale);
		
		voteChinese=new JRadioButton("Chinese",true);
		ethnicVote.add(voteChinese);
		
		voteAsian=new JRadioButton("Asian (non-Chinese)");
		ethnicVote.add(voteAsian);
		
		voteCaucasian=new JRadioButton("Caucasian");
		ethnicVote.add(voteCaucasian);
		
		voteOther=new JRadioButton("Other");
		ethnicVote.add(voteOther);
		
		voteLiberal=new JRadioButton("Teresa Wat (Liberal)",true);
		voteChoice.add(voteLiberal);
		
		voteNDP=new JRadioButton("Lyren Chiu (NDP)");
		voteChoice.add(voteNDP);
		
		voteGreen=new JRadioButton("Ryan Marciniw (Green)");
		voteChoice.add(voteGreen);
		
		//the buttons that are mutually exclusive will be grouped together
		ButtonGroup group1=new ButtonGroup();
		group1.add(voteYouth);
		group1.add(voteWorkingAge);
		group1.add(voteElderly);
		
		ButtonGroup group2=new ButtonGroup();
		group2.add(voteMale);
		group2.add(voteFemale);
		
		ButtonGroup group3=new ButtonGroup();
		group3.add(voteChinese);
		group3.add(voteAsian);
		group3.add(voteCaucasian);
		group3.add(voteOther);
		
		ButtonGroup group4=new ButtonGroup();
		group4.add(voteLiberal);
		group4.add(voteNDP);
		group4.add(voteGreen);
		
		//create JLabel object to describe the program in the window and
		//give instructions
		JLabel item1=new JLabel("Enter correct information about voter and then click submit.");
		headerPanel.add(item1);
		
		//create button to submit information
		//add button to panel and register event listener
		JButton item2=new JButton("Submit");
		item2.addActionListener(new SubmitListener());
		submitPanel.add(item2);
		
		//create menu bar by calling the MenuBarClass method and add it to content pane
		MenuBarClass();
		setJMenuBar(mBar);
		
		//add panels together and add them to the content pane
		votingPanel.add(ageVote);
		votingPanel.add(genderVote);
		votingPanel.add(ethnicVote);
		votingPanel.add(voteChoice);
		add(votingPanel, BorderLayout.CENTER);
		add(headerPanel, BorderLayout.NORTH);
		add(submitPanel, BorderLayout.SOUTH);
		
		//add listener to the close button
		addWindowListener(new WindowListen());
		
		//set the window to visible 
		setVisible(true);
	}
	
	/**Private inner class that will be used for action listener of submit button*/
	private class SubmitListener implements ActionListener
	{
		/**Method that must be overriden from ActionListener interface. Provides instructions 
		 * for what to do after submit button is clicked.*/
		public void actionPerformed(ActionEvent e)
		{
			//if else if structure to determine which age description was entered
			if(voteYouth.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(1,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(1,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(1,3);
			}
			else if(voteWorkingAge.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(2,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(2,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(2,3);
			}
			else if(voteElderly.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(3,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(3,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(3,3);
			}
			
			//if else if structure to determine which gender description was entered
			if(voteMale.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(4,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(4,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(4,3);
			}
			else if(voteFemale.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(5,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(5,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(5,3);
			}
			
			//if else if structure to determine which ethnicity description was entered
			if(voteChinese.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(6,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(6,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(6,3);
			}
			else if(voteAsian.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(8,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(8,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(8,3);
			}
			else if(voteCaucasian.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(7,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(7,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(7,3);
			}
			else if(voteOther.isSelected())
			{
				//if else if structure to determine who the person voted for and adding
				//the vote into the voteData object
				if(voteLiberal.isSelected())
					voteData.tallyVote(9,1);
				else if (voteNDP.isSelected())
					voteData.tallyVote(9,2);
				else if(voteGreen.isSelected())
					voteData.tallyVote(9,3);
			}
			else
			{
				//window will open saying there is a problem with the program
				JOptionPane.showMessageDialog(null, "Problem with program. Terminating program.");
				System.exit(0);
			}
			
			//sets boolean variable saved to false as changes have been made
			//thus when close is clicked it will ask if the user wants to save the data
			voteData.changeSaved(false);
			
			//create new HomeFrame window and close the current window
			dispose();
			new HomeFrame(voteData.getObject());
		}
	}
	
	/**Method that will create the menu bar*/
	public void MenuBarClass()
	{
		//create a menu bar object
		mBar = new JMenuBar();
		
		//create menu objects and store them in the file and getVote fields
		JMenu file=new JMenu("File");
		JMenu getVote=new JMenu("Get Vote");
		
		//create menu item objects and store them in the JMenuItem fields
		JMenuItem item;
		
		item=new JMenuItem("Reset");
		item.addActionListener(new MenuOptions());
		file.add(item);
		
		item=new JMenuItem("Vote");
		item.addActionListener(new MenuOptions());
		file.add(item);
		
		item=new JMenuItem("Save");
		item.addActionListener(new MenuOptions());
		file.add(item);
		
		item=new JMenuItem("Close");
		item.addActionListener(new MenuOptions());
		file.add(item);
		
		item=new JMenuItem("Total");
		item.addActionListener(new MenuOptions());
		getVote.add(item);
		
		item=new JMenuItem("Gender");
		item.addActionListener(new MenuOptions());
		getVote.add(item);
		
		item=new JMenuItem("Age");
		item.addActionListener(new MenuOptions());
		getVote.add(item);
		
		item=new JMenuItem("Ethnicity");
		item.addActionListener(new MenuOptions());
		getVote.add(item);
		
		
		//add the two menus to the menu bar
		mBar.add(file);
		mBar.add(getVote);
	}
	
	/**Private inner class that will be used as action listener for menu items*/
	private class MenuOptions implements ActionListener
	{
		/**Method that must be overriden from interface
		 * @param e accepts the action event that is created by clicking on a menu item*/
		public void actionPerformed(ActionEvent e)
		{
			//if statements to determine which button was clicked
			if(e.getActionCommand().equals("Reset"))
			{
				//call the ResetFrame to make sure the user wants to reset the program
				new ResetFrame(voteData);
				dispose();
			}
			
			else if (e.getActionCommand().equals("Vote"))
			{
				//close the home window and create a voting window
				//pass along the data object
				dispose();
				new VoteFrame(voteData.getObject());
			}
			
			else if (e.getActionCommand().equals("Save"))
			{
				//try catch statement needed to save file object
				try
				{
					//change boolean variable in voteData object to true showing that data has been saved
					voteData.changeSaved(true);
					
					//save the OverallVote object, therefore saving the data in the program
					FileOutputStream outStream = new FileOutputStream("VoteData.dat");
					ObjectOutputStream objectOutput = new ObjectOutputStream(outStream);
					objectOutput.writeObject(voteData);
					
				}
				catch (Exception f)
				{
					//message sent to user if exception is thrown while saving file
					JOptionPane.showMessageDialog(null, "Problem: Did not save.");
				}
				
			}
			
			else if (e.getActionCommand().equals("Close"))
			{
				//if else statement to determine whether the data has been changed
				if(voteData.getSaved())
					System.exit(0);
				else
				{	
					//close the current window and open the exit window
					new ExitFrame(voteData);
					dispose();
				}
			}
			
			else if (e.getActionCommand().equals("Total"))
			{
				//create results window with overall results
				VoteResults window=new VoteResults(voteData.getObject());
				window.total();
			}
			
			else if (e.getActionCommand().equals("Gender"))
			{
				//create results window with results based on gender
				VoteResults window=new VoteResults(voteData.getObject());
				window.gender();
			}
			
			else if (e.getActionCommand().equals("Age"))
			{
				//create results window with results based on age
				VoteResults window=new VoteResults(voteData.getObject());
				window.age();
			}
			
			else if (e.getActionCommand().equals("Ethnicity"))
			{
				//create results window with results based on age
				VoteResults window=new VoteResults(voteData.getObject());
				window.ethnicity();
			}
			else
			{
				//window will open saying there is a problem with the program
				JOptionPane.showMessageDialog(null, "Problem with program. Terminating program.");
				System.exit(0);
			}
		}
	}
	
	/**Private inner class that is registered to the close button*/
	private class WindowListen implements WindowListener
	{
		//only need to use the windowClosing method
		public void windowOpened(WindowEvent e) {}

		/**Method will call the exit screen when the close button is clicked
		 * @param e the object that is fired when the close button is clicked*/
		public void windowClosing(WindowEvent e) 
		{
			//if else statement to determine whether the data has been changed
			if(voteData.getSaved())
				System.exit(0);
			else
			{	
				//close the current window and open the exit window
				new ExitFrame(voteData);
				dispose();
			}
		}

		public void windowClosed(WindowEvent e) {}

		public void windowIconified(WindowEvent e) {}

		public void windowDeiconified(WindowEvent e) {}

		public void windowActivated(WindowEvent e) {}

		public void windowDeactivated(WindowEvent e) {}
		}
}
