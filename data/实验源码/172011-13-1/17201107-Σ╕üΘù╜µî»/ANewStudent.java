
import java.util.Scanner;
//测试类
public class ANewStudent {
	public static void main(String[] args) {
		
		Student[] studentInformation = new Student[31];
		initializeObject(studentInformation);
		getInformation(studentInformation);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入学生姓名 : ");
		studentInformation[30].setName(input.nextLine());
		System.out.println("请输入学生学号 : ");
		studentInformation[30].setID(input.nextLine());
		System.out.println("请输入四门课的成绩，以空格分隔 : ");
		int[] transfer = new int[4];
		for(int i = 0;i < 4;i ++) {
			transfer[i] = input.nextInt();
			if(transfer[i] > 100) {
				System.out.println("课程成绩不能高于100分！！");
				return;
			}
		}
		studentInformation[30].setScore(transfer);
		System.out.println(studentInformation[30].setName() + "(ID: " + studentInformation[30].setID() + ") 平均分 "
				+ studentInformation[30].averageScore() + " 最高分 " + studentInformation[30].max());
		bestStudent(studentInformation);
		averageOrLow(studentInformation);
		/*for(int i = 0;i < studentInformation.length;i ++) {
			System.out.print(studentInformation[i].setName() + " " + studentInformation[i].setID() + " ");
			studentInformation[i].outPutScore();测试语句，使用Student类中的outPutScore方法
		}
		*/
	}
	public static void initializeObject(Student[] studentInformation) {
		for (int i = 0; i < studentInformation.length;i ++) {
			studentInformation[i] = new Student();
		}
	}
	
	public static void getInformation(Student[] studentInformation) {
		for (int i = 0; i < 30;i ++) {
			studentInformation[i].getID();
			studentInformation[i].getName();
			studentInformation[i].getScore();
		}
	}

	public static void bestStudent(Student[] studentInformation) {
		int sign = 0;
		double highestScore = studentInformation[0].max();
		for (int i = 1; i < studentInformation.length;i ++) {
			if (highestScore < studentInformation[i].averageScore()) {
				highestScore = studentInformation[i].averageScore();
				sign = i;
			}
		}
		if (sign == 30) {
			System.out.println(studentInformation[sign].setName() + "现在是班上成绩最好的学生了");
		} else {
			System.out.println(studentInformation[sign].setName() + "(ID: " + studentInformation[sign].setID()
					+ ") 的最高平均分 " + studentInformation[sign].averageScore() + " 最高分 " + studentInformation[sign].max());
		}
	}
	public static void averageOrLow(Student[] studentInformation) {
		int classAverage = 0;
		int sum = 0;
		for (int i = 0; i < studentInformation.length;i ++) {
			sum += studentInformation[i].averageScore();
		}
		classAverage = sum / studentInformation.length;
		if (studentInformation[30].averageScore() < classAverage) {
			System.out.println(studentInformation[30].setName() + "的平均成绩低于全班的平均分");
		} else if (studentInformation[30].averageScore() > classAverage) {
			System.out.println(studentInformation[30].setName() + "的平均成绩高于全班的平均分");
		} else {
			System.out.println(studentInformation[30].setName() + "的平均成绩刚好等于全班的平均分");
		}
	}
}
