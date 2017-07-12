package Entity;

import java.util.Random;
import Config.Config;


public class Monster extends Entity{
	Random generator = new Random();  
	public Monster(){
		this.setIcon('M');
		this.setHP(generator.nextInt(100)+1);
		this.setPower(generator.nextInt(70)+1);
	}
	public void showMenu(){
		System.out.println("Monster appeared!");
		System.out.println("Monster's HP is "+this.getHP()+" and Power is "+this.getPower());
		System.out.print("(F)ight (N)ope");
		inputCommand();
	}
	public void inputCommand(){
		char answer = Config.scan.next().charAt(0);
		if(answer=='F'){
			fight();
		}else{
			System.out.println(Config.MoveOther);
		}
		
	}
	public void fight(){
		boolean battleDone=false;
		int turn=0;
		while(!battleDone){
			int power=getMap().getPlayer().getPower();
			this.decreaseHP(power);
			turn++;
			System.out.println("****************************Turn "+turn+" starts!****************************");
			System.out.println(power+" damage to the Monster! Way to go!!");
			System.out.println("Due to the attack of the player, the Monster's current HP is "+this.getHP());
			System.out.println("The Player's current HP is "+this.getMap().getPlayer().getHP());
			if(this.getHP()<=0){
				System.out.println("The Monster is DEAD! You won!");
				this.getMap().deleteEntity(this.getRow(), this.getCol(), new Empty());
				Config.move(this);
				if(this.getMap().monsterAllDead()){
					System.out.println("Congratulations!");
					System.out.println("All the monsters are DEAD! You WON!!");
					getMap().setCondition(true);
				}
				battleDone=true;
			}else{
				power=this.getPower();
				this.getMap().getPlayer().decreaseHP(power);
				System.out.println(power+" damage from the Monster! T.T It hurts!");
				System.out.println("Due to the attack of the Monster, the Player's current HP is "+this.getMap().getPlayer().getHP());
				System.out.println("The Monster's current HP is "+this.getHP());
				if(getMap().getPlayer().getHP()<=0){
					System.out.println("The Player is DEAD T.T");
					battleDone=true;
					getMap().setCondition(true);
				}
				else{
					System.out.println("****************************Turn "+turn+" finished!****************************");
				}
			}
			
		}
	}

}

