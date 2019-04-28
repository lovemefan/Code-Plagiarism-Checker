package kkk2;

import java.io.*;
import java.util.*;

public class Duilie {
	public static void main(String[] args) throws Exception  {
		
		Queue<String> d = new LinkedList<String>();//创建一个队列
		Queue<String> s = new LinkedList<String>();//创建一个队列
		//Queue<String> f = new LinkedList<String>();//创建一个队列
		//Queue<String> o = new LinkedList<String>();//创建一个队列
		java.io.File file = new java.io.File("text.txt");//从文件中读取表达式
		Scanner input = new Scanner(file);
		s.offer("(FR,1,UP,-1)");
		while(input.hasNext()){
			String m = input.nextLine();
			String w = suo(m);
			if("RUN".equals(w)){
				break;
			}
			else{
				d.offer(w);
			}
		}
		
		//将队列中元素提取出来
		int q = 0;
		for(String p : d){
			if(pan(p)==true){
				q++;
				String h = p.substring(1,p.length() - 1);
				int i=h.lastIndexOf(",");
				String j=h.substring(i+1,h.length());
				String y = s.peek().substring(1,s.peek().length() - 1);
				int r=y.lastIndexOf(",");
				String u=y.substring(r+1,y.length());
				if((q==1&&p.matches("\\(FR,([1-9]|10),(UP|DOWN),([1-9]|[\\d]{2}|[\\d]{3}|[\\d]{4})\\)"))||(q==1&&p.matches("\\(ER,([1-9]|10),([1-9]|[\\d]{2}|[\\d]{3}|[\\d]{4})\\)"))){
					cun("INVALID[" + p + "]");
				}
				else if(p.matches("\\(FR,10,UP,([0-9]|[\\d]{2}|[\\d]{3}|[\\d]{4})\\)")||p.matches("\\(FR,1,DOWN,([0-9]|[\\d]{2}|[\\d]{3}|[\\d]{4})\\)")){
					cun("INVALID[" + p + "]");
				}
				else if(s.peek().equals(p)){
					cun("SAME[" + p + "]");
				}
				else if(Integer.parseInt(j)<=Integer.parseInt(u)){
					cun("INVALID[" + p + "]");
				}
				else{
					//f.offer(p);
					//o.offer(p);
					s.offer(p);
					String a = s.peek().substring(1,s.peek().length() - 1);
					String[] g = a.split(",");
					Qingqiu A = new Qingqiu(p,Integer.parseInt(g[1]));
				    A.getC();
				    s.remove();
				}
			}
			else{	
				cun("INVALID[" + p + "]");
			}
		}

	/*	for(String w : f){
			String c = f.peek().substring(1,s.peek().length() - 1);
			String[] n = c.split(",");
			o.remove();
			s.offer(w);
			String a = s.poll().substring(1,s.peek().length() - 1);
			String[] g = a.split(",");
			Qingqiu A = new Qingqiu(w,Integer.parseInt(g[1]));
		    A.getC();
		    for(String r : o){
		    	String b = o.peek().substring(1,s.peek().length() - 1);
				String[] v = b.split(",");
		    }
		    
		}*/
		
		input.close();
	}
													
	//缩进
	public static String suo(String s){
		String q = "";
		String[] n = s.split(" ");
		for(int i = 0;i < n.length;i++){
			q = q + n[i];
		}
		return q;
	}
	
	//正则表达式判断
	public static boolean pan(String s){
		if(s.matches("\\(FR,([1-9]|10),(UP|DOWN),([0-9]|[\\d]{2}|[\\d]{3}|[\\d]{4})\\)")){
			return true;
		}
		else if(s.matches("\\(ER,([1-9]|10),([0-9]|[\\d]{2}|[\\d]{3}|[\\d]{4})\\)")){
			return true;
		}
		else{
			return false;
		}
	}
	
	//把数据存入文件
	public static void cun(String s){
		try{
    		File file = new File("text1.txt");
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		FileWriter fileWritter = new FileWriter(file,true);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(s+"\r\n");
    	    bufferWritter.close();
    	}
		catch(IOException e){
    		e.printStackTrace();
    	}
	}

}



