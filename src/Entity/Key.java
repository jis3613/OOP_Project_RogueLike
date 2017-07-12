package Entity;

import Config.Config;

public class Key extends Entity {
	public Key(){
		this.setIcon('K');
	}
	public void showMenu(){
		System.out.println(Config.K);
		System.out.print(Config.K2);
		inputCommand();
	}
	public void inputCommand(){
		char answer = Config.scan.next().charAt(0);
		if(answer==Config.Take){
			this.getMap().getPlayer().setKey(true);
			Config.move(this);
			System.out.println(Config.K3);
		}else{
			System.out.println(Config.MoveOther);
		}
		
	}
}
