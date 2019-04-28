package eee;

import java.io.*;

public class Dianti {
	private int l;
	private String ud;
	private double t;
	
	Dianti(){
		this.l = 1;
		this.ud = "UP";
		this.t = 0;
	}
	
	//构造方法
	Dianti(int l,String ud,double t){
		this.l = l;
		this.ud = ud;
		this.t = t;
		cun2(l,ud,t);
	}
	
	//存数据
	public static void cun2(int l,String s,double t){
		try{
    		File file = new File("text1.txt");
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		FileWriter fileWritter = new FileWriter(file,true);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write("(");
			bufferWritter.write(String.valueOf(l));
			bufferWritter.write(",");
			bufferWritter.write(s);
			bufferWritter.write(",");
			bufferWritter.write(String.valueOf(t));
			bufferWritter.write(")");
			bufferWritter.write("\r\n");
    	    bufferWritter.close();
    	}
		catch(IOException e){
    		e.printStackTrace();
    	}
	}

}
