
public class TestFan {
      public static void main(String[] args){
    	  Fan fan1=new Fan();
    	  Fan fan2=new Fan();
    	  fan1.setSpeed(fan1.FAST);
          fan1.setRaidus(10);
          fan1.setColor("yellow");
          fan1.isOn(true);
          
          fan2.setSpeed(fan2.MEDIUM);
          fan2.setRaidus(5);
          fan2.setColor("blue");
          fan2.isOn(false);
          System.out.println(fan1.toString());
          System.out.println(fan2.toString());
}
}