import java.util.Scanner;

public class Code9_2 {
      private static Scanner input;

	public static void main(String[] args){
    	  input = new Scanner(System.in);
    	  System.out.println("分别输入股票代码，名字，收盘价和当前值：");
    	  String symbol=input.next();
    	  String name=input.next();
    	  Stock r=new Stock(symbol,name);
    	  double p=input.nextDouble();
    	  double c=input.nextDouble();
    	  r.previousClosingPrice=p;
    	  r.currentPrice=c;
    	  System.out.println("市值变化的百分比为"+r.getChangePercent()+"%");
      }
}
