package Entity;

import Config.Config;

public class Rock extends Entity {
	public Rock(){
		this.setIcon('R');
	}
	public void showMenu(){
		System.out.println(Config.R1);
		System.out.print(Config.R2);
		inputCommand();
	}
	public void inputCommand(){
		char answer = Config.scan.next().charAt(0);
		if(answer==Config.Move){
			moveIt();
		}else{
			System.out.println(Config.MoveOther);
		}
		
	}
	public void moveIt(){
		int gapRow=this.getRow()-this.getMap().getPlayer().getRow();
		int gapCol=this.getCol()-this.getMap().getPlayer().getCol();
		
		int mpR = 0,mpC = 0;
		
		if(gapRow==0 && gapCol==1){
			//up to down
			mpR=this.getRow(); mpC=this.getCol()+1;
		}else if(gapRow==-1 && gapCol==0){
			//right to left
			mpR=this.getRow()-1; mpC=this.getCol();
		}else if(gapRow==0 && gapCol==-1){
			//down to up
			mpR=this.getRow(); mpC=this.getCol()-1;
		}else if(gapRow==1 && gapCol==0){
			//left to right
			mpR=this.getRow()+1; mpC=this.getCol();
		}
		if(getMap().getMap(mpR, mpC).getIcon()=='.'){
			Config.move(this,mpR,mpC);
		}else{
			System.out.println(Config.R3);
		}
	}
	
	
}
