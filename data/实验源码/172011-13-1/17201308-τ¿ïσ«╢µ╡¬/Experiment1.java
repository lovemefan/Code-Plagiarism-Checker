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
	  System.out.println(student1.getName() + "�����ǰ��ϳɼ���õ�ѧ����");
	  System.out.println(student1.getName() + "��ƽ���ֳɼ�����ȫ���ƽ����");
  }
  else {
	  System.out.println(student[flag].getName() + "(ID" + student[flag].getID() +
			  ")averageScore" + student[flag].getaverageScore() + "maxd score"
			   + student[flag].getmax() );
  }
	}
}
class Student {
    String studentID;//ѧ��ѧ��
    String studentName;//ѧ������
    int[] scores = new int[4];//ѧ���ɼ�
//���ѧ��ѧ��
public String getID(){
   	 return studentID;
    }
//���ѧ��������
public String getName(){
return  studentName;
}
//ѧ����Ĺ��췽��
public Student(String studentName,String studentID,int []scores){
this.studentName = studentName;
this.studentID = studentID;
this.scores = scores;
}
//���ѧ���ɼ��е����ֵ
int max = scores[0];
public int getmax(){
for(int i=0;i < scores.length - 1;i++)
{if(scores[i] > max)
	max = scores[i];
}
return max;
}
//���ѧ���ɼ���ƽ��ֵ
public double getaverageScore(){
 int sum = 0;
for(int i=0;i<scores.length-1;i++){
	
	sum =sum + scores[i];
}
int average = sum/scores.length;
return average;	
}

}


