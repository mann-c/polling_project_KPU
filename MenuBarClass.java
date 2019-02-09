/**This class is used to create a menu bar for each JFrame object.*/
import javax.swing.*;
import java.awt.event.*;

public class MenuBarClass {
	
	//private field to hold menu bar object
	private JMenuBar mBar;
	
	//fields to hold menu objects
	private JMenu file;
	private JMenu getVote;
	
	/**Constructor that will build the menu bar*/
	public MenuBarClass()
	{
		//create a menu bar object
		mBar = new JMenuBar();
		
		//create menu objects and store them in the file and getVote fields
		file=new JMenu("File");
		getVote=new JMenu("Get Vote");
		
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
		
		item=new JMenuItem("Overall");
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

	/**Method that can be used to get the menu bar when creating a new JFrame
	 * object
	 * @return returns a JMenuBar object*/
	public JMenuBar getMenuBar()
	{
		//return statement that will pass the menu bar
		return mBar;
	}
	
	private class MenuBarActions implements ActionListener {
		
		//public method to handle all events thrown by buttons in gui
		public void actionPerformed(ActionEvent e)
		{
			//if statements to determine which button was clicked
			if(e.getActionCommand().equals("Reset"))
			{
				
			}
			
			else if (e.getActionCommand().equals("Vote"))
			{
				
			}
			
			else if (e.getActionCommand().equals("Save"))
			{
				
			}
			
			else if (e.getActionCommand().equals("Close"))
			{
				
			}
			
			else if (e.getActionCommand().equals("Total"))
			{
				
			}
			
			else if (e.getActionCommand().equals("Gender"))
			{
				
			}
			
			else if (e.getActionCommand().equals("Age"))
			{
				
			}
			
			else if (e.getActionCommand().equals("Ethnicity"))
			{
				
			}
		}

	}
}
