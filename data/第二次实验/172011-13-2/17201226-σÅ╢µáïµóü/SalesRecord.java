package Hellowworld;

public class pakage {
	long ID=0;
	Goods goods=null;
	int amount=1;
	
	
public SalesRecord(Goods goods){
	this.goods = goods;
	}

public SalesRecord(Goods goods,int amount){
	this.goods = goods;
	this.amount = amount;
	}

public int getAmount(){
	return amount;
}

public void setAmount(int amount){
	this.amount = amount;
}

}
