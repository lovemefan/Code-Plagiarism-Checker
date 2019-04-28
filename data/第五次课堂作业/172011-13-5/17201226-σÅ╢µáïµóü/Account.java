package Hellowworld;

import java.util.Scanner;
import java.util.Date;
public class Account{
	private int id;
	private int name;
	private double balance;
	private double dateCreated;
	public double PaymentOfAmount;
	public  char description;
public Account(int id,double balance,double dateCreated){
	this.id=id;
	this.balance= balance;
	this.dateCreated= dateCreated;
}
	
public int getid(){
	return id;
}
public void  balance(double balance){
	this.balance=balance;
}
public void datecreated(double dateCreated){
	this.dateCreated=dateCreated;
}
public int name(){
	return name;
}
public double PaymentOfAmount(){
	return PaymentOfAmount;
}
public char description(){
	return description;
}}