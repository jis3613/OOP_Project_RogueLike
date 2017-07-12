package Entity;
import Config.Config;
public class Empty extends Entity {
	public Empty(){
		this.setIcon('.');
	}
	public void showMenu(){
		inputCommand();
	}
	public void inputCommand(){
		Config.move(this);
	}
}
