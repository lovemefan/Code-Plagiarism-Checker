import java.util.Scanner;

public class Code9_2 {
      private static Scanner input;

	public static void main(String[] args){
    	  input = new Scanner(System.in);
    	  System.out.println("�ֱ������Ʊ���룬���֣����̼ۺ͵�ǰֵ��");
    	  String symbol=input.next();
    	  String name=input.next();
    	  Stock r=new Stock(symbol,name);
    	  double p=input.nextDouble();
    	  double c=input.nextDouble();
    	  r.previousClosingPrice=p;
    	  r.currentPrice=c;
    	  System.out.println("��ֵ�仯�İٷֱ�Ϊ"+r.getChangePercent()+"%");
      }
}
