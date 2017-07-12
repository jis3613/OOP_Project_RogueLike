package Entity;
import Config.Config;
public class Player extends Entity{
	
	public Player(){
		this.setIcon('@');
		this.setHP(Config.HP);
		this.setMaxHP(Config.maxHP);
		this.setPower(Config.power);
		this.setMaxPower(Config.maxPower);
	}
}
