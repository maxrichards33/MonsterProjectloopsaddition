package monster.view;

import javax.swing.JOptionPane;

public class MonsterDisplay 
{
	
	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	public String getResponse(String questionAsked)
	{
		
		String Response = JOptionPane.showInputDialog(null, questionAsked)+"";
		return Response;
	}
	

}
