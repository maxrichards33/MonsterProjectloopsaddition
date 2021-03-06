package monster.controller;

import java.util.Scanner;

import monster.model.MarshmallowMonster;
import monster.view.MonsterDisplay;
import java.util.List;
import java.util.ArrayList;


public class MonsterController 
{
	private MonsterDisplay popup; 
	private List<MarshmallowMonster> monsterList;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}
	
	
	public void start()
	{
		boolean finished = true;
		int count = 0;
		//Below this is is a while loop!!
//		while(count < 100)
//		{  
//			popup.displayText("i am so neat!" + count);
//			count += 1;
//		}
//	
		//below this is a for loop!!
//		for(int loop = 0; loop < 15; loop += 1)
//		{
//			popup.displayText("I am looping " + (loop + 1) + " times out of 15");
//		}
		MarshmallowMonster sample = new MarshmallowMonster();
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("null", 8, 1, 4, true);
		popup.displayText(sample.toString());
		popup.displayText("null is very hungry. He is going to eat his own tenticle");
		realMonster.setTenticleAmount(5);
		//popup.displayText(sample.toString());
		popup.displayText(realMonster.toString());
		//System.out.println(sample);
		
		monsterList.add(realMonster);
		monsterList.add(sample);
		testList();
		
		
		
		interactWithTheMonster(realMonster);
	}
		
	private void testList()
	{
		for (int index = 0; index<monsterList.size(); index++)
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			String newName = popup.getResponse("What should my new name be??");
			currentMonster.setName(newName);
			popup.displayText(currentMonster.getName());
			
		}
		
		for(MarshmallowMonster current : monsterList)
		{
			popup.displayText(current.getName());
			String newName = popup.getResponse("what might my new name be??");
			current.setName(newName);
			popup.displayText(current.getName());
		}
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		popup.displayText(currentMonster.getName() + " wants to know what to eat next");
		popup.displayText(currentMonster.getName() + " suggestsrms, they have " + currentMonster.getArmCount());
		popup.displayText("How many do you want to eat?");
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();
		if(consumed < 0)
		//currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
		//System.out.println("Ok, now " + currentMonster.getName() + "has" +currentMonster.getArmCount() + "arms left.");
		//System.out.println("Ok, now " + currentMonster.getName() + "has" + currentMonster.getArmCount() + "arms left." );
		{
			popup.displayText("You cannot eat a negative amount silly human");
		}
		else if (consumed == 0)
		{
			popup.displayText("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
			popup.displayText("That is impossble - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			popup.displayText("How many do you want to eat?");		
			int specialAnswer = 0;
			String unconverted = popup.getResponse("How many do you want to eat??");
			
			while(!isValidInteger(unconverted))
			{
				popup.displayText(currentMonster.getName() + "Ah! I cant see!! What have you done silly human?");
				unconverted = popup.getResponse("How many arms???");
				//System
			}
			
			if(isValidInteger(unconverted))
			{
				specialAnswer = Integer.parseInt(unconverted);
			}
			
		}
	}
	
	private boolean isValidInteger(String input)
	{
		boolean valid = false;
		try 
		{
			Integer.parseInt(input);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("type in a number silly");
		}
		return valid;
	}
}