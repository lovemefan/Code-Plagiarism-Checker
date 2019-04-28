
public class Agent {
	Lever l;
	Dial d;
	Brush b;
	
	public Agent(){
		
	}
	
	public void dealSpeed(){
		switch(l.getPos()){
		case 1:
			b.setSpeed(0);break;
		case 2:
			switch(d.getPos()){
			case 1:
				b.setSpeed(2);break;
			case 2:
				b.setSpeed(6);break;
			case 3:
				b.setSpeed(12);break;
			}
		}
	}
}
