package Lab1;

import java.security.PublicKey;
import java.util.Scanner;

public class Student {
                 String studentID;//学生学号
		         String studentName;//学生姓名
		         int []scores=new int[4];//学生成绩
		//获得学生学号
		public String getID(){
		        	 return studentID;
		         }
		//获得学生的姓名
		public String getName(){
			return  studentName;
		}
		//学生类的构造方法
		public Student(String studentName,String studentID,int []score){
			this.studentID=studentID;
			this.studentName=studentName;
			this.scores=score;
				
		}
		//获得学生成绩中的最大值
		public int max(){
			double max=scores[0];
			for(int a=0;a<scores.length;a++) {
				if(scores[a]>max) {
					max=scores[a];
				}
			}
			return (int) max;
		}
		//获得学生成绩的平均值
		public double averageScore(){
			int sum=0;
			for (int i=0;i<scores.length;i++) {
				int index=(int)(Math.random()*100);
				scores[i]=index;
				sum += scores[i];
				}
			double averageScore;
			return averageScore=sum / 4;
		}

		// TODO Auto-generated method stub

	}


