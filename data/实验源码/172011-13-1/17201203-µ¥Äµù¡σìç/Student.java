package Text;

import java.util.Scanner;

public class Student {
	int score1, score2, score3, score4;// 定义学生成绩
	int m = (int) (Math.random() * 31);
	String studentID = "17201200" + m;// 设置学生学号
	String studentName = "marry" + m;// 设置学生姓名

	public String getName() {
		return studentName;
	}// 获得学生姓名

	public String getID() {
		return studentID;
	} // 获得学生学号

	public void score() {
		score1 = (int) (Math.random() * 101);
		score2 = (int) (Math.random() * 101);
		score3 = (int) (Math.random() * 101);
		score4 = (int) (Math.random() * 101);// 随机同学的成绩
	}

	public int max() {
		int a = 0;
		if (a < score1) {
			a = score1;
		}
		if (a < score2) {
			a = score2;
		}
		if (a < score3) {
			a = score3;
		}
		if (a < score4) {
			a = score4;//a为成绩最大值
		}
		return a;// 获得该同学成绩中的最大成绩
	}

	public double averageScore() {
		double b;
		b = (score1 + score2 + score3 + score4) / 4;// 获取该同学的平均成绩
		return b;//b为平均成绩
	}

}
