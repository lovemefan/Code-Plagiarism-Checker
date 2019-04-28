package Hellowworld;

public class Goods {
	String goodsName=null;
	boolean boxPacked=box;
	String barCode=null;
	int unitCost=0;
public Goods(String goodsName,String barCode,int unitPrice){
	this.goodsName = goodsName;
	this.barCode = barCode;
	this.unitPrice = unitPrice;
	}
public Goods(String goodsName,int unitPrice){
	this.goodsName = goodsName;
	this.unitPrice = unitPrice;
	}
public float Price1(int n){
	return n * unitPrice;
}
public String getGoodsName(){
	return goodsName;
}
public String getBarCode(){
	return barCode;
}
public int getUnitPrice(){
	return unitPrice;
}

}
