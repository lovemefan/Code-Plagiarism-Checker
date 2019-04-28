package exercise2;

public class Stock {
	public static void main(String[] args){
		Stock Stock1=new Stock();
		System.out.println("The ChangePercent of the stock is:"+Stock1. getChangePercent()+"%");
	}
	String name,symbol;
    double previousClosingPrice,currentClosingPrice;
	Stock(){
		name="Oracle Corporation";
		symbol="ORCL";
		previousClosingPrice=34.5;
		currentClosingPrice=34.35;
	}
	Stock(String newname,String newsymbol,double newpreviousClosingPrice,double newcurrentClosingPrice){
		name=newname;
		symbol=newsymbol;
		previousClosingPrice=newpreviousClosingPrice;
		currentClosingPrice=newcurrentClosingPrice;
	}
    double getChangePercent(){
    	return (currentClosingPrice-previousClosingPrice)*100/previousClosingPrice;
    }
    void setData(String newname,String newsymbol,double newpreviousClosingPrice,double newcurrentClosingPrice){
    	name=newname;
		symbol=newsymbol;
		previousClosingPrice=newpreviousClosingPrice;
		currentClosingPrice=newcurrentClosingPrice;
    }
}

