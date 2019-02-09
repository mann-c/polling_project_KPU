/**Class for window that opens when the user clicks on the reset button in the menu bar.
 * This window pops up to ensure that the user wants to clear the data.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResetFrame extends JFrame {
	//fields to hold the panels 
	private JPanel resetPanel;
	private JPanel noPanel;
	private JPanel centerPanel;
	private JPanel headerPanel;
	
	//field to hold the data object that will be passed into the constructor
	private OverallVote voteData;
	
	//constants that are used to set the size of the window
	private final int WINDOW_WIDTH=300;
	private final int WINDOW_HEIGHT=100;
	
	/**Constructor that will create the window.
	 * @param n the OverallVote object that holds all of the voting data*/
	public ResetFrame(OverallVote n)
	{
		voteData = n;
		
		//set the title and the size of the window
		setTitle("Reset");
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		//create the JPanels
		resetPanel = new JPanel();
		noPanel = new JPanel();
		centerPanel = new JPanel();
		headerPanel = new JPanel();
		
		//set the layout of the content pane and the JPanels
		setLayout(new BorderLayout());
		centerPanel.setLayout(new FlowLayout());
		
		//create buttons to show on the screen and register with a listener class
		JButton item;
		item = new JButton("Yes");
		item.addActionListener(new ButtonListener());
		resetPanel.add(item);
		
		item = new JButton("No");
		item.addActionListener(new ButtonListener());
		noPanel.add(item);
		
		//create text to add to the top of the window and add to headerPanel object
		JLabel item1 = new JLabel("Are you want to reset the program?");
		headerPanel.add(item1);
		
		//add the panels to appropriate panels and content panes
		centerPanel.add(resetPanel);
		centerPanel.add(noPanel);
		add(headerPanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		
		//remove the decorations from the window so the user has to click one of the buttons
		setUndecorated(true);
		
		//set the window to visible
		setVisible(true);
		
	}
	
	/**Private inner class that is registered to the buttons in the window*/
	private class ButtonListener implements ActionListener
	{
		/**Method that must be overriden to respond to the events fired by the program
		 * @param e the actionEvent object that is fired*/
		public void actionPerformed(ActionEvent e) 
		{
			//if statements to determine which button fired the event
			if(e.getActionCommand().equals("Yes"))
			{
				//reset the data in the OverallVote object
				voteData = new OverallVote();
				
				//change saved variable to false, because data was changed
				voteData.changeSaved(false);
				
				//send the program back to the home screen and close the current screen
				new HomeFrame(voteData);
				dispose();
			}
			else if(e.getActionCommand().equals("No"))
			{
				//send the program back to the home screen and close the current screen
				new HomeFrame(voteData);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Problem with program. Terminating program.");
				System.exit(0);
			}
			
		}
		
	}
}

