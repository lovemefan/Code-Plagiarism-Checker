package kkk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dianti {
	private String st;
	private int l;
	private String ud;
	private double t;
	private double t2;
	
	Dianti(){
		this.l = 1;
		this.ud = "UP";
		this.t = 0;
	}
	
	//构造方法
	Dianti(String st,int l,String ud,double t,double t2){
		this.st=st;
		this.l = l;
		this.ud = ud;
		this.t = t;
		this.t2 = t2;
	}
	
	//存数据
	public static void cun2(String st,int l,String s,double t,double t2){
		try{
    		File file = new File("text1.txt");
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		FileWriter fileWritter = new FileWriter(file,true);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write("[" + st + "]" + "/" + "(" + String.valueOf(l) + "," + s + "," + String.valueOf(t) + ")" + "\r\n" + "离开时间：" + t + "\r\t" + "等待时间：" + t2 + "\r\n");
    	    bufferWritter.close();
    	}
		catch(IOException e){
    		e.printStackTrace();
    	}
	}

}
