package homework;
import java.util.Scanner;
public class NineTwo {
      public static void main(String[] args){
    	  Scanner input=new Scanner(System.in);
    	  System.out.print("分别输入股票代码，名字，收盘价和当前值：");
    	  String s=input.next();
    	  String n=input.next();
    	  Stock c1=new Stock(s,n);
    	  double p=input.nextDouble();
    	  double c=input.nextDouble();
    	  c1.previousClosingPrice=p;
    	  c1.currentPrice=c;
    	  System.out.println("市值变化的百分比为"+c1.getChangePercent()+"%");
      }
}
