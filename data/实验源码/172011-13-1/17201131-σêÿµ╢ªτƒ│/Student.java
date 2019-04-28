package 实验一;
public class Student {
	int studentID;             //学号
	String studentName;        //姓名
	int[] scores = new int[4]; //四个分数
	int getStudentID() {       //得到学号方法
		return studentID;
	}
	String getStudentName() {  //得到姓名方法
		return studentName;
	}
	Student(){                 //无参构造方法
		
	}
	Student(int studentID,String studentName,int a,int b,int c,int d){//传参构造方法
		this.studentID = studentID;     //返回值
		this.studentName = studentName;
		this.scores[0] = a;
		this.scores[1] = b;
		this.scores[2] = c;
		this.scores[3] = d;
		
	}
	int max() {//找出最大数
		int t = 0;
		for(int i = 0;i < scores.length;i ++) {
			if(t < scores[i]) {
				t = scores[i];
			}
		}
		return t;
	}
	
	double averageScore() {//求平均数
		double t = 0;
		t = (double)(this.scores[0] + this.scores[1] + this.scores[2] + this.scores[3]) / scores.length;
		return t;
	}
}
