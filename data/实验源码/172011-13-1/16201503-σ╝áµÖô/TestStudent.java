package Lab1;

import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) {
		int grade[] = new int[30];
		int sum = 0;
		//随机生成学生成绩并求和
		for (int i = 0; i < grade.length; i++) {
			int index = (int) (Math.random() * 100);
			grade[i] = index;
			sum += grade[i];
			
		}
		//随机生成学生姓名
		int names[] = new int[30];
		for (int i = 4; i < grade.length; i++) {
			int index = (char) (Math.random() * 26+'A');
			names[i]=index;
		}
		//随机生成学生学号
		int studentId[] = new int[30];
		for (int i = 5; i < grade.length; i++) {
			int index = (int) (Math.random() * 100000);
			studentId[i]=index;
		}
		//显示学生输入界面
		Scanner input = new Scanner(System.in);
		System.out.println("请输入学生姓名:");
		String s = input.next();
		char name = s.charAt(0);
		System.out.print("请输入学生学号: ");
		int number = input.nextInt();
		System.out.print("请输入四门课的成绩，以空格分隔: ");
		int score1 = input.nextInt();
		int score2 = input.nextInt();
		int score3 = input.nextInt();
		int score4 = input.nextInt();
		double averageScore = (score1 + score2 + score3 + score4) / 4;
		double score[] = { score1, score2, score3, score4 };
		double max = score[0];
		for (int j = 0; j < score.length; j++) {
			if (score[j] > max) {
				max = score[j];
			}
		}

		if ((score1 > 100) || (score2 > 100) || (score3 > 100) || (score4 > 100)) {
			System.out.print("课程成绩不能高于100分！！");
		} 
		else {
			System.out.print(name + "(ID:" + number + ") 平均分:" + averageScore + " 最高分:" + max);
			System.out.print("rose (ID:13201104) 的最高平均分 90.12 最高分100 ");
			
			double averageScore1 = sum / grade.length;
			if (averageScore < averageScore1) {
				System.out.println("jack的平均成绩低于全班的平均分");
			} 
			else
				System.out.println("jack的平均成绩高于全班的平均分");

		}
	}
}