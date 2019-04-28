
//学生类，用来储存学生信息
public class Student {
	private String studentID;//学生的学号属性
	private String studentName;//学生的姓名属性
	private int[] score = new int[4];//学生的四个科目的分数的属性
//学生类的无参构造方法
	Student() {
	}	
//用来引用studentID的方法
	String setID() {
		return this.studentID;
	}
//学生类的方法，用来对属性studentID赋值
	public void setID(String studentID) {
		this.studentID = studentID;
	}
//用来引用studentName的方法
	String setName() {
		return this.studentName;
	}
//学生类的方法，用来对属性studentName赋值
	public void setName(String studentName) {
		this.studentName = studentName;
	}
//用来引用数组score的方法
	int[] setScore() {
		return score;
	}
//学生类的方法，用来对数组score赋值
	public void setScore(int[] score) {
		this.score = score;
	}
//方法getID(),用来得到学生的随机学号
	public String getID() {
		studentID = "172011" + (int) (10 + Math.random() * 30);
		return studentID;
	}
//方法getName(),用来得到学生的随机姓名
	public String getName() {
		char a = (char) ('a' + Math.random() * ('z' - 'a' + 1));
		char b = (char) ('a' + Math.random() * ('z' - 'a' + 1));
		char c = (char) ('a' + Math.random() * ('z' - 'a' + 1));
		char d = (char) ('a' + Math.random() * ('z' - 'a' + 1));
		studentName = "" + a + b + c + d;
		return studentName;
	}
//测试方法，用于输出所有学生的每课分数
	/*void outPutScore(){
		for(int i = 0;i < 4;i ++) {
			System.out.printf("%3d\t",score[i]);
		}
		System.out.println();
	}*/
//方法getScore(),用来随机得到学生四个科目的成绩
	public int[] getScore() {
		for (int i = 0; i < 4;i ++) {
			score[i] = (int) (Math.random() * 101);
		}
		return score;
	}
//方法max(),得出学生四个科目中最高的分数
	public int max() {
		int highestScore = score[0];
		for (int i = 1; i < score.length;i ++) {
			if (highestScore < score[i]) {
				highestScore = score[i];
			}
		}
		return highestScore;
	}
//方法averageScore(),得到学生四个科目的平均分数
	public double averageScore() {
		return (score[0] + score[1] + score[2] + score[3]) / 4.0;
	}
}

