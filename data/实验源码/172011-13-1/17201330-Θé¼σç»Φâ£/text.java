import java.util.Scanner;

public class text {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Student[] students = new Student[30];//创建数组装随机产生的学生信息
		double allStudentAverage = 0;//存放全体学生中的平均成绩
		double allTotal = 0;//存放全体学生的总成绩
		int index = 0;//存放最高分学生所在位置
		//找到最高分学生所在位置
		for (int i = 0; i < 30; i++) {
			students[i] = new Student();
			allTotal += students[i].averageScore();
			if (students[i].averageScore() > allStudentAverage) {
				index = i;
			}
		}
		allStudentAverage = allTotal / 30;
		Student news = new Student();
		System.out.println("Enter the Name of this student:");
		news.studentName = input.next();
		System.out.println("Enter the ID of this student:");
		news.studentID = input.nextInt();
		//判断用户所输入的四个成绩是否符合要求
		int b = 0;
		while (b != 4) {
			System.out.println("Enter the  four scores of this student(0-100):");
			news.scores[0] = input.nextInt();
			news.scores[1] = input.nextInt();
			news.scores[2] = input.nextInt();
			news.scores[3] = input.nextInt();
			for (int i = 0; i < 4; i++) {
				if (news.scores[i] <= 100 && news.scores[i] >= 0) {
					b++;
				}
			}
			if (b != 4) {
				System.out.println("The scores must between 0 and 100!");
			}
		}
		System.out.println(news.studentName + "(ID:" + news.studentID + ')' + " AverageScore:" + news.averageScore()
				+ " Max:" + news.max());
		if (news.averageScore() < students[index].averageScore() && news.max() < students[index].max()) {
			System.out.println(students[index].studentName + "(ID:" + students[index].studentID + ')'
					+ "'s average is the highest:" + students[index].averageScore() + " Max:" + students[index].max());
		} else
			System.out.println(news.studentName + " is the most great student in this class now");
		if (news.averageScore() > allStudentAverage) {
			System.out.println(news.studentName + "'s averagescores is higher than all studens's average");
		} else if (news.averageScore() == allStudentAverage) {
			System.out.println(news.studentName + "'s averagescores is same as all studens's average");
		} else {
			System.out.println(news.studentName + "'s averagescores is lower than all studens's average");
		}
	}

}
