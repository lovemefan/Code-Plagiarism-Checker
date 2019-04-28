package Experiment;

		import java.util.Scanner;

		public class Experiment {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
			  
			  //int personalTop = score1[x] ;
		      char[][] name = new char[30][5];               //名字
		      long[] ID = new long[30];                      //学号
		      int[] score1 = new int[30];                    //第一门成绩
		      int[] score2 = new int[30];                    //第二门成绩
		      int[] score3 = new int[30];                    //第三门成绩
		      int[] score4 = new int[30];                    //第四门成绩
		      double[] average = new double[30];
		      int n ,j;
		      for(n=0;n<30;n++){                             //随机生成各项数据
		    	 for(j=0;j<5;j++){                           //生成姓名
		    		 name[n][j] = (char)((97+Math.random()*25));
		    	 }
		    	 ID[n] = 17201101+n;                          //生成学号
		    	 //生成4门成绩(60-100)
		    	 score1[n] = 40+(int)(Math.random()*60);      
		    	 score2[n] = 40+(int)(Math.random()*60);      
		    	 score3[n] = 40+(int)(Math.random()*60);      
		    	 score4[n] = 40+(int)(Math.random()*60);      
		    	 average[n] = (score1[n]+score2[n]+score3[n]+score4[n])/4;   //每个人平均分   	
		      }

		      //全班平均分
		      double Total = 0;                               
		      for(n=0;n<30;n++){
		    	  Total = Total+average[n];
		      }
		      double totalAverage = Total/30;                  //全班平均分
		      Student c1 ;                                     //建立对象
		      c1 =  new Student();
		      
		      //输入插班生信息
		      Scanner input = new Scanner(System.in);
		      System.out.println("Pease enter student's name:");
		      String newName = input.nextLine();
		      System.out.println("please enter the student ID:");
		      String id = input.nextLine();
		      System.out.println("Please enter student four scores");
		      int[] Score = new int[4];
		      int k =1;
		      for(n=0;n<4;n++){
		    	  Score[n] = input.nextInt();
		    	  if(Score[n]>100){
		    		  System.out.println("The score can't be more than 100!");
		    		  k=0;
		    	  }
		      }
		      if(k==1){
		      //导入
		      c1.getStudent(newName, id,Score );
		      System.out.println(c1.getName()+" ID: "+c1.getID()+" average score:"+c1.averageScore()+" top score:"+c1.max());
		     //找出全班最高分
		      int x = 0;
		      double maxScore = average[0];
		      for(n=1;n<30;n++){
		    	  if(average[n]>maxScore)  {  
		    		  maxScore =average[n];
		    		   x = n;
		    	  }
		      }
		      
		      //个人最高分
		      int personalTop = score1[x] ;
		      if(score2[x]>personalTop) 
		    	  personalTop = score2[x];
		      else if(score3[x]>personalTop) 
		    	  personalTop = score3[x];
		           else if(score4[x]>personalTop)
		        	   personalTop = score4[x];
		    
		      if(c1.averageScore()>maxScore){                             //高于全班最高分
		    	  System.out.println(c1.getName()+" is the best student in class,now");
		    	  System.out.println(c1.getName()+" average score is more than the total class.");
		      }
		     
		       else if(c1.averageScore()>totalAverage){                  //高于全班平均分，低于全班最高分
		    	     System.out.println("The best student is "+name[x][0]+name[x][1]+name[x][2]+name[x][3]);
		    	     System.out.println("ID"+ID[x]+"average score :" + average[x] +" top score:"+personalTop);
		    	     System.out.println(c1.getName()+" score is more than the total class.");
		           }
		           else{                                                 //低于全班平均分
		        	   System.out.println("The best student is "+name[x][0]+name[x][1]+name[x][2]+name[x][3]);
		      	       System.out.println("ID"+ID[x]+"average score :" + average[x] +" top score:"+personalTop);
		      	       System.out.println(c1.getName()+" score is less than the total class.");
		           }
		   
			}
		  }  
		}
		class Student{
		       String studentID;                   //学生学号
		       String studentName;                 //学生姓名
		       int []scores = new int[4] ;        //学生4门成绩
		//获得学生学号
		     public String getID(){
		   	 return studentID;
		    }
		//获得学生的姓名
		     public String getName(){
		     return  studentName;
		     }
		//学生类的构造方法
		     public void getStudent(String studentName,String studentID,int []score){
		         this.studentID=studentID;
		         this.studentName=studentName;
		         this.scores=score;
		         
		     }
		//获得学生成绩中的最大值
		     public int max(){
		     int i;
		     int max=scores[0];
		     for(i=1;i<4;i++){
		    	 if(scores[i]>max)    max = scores[i];
		     }
		     return max;
		    }
		//获得学生成绩的平均值
		    public double averageScore(){
		    double Average;
		    double total = 0;
		    int i;
		    for(i=0;i<4;i++){
		    	total = total + scores[i];
		     }
		     Average = total/4;
		     return Average;
		    }
		   public int[] getScore(){
			   
			   return scores;
		   }
		}    




