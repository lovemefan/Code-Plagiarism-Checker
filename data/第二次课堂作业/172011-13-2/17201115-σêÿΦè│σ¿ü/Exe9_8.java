package dame;

public class Exe9_8  implements Speed{//对名为Speed的借口定义

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Fan c1;
   c1=new Fan();
   c1.newSpeed(FAST);
   c1.newcolor("yellow");
   c1.newRedius(10);
   c1.newon(true);
   System.out.println("The first fan:\n"+c1.toString()+"\n");
   
   Fan c2;
   c2=new Fan();
   c2.newSpeed(MEDIUM); 
   c2.newon(false);
   System.out.println("The second fan:\n"+c2.toString());
	}

}
interface Speed {//3个 常亮
	int SLOW =1;
	int MEDIUM =2;
	int FAST =3;
}
class Fan implements Speed{
	private int speed=SLOW;
	private boolean on=false;
	double radius = 5;//默认私有
	String color = "blue";
	public String toString(){
		if(on){
			return "speed:"+speed+"\ncolor:"+color+"\nradius:"+radius;
			}
		else {
			return "The fan is off"+"\ncolor:"+color+"\nradius"+radius;
		}
	}
	
    public boolean geton(){//开关状态
		return on;
	}
    public void newon(boolean x){
    	on=x;
    }
    //速度查看修改
	public int getSpeed(){
		return speed;
	}
	public void newSpeed(int speed){
		this.speed=speed;
	}
	//颜色查看修改
	public String getColor(){
		return color;
	}
	public void newcolor(String x){
		color=x;
	}
	public double getRadius(){
		return radius;
	}
	public void newRedius(int radius){
		this.radius=radius;
		
	}
}