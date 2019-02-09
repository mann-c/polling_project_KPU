/**Class that will be the first window that opens when program is opened.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HomeFrame extends JFrame {
	
	//fields to store panel and buttons and text
	private JPanel votePanel;
	private JPanel getVotePanel;
	private JButton total;
	private JButton age;
	private JButton gender;
	private JButton ethnicity;
	private JButton vote;
	private JMenuBar mBar;
	
	//constants to set window size
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 200;
	
	//field to hold the overall vote object which contains all of the voting data
	private OverallVote voteData;
	
	/**Constructor that will create the window with all the panels.*/
	public HomeFrame(OverallVote n)
	{
		//store the OverallVote object in the voteData variable
		voteData=n;
		
		//set the title of the window
		setTitle("Richmond North Centre");
		
		//set window size
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		//create two panel objects
		votePanel = new JPanel();
		getVotePanel = new JPanel();
		
		//set layout of content pane and getVotePanel 
		getVotePanel.setLayout(new GridLayout(2,2));
		setLayout(new FlowLayout());
		
		//set titled border for getVotePanel
		getVotePanel.setBorder(BorderFactory.createTitledBorder("Select Option to Get Vote:"));
		
		//create the buttons, register event listener and add to panels
		vote = new JButton("Vote");
		vote.addActionListener(new MenuBarActions());
		votePanel.add(vote);
		
		total = new JButton("Total");
		total.addActionListener(new MenuBarActions());
		getVotePanel.add(total);
		
		age = new JButton("Age");
		age.addActionListener(new MenuBarActions());
		getVotePanel.add(age);
		
		gender = new JButton("Gender");
		gender.addActionListener(new MenuBarActions());
		getVotePanel.add(gender);
		
		ethnicity = new JButton("Ethnicity");
		ethnicity.addActionListener(new MenuBarActions());
		getVotePanel.add(ethnicity);
		
		//add the two panels to the content pane
		add(getVotePanel);
		add(votePanel);
		
		//call MenuBar method to create a menu bar
		MenuBarClass();
		
		//add menu bar to the content pane
		setJMenuBar(mBar);
		
		//add listener to the close button
		addWindowListener(new WindowListen());
		
		//display window
		setVisible(true);
	}
	
	
	/**Main method to start the program*/
	public static void main(String[] args)
	{
		//create a new OverallVote object
		OverallVote vote;
				
		//try and catch block to catch any exceptions 
		try
		{
			//if statement to check if file exists
			//if file doesn't exist a new file will be created
			if(!(new File("VoteData.dat").isFile()))
			{
				//create a new file and save the OverallVote object into it
				FileOutputStream outStream = new FileOutputStream("VoteData.dat");
				ObjectOutputStream objectOutput = new ObjectOutputStream(outStream);
				vote=new OverallVote();
				objectOutput.writeObject(vote);
			}
			else
			{
				//open the file from the saved data
				FileInputStream inStream = new FileInputStream("VoteData.dat");
				ObjectInputStream objectInput = new ObjectInputStream(inStream);
				vote = (OverallVote) objectInput.readObject();
			}
		
			//create the home window, pass a copy of the OverallVote object
			new HomeFrame(vote.getObject());
		}
		catch (Exception e)
		{
			//message sent to user if exception is thrown while opening file
			JOptionPane.showMessageDialog(null, "Could not create or open file to save Data to. Program Terminated.");
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
		item.addActionListener(new MenuBarActions());
		file.add(item);
		
		item=new JMenuItem("Vote");
		item.addActionListener(new MenuBarActions());
		file.add(item);
		
		item=new JMenuItem("Save");
		item.addActionListener(new MenuBarActions());
		file.add(item);
		
		item=new JMenuItem("Close");
		item.addActionListener(new MenuBarActions());
		file.add(item);
		
		item=new JMenuItem("Total");
		item.addActionListener(new MenuBarActions());
		getVote.add(item);
		
		item=new JMenuItem("Gender");
		item.addActionListener(new MenuBarActions());
		getVote.add(item);
		
		item=new JMenuItem("Age");
		item.addActionListener(new MenuBarActions());
		getVote.add(item);
		
		item=new JMenuItem("Ethnicity");
		item.addActionListener(new MenuBarActions());
		getVote.add(item);
		
		
		//add the two menus to the menu bar
		mBar.add(file);
		mBar.add(getVote);
	}
	
	/**private class that will handle the events fired by the menu items*/
	private class MenuBarActions implements ActionListener {
		
		/**Method that is overridden from interface to handle event objects
		 * @param e the ActionEvent object that is fired from pressing menu items*/
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
			{
				System.exit(0);
			}
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


