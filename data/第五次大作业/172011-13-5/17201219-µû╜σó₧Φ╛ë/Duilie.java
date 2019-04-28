package kkk;

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Duilie extends Application{
	public void start(Stage primaryStage){ 
		BorderPane p=new BorderPane();
		Polygon po1=new Polygon();//电梯下行指示
		Polygon po2=new Polygon();//电梯上行指示
		po1.setFill(Color.WHITE);
		po1.setStroke(Color.BLACK);
		po2.setFill(Color.WHITE);
		po2.setStroke(Color.BLACK);
		double[] l1={40,40,30,50,70,60,60};
		double[] l2={250,280,280,310,280,280,250};
		double[] o2={200,170,170,140,170,170,200};
		ObservableList<Double> list1=po1.getPoints();
		ObservableList<Double> list2=po2.getPoints();
		for(int i=0;i<7;i++){
			list1.add(l1[i]);
			list1.add(l2[i]);
			list2.add(l1[i]);
			list2.add(o2[i]);
		}
		VBox vbox=new VBox(30);
		vbox.setPadding(new Insets(50,50,50,50));
		vbox.setAlignment(Pos.CENTER);
		Button b1=new Button("开始");//开始按钮
		Button b2=new Button("暂停");//暂停按钮
		Button b3=new Button("退出");//退出按钮
		b1.setPrefSize(80,40);
		b2.setPrefSize(80,40);
		b3.setPrefSize(80,40);
		vbox.getChildren().addAll(b1,b2,b3);
		p.setRight(vbox);
		Text t=new Text(420,80,"当前电梯人数");//电梯人数
		Text t2=new Text(540,85,"0");//电梯人数标签
		Text t3=new Text(80,100,"0");//电梯楼层标签
		t2.setText("0");
		t2.setFont(Font.font(50));
		t3.setText("1");
		t3.setFont(Font.font(50));
		p.getChildren().addAll(t,t2,t3,po1,po2);
	    Rectangle r3=new Rectangle(150,50,250,350);//电梯外框
	    r3.setStroke(Color.BLACK);
		r3.setFill(Color.WHITE);
	    Rectangle r1=new Rectangle(150,50,125,350);//电梯左门
	    Rectangle r2=new Rectangle(275,50,125,350);//电梯右门
		r1.setFill(Color.BLUE);
		r1.setStroke(Color.BLACK);
		r2.setFill(Color.BLUE);
		r2.setStroke(Color.BLACK);
		p.getChildren().add(r3);
	    p.getChildren().add(r1);
	    p.getChildren().add(r2);
	    
	    b1.setOnAction(e -> {
	    	
	    	new Thread(new Runnable() {
	    	  int text=0;
	  	      @Override
	  	      public void run() {
	  	        try {
	  	          while (true) {
	  	        	  if(r1.getWidth()>=125&&r2.getWidth()>=125){
	  	        		  text = 1;
	  	        	  }
	  	        	  else if(r1.getWidth()<=0&&r2.getWidth()<=0){
	  	        		  text = 0;
	  	        	  }
	  	        	  if(text==1){
	  	        		  r1.setWidth(r1.getWidth() - 3);
	  	        		  r2.setX(r2.getX() + 3);
	  	        		  r2.setWidth(r2.getWidth() - 3);
	  	        	  }
	  	        	  if(text==0){
	  	        		  r1.setWidth(r1.getWidth() + 3);
	  	        		  r2.setX(r2.getX() - 3);
	  	        		  r2.setWidth(r2.getWidth() + 3);
	  	        	  }
	  	              Thread.sleep(100);
	  	          }
	  	        }
	  	        catch (InterruptedException ex) {
	  	        }
	  	      }
	  	    }).start();
		
	    	new Thread(new Runnable() {
	    	  int text = 0;
	    	  String[] t3t={"1","4","9","3","5","2","6","1","4","8","5","2","4"};
	  	      @Override
	  	      public void run() {
	  	        try {
	  	          while (true) {
	  	        	  if(Integer.parseInt(t2.getText())<13){
	  	        		  t2.setText(String.valueOf(Integer.parseInt(t2.getText()) + 1));
	  	        		  t3.setText(t3t[text++]);
	  	        	  }
	  	        	  if(Integer.parseInt(t3t[text]) < Integer.parseInt(t3t[text - 1])&&text < 13){
	  	        		if(po1.getFill()==Color.BLUE){
		  					po1.setFill(Color.WHITE);
		  				}			
		  				else if(po1.getFill()==Color.WHITE){
		  					po1.setFill(Color.BLUE);
		  				}
	  	        	  }
	  	        	  else if(Integer.parseInt(t3t[text]) >= Integer.parseInt(t3t[text - 1])&&text < 13){
	  	        		if(po2.getFill()==Color.BLUE){
		  					po2.setFill(Color.WHITE);
		  				}			
		  				else if(po2.getFill()==Color.WHITE){
		  					po2.setFill(Color.BLUE);
		  				}
	  	        	  }
	  	              Thread.sleep(500);
	  	          }
	  	        }
	  	        catch (InterruptedException ex) {
	  	        }
	  	      }
	  	    }).start();
	    });
		b2.setOnAction(e -> {
			t2.setText(t2.getText());
			t3.setText(t3.getText());
			r1.setWidth(r1.getWidth());
			r2.setWidth(r2.getWidth());
			r2.setX(r2.getX());
		});
		
		b3.setOnAction(e -> {
			System.exit(0);
		});
    
	    Scene scene = new Scene(p, 600, 500);
	    primaryStage.setTitle("Elevator");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	
	
	public static void main(String[] args) throws Exception  {
		Application.launch(args);
		Queue<String> d = new LinkedList<String>();//创建一个队列
		Queue<String> s = new LinkedList<String>();//创建一个队列
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



