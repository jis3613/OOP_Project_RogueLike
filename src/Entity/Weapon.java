package Entity;

import Config.Config;

public class Weapon extends Entity {
	public Weapon(){
		this.setIcon('W');
	}
	public void showMenu(){
		System.out.println(Config.W1);
		System.out.print(Config.K2);
		inputCommand();
	}
	public void inputCommand(){
		char answer = Config.scan.next().charAt(0);
		if(answer==Config.Take){
			if(getMap().getPlayer().getPower()<100){
				System.out.println(Config.W4);
				getMap().getPlayer().increasePower(10);
			}else{
				System.out.println(Config.W3);
			}
			System.out.println(Config.W5+getMap().getPlayer().getPower());
			Config.move(this);
		}else{
			System.out.println(Config.MoveOther);
		}
		
	}
}
