package Entity;

public class Wall extends Entity {
	public Wall(){
		this.setIcon('#');
	}
	public void showMenu(){
		System.out.println(Config.Config.wall);
		System.out.println();
	}
}
