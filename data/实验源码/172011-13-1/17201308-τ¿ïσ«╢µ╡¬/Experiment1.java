package Experiment1;
import java.util.Scanner;
public class Experiment1 {
 public static void main(String[] args) {
	 Scanner input = new Scanner(System.in);
	 Student[] student = new Student[30];
	 String studentName = "  ";
	 String studentID;
	 int []scores = new int[4];
	 for(int j=0;j < 30;j++){
		 for(int k=0;k <(int) Math.random()*3 + 5;k++){
			 studentName += (char)('a' + Math.random()*('z' - 'a' + 1)) + " ";
		 }
		 studentID = (17201300 + (int)Math.random()*30) + " ";
		 for(int m=0;m < 4;m++){
			 scores[m] = (int)Math.random()*101;
			  }
		 student[j] = new Student(studentName,studentID,scores);
	 }
	System.out.println("Enter the studentName:");
	studentName = input.nextLine();
    System.out.println("Enter the studentID:");
     studentID = input.nextInt() + "";
    System.out .println("Enter the student  four scores:");
    int []scored =new int[4];
    for(int n=0;n<4;n++){
    	scored[n]=input.nextInt();   	
    }
  Student student1 = new Student(studentName,studentID,scored);
  System.out.println(student1.getName() + "(ID" + student1.getID() + ")average" +student1.getaverageScore()
  		+ "maxscore" + student1.getmax());
  double great = student[0].getaverageScore();
		  int flag = 0;
  for(int n=0;n < 30;n++){
	  if(great < student[n].getaverageScore()){
		  great = student[n].getaverageScore();
		  flag = n;
		  }
  }
  if(student1.getaverageScore() > student[flag].getaverageScore()){
	  System.out.println(student1.getName() + "现在是班上成绩最好的学生了");
	  System.out.println(student1.getName() + "的平均分成绩高于全班的平均分");
  }
  else {
	  System.out.println(student[flag].getName() + "(ID" + student[flag].getID() +
			  ")averageScore" + student[flag].getaverageScore() + "maxd score"
			   + student[flag].getmax() );
  }
	}
}
class Student {
    String studentID;//学生学号
    String studentName;//学生姓名
    int[] scores = new int[4];//学生成绩
//获得学生学号
public String getID(){
   	 return studentID;
    }
//获得学生的姓名
public String getName(){
return  studentName;
}
//学生类的构造方法
public Student(String studentName,String studentID,int []scores){
this.studentName = studentName;
this.studentID = studentID;
this.scores = scores;
}
//获得学生成绩中的最大值
int max = scores[0];
public int getmax(){
for(int i=0;i < scores.length - 1;i++)
{if(scores[i] > max)
	max = scores[i];
}
return max;
}
//获得学生成绩的平均值
public double getaverageScore(){
 int sum = 0;
for(int i=0;i<scores.length-1;i++){
	
	sum =sum + scores[i];
}
int average = sum/scores.length;
return average;	
}

}


