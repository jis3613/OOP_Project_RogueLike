package Entity;
import Config.Config;
public class Food extends Entity{
	public Food(){
		this.setIcon('F');
	}
	public void showMenu(){
		System.out.println(Config.F);
		System.out.print(Config.F2);
		inputCommand();
	}
	public void inputCommand(){
		char answer = Config.scan.next().charAt(0);
		if(answer==Config.Eat){
			if(getMap().getPlayer().getHP()==100){
				System.out.println(Config.F3);
			}else{
				System.out.println(Config.F4);
				getMap().getPlayer().increaseHP(10);
			}
			System.out.println(Config.F5+getMap().getPlayer().getHP());
			Config.move(this);
		}else{
			System.out.println(Config.MoveOther);
		}
		
	}
}
