package eee;

import java.io.*;
public class Diaodu {
	
	private String string;
	private int b;
	Louceng L;
	
	Diaodu(){
	
	}
	
	//���췽��
	Diaodu(String string,int b){
		this.string = string;
		this.b=b;
	}
	
	public String getString(){
			return string;
	}
	
	public void setb(int b){
		this.b = b;
	}
	
	public int getb(){
		return b;
	}
	
	
	//�ж������Ƿ����������ִ�У���������˵��ԭ��
	public void C(){
		String[] f = string.split(",");
		if(string.matches("FR.*")){
			if(Double.parseDouble(f[3])==0){
				L.setLuo(Integer.parseInt(f[1]));
				Dianti A = new Dianti(Integer.parseInt(f[1]),"UP",Double.parseDouble(f[3]) + 1.0 + Math.abs((Integer.parseInt(f[1]) - getb())) * 0.5);
			}
			else if(getb()==Integer.parseInt(f[1])){
				L.setLuo(Integer.parseInt(f[1]));
				Dianti A = new Dianti(Integer.parseInt(f[1]),"STILL",Double.parseDouble(f[3]) + 1.0 + Math.abs((Integer.parseInt(f[1]) - getb())) * 0.5);
			}
			else if(getb()>Integer.parseInt(f[1])){
				L.setLuo(Integer.parseInt(f[1]));
				Dianti A = new Dianti(Integer.parseInt(f[1]),"DOWN",Double.parseDouble(f[3]) + 1.0 + Math.abs((Integer.parseInt(f[1]) - getb())) * 0.5);
			}
			else if(getb()<Integer.parseInt(f[1])){
				L.setLuo(Integer.parseInt(f[1]));
				Dianti A = new Dianti(Integer.parseInt(f[1]),"UP",Double.parseDouble(f[3]) + 1.0 + Math.abs((Integer.parseInt(f[1]) - getb())) * 0.5);
			}
		}
		else {
			if(getb()==Integer.parseInt(f[1])){
				L.setLuo(Integer.parseInt(f[1]));
				Dianti A = new Dianti(Integer.parseInt(f[1]),"STILL",Double.parseDouble(f[2]) + 1.0 + Math.abs((Integer.parseInt(f[1]) - getb())) * 0.5);
			}
			else if(getb()>Integer.parseInt(f[1])){
				L.setLuo(Integer.parseInt(f[1]));
				Dianti A = new Dianti(Integer.parseInt(f[1]),"DOWN",Double.parseDouble(f[2]) + 1.0 + Math.abs((Integer.parseInt(f[1]) - getb())) * 0.5);
			}
			else if(getb()<Integer.parseInt(f[1])){
				L.setLuo(Integer.parseInt(f[1]));
				Dianti A = new Dianti(Integer.parseInt(f[1]),"UP",Double.parseDouble(f[2]) + 1.0 + Math.abs((Integer.parseInt(f[1]) - getb())) * 0.5);
			}
		}
	}
	
	//�����ݴ����ļ�
	public static void cun3(String s){
		try{
    		File file = new File("text1.txt");
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		FileWriter fileWritter = new FileWriter(file,true);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(s);
			bufferWritter.write("\r\n");
    	    bufferWritter.close();
    	}
		catch(IOException e){
    		e.printStackTrace();
    	}
	}
	

}
