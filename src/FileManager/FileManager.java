 package FileManager;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class FileManager {
	Vector<String> Stringvector = new Vector<String>();
	public void loadMap(String MAP_FILENAME){
		File file = new File(MAP_FILENAME);
		if(file.exists())
		{
			try {
				Scanner inFile = new Scanner(file);
				String line;
				while(inFile.hasNext()){
					line=inFile.nextLine();
					Stringvector.add(line);
				}
				inFile.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}	
	}
	public char[][] buildMap(){
		int size=Stringvector.size();
		char[][] map= new char[size][];
		int i=0;
		Iterator<String> ite = Stringvector.iterator();		
		while(ite.hasNext()){
			String a= (String)ite.next();
			map[i]=a.toCharArray();
			i++;
		}
		return map;
	}
}
