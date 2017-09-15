package monster.controller;

import monster.model.MarshmallowMonster;


public class MonsterController 
{
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("null", 8, 1, 4, true);
		
		
		System.out.println("max is hungry so he is going to eat his legs");
		realMonster.setTenticleAmount(3.5);
		System.out.println(realMonster);
		
		interactWithTheMonster(realMonster);
		
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		System.out.println(currentMonster.getName() + " suggestsrms, they have " + currentMonster.getArmCount());
		System.out.println("How many do you want to eat?");
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();
		currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
		System.out.println("Ok, now " + currentMonster.getName() + "has" +currentMonster.getArmCount() + "arms left.");
		System.out.println("Ok, now " + currentMonster.getName() + "has" + currentMonster.getArmCount() + "arms left." );
		
	}
}
