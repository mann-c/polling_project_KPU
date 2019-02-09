/**This class creates the exit window when the close button is clicked or user tries to 
 * click the close button in the menu bar. Asks the user if the data should be saved.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ExitFrame extends JFrame
{
	//fields for panels 
	JPanel savePanel;
	JPanel noPanel;
	JPanel centerPanel;
	JPanel headerPanel;
	JPanel cancelPanel;
	
	//object that will hold the data 
	OverallVote voteData;
	
	//constants to hold the size of the window
	private final int WINDOW_WIDTH=300;
	private final int WINDOW_HEIGHT=100;
	
	/**Constructor that will create the window
	 * @param n the OverallVote object that contains all of the program data*/
	public ExitFrame(OverallVote n)
	{
		voteData=n;
		
		//set title and size of window
		setTitle("Exit Screen");
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		//create the panels
		savePanel = new JPanel();
		noPanel = new JPanel();
		centerPanel = new JPanel();
		headerPanel = new JPanel();
		cancelPanel = new JPanel();
		
		//set the layout for the panels and content pane
		setLayout(new BorderLayout());
		centerPanel.setLayout(new FlowLayout());
		
		//create the buttons and register them with the listener class
		JButton item = new JButton("Save");
		item.addActionListener(new ButtonListener());
		savePanel.add(item);
		
		item = new JButton("No");
		item.addActionListener(new ButtonListener());
		noPanel.add(item);
		
		item = new JButton("Cancel");
		item.addActionListener(new ButtonListener());
		cancelPanel.add(item);
		
		//create text field and add it to headerPanel
		JLabel item1 = new JLabel("Do you want to save data?");
		headerPanel.add(item1);
		
		//add panels
		centerPanel.add(savePanel);
		centerPanel.add(noPanel);
		centerPanel.add(cancelPanel);
		add(headerPanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		
		//remove decorations
		setUndecorated(true);
		
		//set window to visible
		setVisible(true);
		
	}

	/**Private inner listener class*/
	private class ButtonListener implements ActionListener
	{
		/**Method that will handle the event object fired when the buttons are clicked
		 * @param e object fired by button when event occurs*/
		public void actionPerformed(ActionEvent e) 
		{
			//if else if statements to determine which button was clicked
			if(e.getActionCommand().equals("Save"))
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
					
					//close the program
					System.exit(0);
					
				}
				catch (Exception f)
				{
					//message sent to user if exception is thrown while saving file
					JOptionPane.showMessageDialog(null, "Problem: Did not save.");
				}
			}	
			else if(e.getActionCommand().equals("No"))
			{
				//the program will close without saving
				System.exit(0);
			}
			else if(e.getActionCommand().equals("Cancel"))
			{
				//the program will go back to the home screen
				new HomeFrame(voteData);
				dispose();
			}
			else
			{
				//window will open saying there is a problem with the program
				JOptionPane.showMessageDialog(null, "Problem with program. Terminating program.");
				System.exit(0);
			}
		}
		
	}
}
