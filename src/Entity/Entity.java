package Entity;

import Config.Config;
import WorldMap.WorldMap;

public class Entity {
	private WorldMap map;
	private int HP, MaxHP, Power, MaxPower,row, col;
	private char icon;
	private String weaponStatus = Config.defaultWeapon;
	private boolean hasKey=false;
	
	public void setWeapon(String weapon){
		this.weaponStatus=weapon;
	}
	public String getWeapon(){
		return weaponStatus;
	}
	public boolean getKey(){
		return hasKey;
	}
	public void setKey(boolean hasKey){
		this.hasKey=hasKey;
	}
	public void attachToMap(WorldMap map){
		this.map=map;
	}
	public WorldMap getMap(){
		return map;
	}
	
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	public int getHP(){
		return HP;
	}
	public int getMaxHP(){
		return MaxHP;
	}
	public int getMaxPower(){
		return MaxPower;
	}
	public int getPower(){
		return Power;
	}
	public char getIcon(){
		return icon;
	}
	public void increasePower(int power){
		this.Power+=power;
		if(getMaxPower()<getPower())
			this.Power=getMaxPower();
		if(getPower()>10 && getPower()<40 ) this.setWeapon(Config.Weapon1);
		else if(getPower()>=40 && getPower()<80) this.setWeapon(Config.Weapon2);
		else if(getPower()>=80 && getPower()<=100) this.setWeapon(Config.Weapon3);
	}
	public void increaseHP(int HP){
		this.HP+=HP;
		if(getMaxHP()<getHP())
			this.HP=getMaxHP();
	}
	public void decreaseHP(int HP){
		this.HP-=HP;
		if(getHP()<0)
			this.HP=0;
	}
	public void setRow(int row){
		this.row=row;
	}
	public void setCol(int col){
		this.col=col;
	}
	public void setHP(int HP){
		this.HP=HP;
	}
	public void setMaxHP(int MaxHP){
		this.MaxHP=MaxHP;
	}
	public void setMaxPower(int MaxPower){
		this.MaxPower=MaxPower;
	}
	public void setPower(int Power){
		this.Power=Power;
	}
	public void setIcon(char icon){
		this.icon=icon;
	}
	public void showMenu(){
		
	}
	public void inputCommand(){
		
	}
	

}
