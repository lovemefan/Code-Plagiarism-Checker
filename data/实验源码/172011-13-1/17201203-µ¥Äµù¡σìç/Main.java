package Text;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入学生姓名：");
		String newName = input.nextLine();// 输入新学生的姓名
		System.out.println("请输入学生学号：");
		String newID = input.nextLine();// 新学生的学号
		System.out.println("请输入四门课的成绩，以空格分隔：");
		int newScore1 = input.nextInt();
		int newScore2 = input.nextInt();
		int newScore3 = input.nextInt();
		int newScore4 = input.nextInt();//定义新生成绩
		Student[] stu = new Student[30];// 创建对象数组

		for (int i = 0; i < stu.length; i++) {
			stu[i] = new Student();// 数组初始化
		}
		for (int i = 0; i < 30; i++) {
			stu[i].score();// 产生每个学生成绩
		}

		double x = (newScore1 + newScore2 + newScore3 + newScore4) / 4;// 新生平均成绩
		int a = 0;
		if (a < newScore1) {
			a = newScore1;
		}
		if (a < newScore2) {
			a = newScore2;
		}
		if (a < newScore3) {
			a = newScore3;
		}
		if (a < newScore4) {
			a = newScore4;// 找出新生最大成绩a为最大成绩
		}

		double ave = 0;
		for (int i = 0; i < 30; i++) {
			ave += (stu[i].score1 + stu[i].score2 + stu[i].score3 + stu[i].score4);
		}
		ave = ave / 4 / 30;// 学生平均成绩ave

		double maxave = 0;
		int j = 0;
		for (int i = 0; i < 30; i++) {
			if (maxave < stu[i].averageScore()) {
				maxave = stu[i].averageScore();
				j = i;//标记这个学生
			} // 找出最大平均成绩maxave
		}
		if (newScore1 > 100 || newScore2 > 100 || newScore3 > 100 || newScore4 > 100) {
			System.out.println("课程成绩不能高于100分！！");
		} else if (x < ave) {
			System.out.println(newName + "(ID:" + newID + ")  平均分 " + x + "最高分 " + a);
			System.out.println(stu[j].getName() + "(ID:" + stu[j].getID() + ")  平均分 " + stu[j].averageScore() + "最高分 "
					+ stu[j].max());
			if (x > ave)
				System.out.println(newName + "的平均成绩高于全班的平均分");
			if (x < ave)
				System.out.println(newName + "的平均成绩低于全班的平均分");
			if (a == ave)
				System.out.println(newName + "的平均成绩等于全班的平均分");
		} else if (ave >= maxave) {
			System.out.println(newName + "(ID:" + newID + ")  平均分 " + x + "最高分 " + a);
			System.out.println(newName + "现在是班上成绩最好的学生了");
			System.out.println(newName + "的平均成绩高于全班的平均分");//输出
		}

	}
}
