package homework;
import java.util.Scanner;
public class NineTwo {
      public static void main(String[] args){
    	  Scanner input=new Scanner(System.in);
    	  System.out.print("�ֱ������Ʊ���룬���֣����̼ۺ͵�ǰֵ��");
    	  String s=input.next();
    	  String n=input.next();
    	  Stock c1=new Stock(s,n);
    	  double p=input.nextDouble();
    	  double c=input.nextDouble();
    	  c1.previousClosingPrice=p;
    	  c1.currentPrice=c;
    	  System.out.println("��ֵ�仯�İٷֱ�Ϊ"+c1.getChangePercent()+"%");
      }
}
