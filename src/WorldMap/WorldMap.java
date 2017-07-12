package WorldMap;

import Entity.*;
import Config.Config;


public class WorldMap {
	Entity[][] map;
	Player player;
	boolean done=false;
	
	public void run(){
		while(!this.getEnd()){
			char command=(char) Config.scan.next().charAt(0);
			if(this.moveEntity(command,player)){
				if(getEnd())break;
				this.showmap();
			}
		
		}
	}
	public void initialize(char[][] imap){
		int n=imap.length;
		int m=imap[0].length;
		map= new Entity[n][m];
		for(int i=0;i<imap.length;i++){
			for(int j=0;j<imap[i].length;j++){
				if(imap[i][j]=='F'){
					insertEntity(i,j,new Food());
				}else if(imap[i][j]=='@'){
					insertEntity(i,j,new Player());
					this.player=(Player)map[i][j];
				}else if(imap[i][j]=='#'){
					insertEntity(i,j,new Wall());
				}else if(imap[i][j]=='R'){
					insertEntity(i,j,new Rock());
				}else if(imap[i][j]=='M'){
					insertEntity(i,j,new Monster());
				}else if(imap[i][j]=='W'){
					insertEntity(i,j,new Weapon());
				}else if(imap[i][j]=='K'){
					insertEntity(i,j,new Key());
				}else if(imap[i][j]=='D'){
					insertEntity(i,j,new Door());
				}else
					insertEntity(i,j,new Empty());
			}
		}
		
	}
	public boolean moveEntity(char command, Entity player){
		int tmpRow,tmpCol;
		switch (command) {
        case Config.Left:
            tmpCol = player.getCol()-1;
            tmpRow = player.getRow();
            break;
        case Config.Right:
            tmpCol = player.getCol()+1;
            tmpRow = player.getRow();
            break;
        case Config.UP:
            tmpCol = player.getCol();
            tmpRow = player.getRow()-1;
            break;
        case Config.DOWN:
            tmpCol = player.getCol();
            tmpRow = player.getRow()+1;
            break;
        case Config.Quit:
            setCondition(true);
            return false;
            
        default:
            System.out.println(Config.W_INPUT);
            return true;
            
	    }
		map[tmpRow][tmpCol].showMenu();
	    return true;
	}
	public void insertEntity(int i,int j,Entity ent){
		this.map[i][j]=ent;
		ent.setRow(i);
		ent.setCol(j);
		ent.attachToMap(this);
	}
	public void deleteEntity(int i,int j,Entity ent){
		this.map[i][j]=null;
		insertEntity(i,j,ent);
	}
	public void showmap(){
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				System.out.print(map[i][j].getIcon());
			}
			System.out.println();
		}
		showMenu();
	}
	public void showMenu(){
		System.out.print("Player  ");
		System.out.print("HP: "+this.getPlayer().getHP()+"/100  ");
		System.out.println("Power: "+this.getPlayer().getPower()+"/100");
		System.out.println("        "+this.getPlayer().getWeapon());
		System.out.println("        "+"X:"+this.getPlayer().getCol()+" Y:"+this.getPlayer().getRow());
		System.out.println(Config.op);
		System.out.print(Config.mainMenu);
	}
	public void setCondition(boolean done){
		this.done=done;
	}
	public boolean getEnd(){
		return done;
	}
	public Entity getPlayer(){
		return player;
	}
	public Entity getMap(int i, int j){
		return map[i][j];
	}
	public boolean monsterAllDead(){
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				if(map[i][j].getIcon()=='M')
					return false;
			}
		}
		return true;
	}
}
