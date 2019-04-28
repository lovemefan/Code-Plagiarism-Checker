package homework;

public class stock {
    public static void main(String[] args){
    	SimpleStock stock1=new SimpleStock("ORCL","Oracle Corporation",34.5,34.35);
    	System.out.println("The market value of the stock is "+stock1.name+",and the stock code is "+stock1.symble+" the percentage change is "+stock1.getChangePrice()+"%");
    	
    }
}

class SimpleStock{
	String symble;
	String name;
	double previousClosingPrice;
	double currentPrice;
	SimpleStock(String newSymble,String newName,double newPreviousClosingPrice,double newCurrentPrice){
		symble=newSymble;
		name=newName;
		previousClosingPrice=newPreviousClosingPrice;
	    currentPrice=newCurrentPrice;
	}
	double getChangePrice(){
		return (currentPrice-previousClosingPrice)/previousClosingPrice*100;
	}
	void setStock(String newSymble,String newName,double newPreviousClosingPrice,double newCurrentPrice){
		symble=newSymble;
		name=newName;
		previousClosingPrice=newPreviousClosingPrice;
	    currentPrice=newCurrentPrice;
	}
}
