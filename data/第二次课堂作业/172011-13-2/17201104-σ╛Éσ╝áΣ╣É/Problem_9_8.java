import java.util.Scanner;
public class Priblem_9_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Now you have two fans!");
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.turnOn();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan2.turnOff();
        fan2.setSpeed(2);
        System.out.println("fan1 :" + fan1.toString());
        System.out.println("fan2 :" + fan2.toString());
    }
}

interface SpeedName {
    int SLOW = 1;
    int MIDIUM = 2;
    int FAST = 3;
}

class Fan implements SpeedName{
    boolean on = false;
    double radius = 5;
    int speed = SLOW;
    String color = "blue";



    public Fan(){

    }
    public void turnOn(){
        on = true;
    }
    public void turnOff(){
        on = false;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void speedUp(){
        if (speed>=1&&speed<=3){
            speed++;
        }
    }
    public void speedDown(){
        if (speed>=1&&speed<=3){
            speed--;
        }
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public void setColor(String color){
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
