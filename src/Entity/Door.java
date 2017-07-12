package Entity;

import Config.Config;

public class Door extends Entity {
	public Door(){
		this.setIcon('D');
	}
	public void showMenu(){
		System.out.println(Config.DK);
		System.out.print(Config.DK2);
		inputCommand();
	}
	public void inputCommand(){
		char answer = Config.scan.next().charAt(0);
		if(answer==Config.Unlock){
			if(getMap().getPlayer().getKey()){
				System.out.println(Config.DK3);
				Config.move(this);
			}else{
				System.out.println(Config.DK4);
			}
		}else{
			System.out.println(Config.MoveOther);
		}
		
	}
}
