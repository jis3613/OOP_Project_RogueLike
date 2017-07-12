package RogueLike;

import Config.Config;
import FileManager.FileManager;
import WorldMap.WorldMap; 

public class RogueLike {
	public static void main(String[] args) {
		WorldMap gameMap = new WorldMap(); 
		FileManager file = new FileManager(); 
		file.loadMap(Config.MAP_FILENAME); 
		char[][] map = file.buildMap();
		System.out.println(Config.Guide);
		gameMap.initialize(map); 
		gameMap.showmap();
		gameMap.run();
		System.out.println(Config.gameOver); 
	}
}
