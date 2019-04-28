
public class Text_9_8 {
	public static void main(String[] args){
		Fan f1 = new Fan();
		Fan f2 = new Fan();
		f1.setSpeed(3);
		f1.setRadius(10);
		f1.setColor("yellow");
		f1.turnOn();
		f2.setSpeed(2);
		f2.setRadius(5);
		f2.turnOff();
		System.out.println(f1.toString());
		System.out.print(f2.toString());
	}
}


class Fan{
	public static final int SLOW = 1;
	public static final int MIDIUM = 2;
    public static final int FAST = 3;
    int speed = SLOW;
    boolean on = false;
    double radius = 5;
    String color = "blue";
    Fan(){
    }
    void turnOn(){
        on = true;
    }
    void turnOff(){
        on = false;
    }
    void setSpeed(int speed){
        this.speed = speed;
    }
    void setRadius(int radius){
        this.radius = radius;
    }
    void setColor(String color){
        this.color = color;
    }
   public String toString() {
        if (on){
            return "speed is " + speed + " color is " + color + " and radius is "+ radius;
        }
        else {
            return "fan is off";
        }
    }
}