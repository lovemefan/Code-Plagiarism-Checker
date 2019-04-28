package ื๗าต;



public class TestStock {
  public static void main(String[] args){
	  Stock ck=new Stock();
	  ck.CurrentPrice=34.5;
	  ck.setP(34.35);
	  System.out.println("This stock's symbol is "+ck.symbol+" name is "+ck.name+
			  " Percent is "+ck.getchangePercent(34.5,34.35)+"%");
	  
  }
}
class Stock{
	String symbol;
	String name;
	double PreviousClosingPrice;
	double CurrentPrice;;
	Stock(){
		 symbol="ORCL";
		  name="Oracle Corporation";
	
	}
	void setP(double newP){
		PreviousClosingPrice=newP;
	}
	double getchangePercent(double a,double b){
		
	return ((b-a)/a)*100;
	}
		
	
}