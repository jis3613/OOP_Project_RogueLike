package Config;

import java.util.Scanner;

import Entity.Empty;
import Entity.Entity;

public class Config {
	public static Scanner scan = new Scanner(System.in);
	public static int HP=50;
	public static int power = 10;
	public static int maxHP = 100;
	public static int maxPower = 100;
	final public static char UP = 'W';
	final public static char DOWN = 'S';
	final public static char Left = 'A';
	final public static char Right = 'D';
	final public static char Quit = 'Q';
	final public static char Unlock = 'U';
	final public static char Take = 'T';
	final public static char Eat = 'E';
	final public static char Move = 'M';
	final public static String wall="It's a wall, you can't pass through here!";
	
	final public static String W1="Weapon is found!";
	final public static String W3="Player's Power is FULL!";
	final public static String W4="Power increased by 10!";
	final public static String W5="Player's Current Power is ";
	
	final public static String R1="It's a Rock. You can move it.";
	final public static String R2="(M)ove?  (N)ope";
	final public static String R3="Can't move the Rock this way.";
	
	final public static String F="Food is found!";
	final public static String F2="(E)at (N)ope";
	final public static String F3="Player's HP is FULL!";
	final public static String F4="HP increased by 10!";
	final public static String F5="Player's Current HP is ";
	
	final public static String K="Key is found!";
	final public static String K2="(T)ake (N)ope";
	final public static String K3="You got the Key!";
	
	final public static String DK="Locked Door";
	final public static String DK2="(U)nlock (N)ope";
	final public static String DK3="Door Unlocked!";
	final public static String DK4="Player doesnot have the key";
	
	final public static String defaultWeapon ="Bare hands";
	final public static String Weapon1 ="Short Sword";
	final public static String Weapon2 ="Shotgun";
	final public static String Weapon3 ="LaserCanon";
	
	final public static String MAP_FILENAME ="/Users/InseopChung/Documents/workspace/OOP_Project/map.txt";
//	final public static String MAP_FILENAME ="/Users/InseopChung/Desktop/map.txt";
//	final public static String MAP_FILENAME ="c:\oop\map.dat";
	final public static String W_INPUT ="Wrong input";
	
	final public static String MoveOther ="Then move the other way around please";
	
	final public static String op ="ONLY CAPITAL LETTERS";
	final public static String mainMenu = "(A)Left (D)Right (W)Up (S)Down (Q)uit: ";
	final public static String gameOver = "Game Over..";
	final public static String Guide ="@:Player   #:Wall  M:Monster   F:Food  W:Weapon   R:Rock   D:Locked Door   K:Key";
	
	public static void move(Entity a){
		int orRow=a.getMap().getPlayer().getRow();
		int orCol=a.getMap().getPlayer().getCol();
		a.getMap().insertEntity(a.getRow(),a.getCol(),a.getMap().getPlayer());
		a.getMap().deleteEntity(orRow, orCol, new Empty());
	}
	public static void move(Entity a,int mpR,int mpC){
		int orR=a.getRow(), orC=a.getCol();
		int pR=a.getMap().getPlayer().getRow(),pC=a.getMap().getPlayer().getCol();
		a.getMap().insertEntity(mpR, mpC, a);
		a.getMap().insertEntity(orR, orC, a.getMap().getPlayer());
		a.getMap().insertEntity(pR, pC, new Empty());
	}

}
