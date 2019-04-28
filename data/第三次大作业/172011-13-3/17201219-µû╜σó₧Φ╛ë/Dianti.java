package kkk2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dianti {
	private String st;
	private int l;
	private String ud;
	private double t;
	
	Dianti(){
		this.l = 1;
		this.ud = "UP";
		this.t = 0;
	}
	
	//构造方法
	Dianti(String st,int l,String ud,double t){
		this.st=st;
		this.l = l;
		this.ud = ud;
		this.t = t;
		cun2(st,l,ud,t);
	}
	
	//存数据
	public static void cun2(String st,int l,String s,double t){
		try{
    		File file = new File("text1.txt");
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		FileWriter fileWritter = new FileWriter(file,true);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write("["+st+"]"+"/"+"("+String.valueOf(l)+","+s+","+String.valueOf(t)+")"+"\r\n");
    	    bufferWritter.close();
    	}
		catch(IOException e){
    		e.printStackTrace();
    	}
	}

}
