
import java.util.Scanner;

//处理类
public class Proceed {
	//处理类的构造方法
	//学生对象
	public Proceed(){

	}

	//初始化方法
	//学生对象
	public void initialize(Student[] student){
		// 产生学生成绩和输入学生信息
		int[] scores = new int[4];
		String[] Name = { "Jack", "Mark", "Sarah", "John", "Lucy", "Handson", "Bigman", "Wuyifan", "Yangyang",

				"Eryuehong", "Fouye", "Wuxie", "Wukong", "Bajie", "Shaseng", "Tangseng", "Bailongma", "Mangseng",

				"Lisangzuo", "Ruiwen", "Jiansheng", "Dema", "Anni", "Yan", "Qiling", "Liuchuang", "Leina", "TDME",

				"Mumu", "ASTN" };
		for (int i = 0; i < 30; i++) {
			int j;
			for (j = 0; j < 4; j++) {
				scores[j] = (int) (Math.random() * 100);
			}
			if (i + 1 < 10)
				student[i] = new Student("1720130" + (i + 1), Name[i], scores);
			else {
				student[i] = new Student("172013" + (i + 1), Name[i], scores);
			}
			for (j = 0;j < 4; j ++){
				if (student[i].max() < scores[j]){
					student[i].setMax(scores[j]);
				}
			}
			student[i].setAverage((scores[0] + scores[1] +scores[2] +scores[3])/4);
		}
	}
	
	//输入方法
	public int  input(Student student){
		// 输入名字，学号和分数
		int[] scores = new int[4];
		int max = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of the student:");
		student.setName(input.nextLine());
		System.out.println("Please enter the ID of the student:");
		student.setID(input.nextLine());
		System.out.println("Please enter the scores of the student(like 100 99 98 97):");
		for (int i = 0; i < 4; i++) {
			scores[i] = input.nextInt();
			if (scores[i] > max){
				max = scores[i];
			}
		}
		student.setScores(scores);
		student.setAverage((scores[0] + scores[1]  +scores[2]  +scores[3])/4);
		student.setMax(max);
		if (student.max() > 100){
			System.out.println("成绩不能超过100分");
			return 1;
		}
		return 0;
	}
	
	//输出方法
	//学生姓名，学生id，学生平均成绩，最高分
	public void output(Student student){
		System.out.println(student.getName() + "(" + student.getID() + ")平均分" + student.average + "最高分" + student.max);
	}

	//判断方法
	//学生姓名，学生id，学生平均成绩，学生对象
	public void judge(Student student1,Student[] student){
		int max = 0;
		for (int i = 0; i < 30; i ++){
			if (student[i].average() > student[max].average()){
				max = i;
			}
		}
		if (student1.average() > student[max].average()){
			System.out.println(student1.getName() + "现在是全班最好的学生了");
		}else {
			System.out.println(student[max].getName() + "(" + student[max].getID() + ")平均分 " + student[max].average()
					+ "最高分 " + student[max].max());
			if (student1.average() < student[0].sumAverage(student)){
				System.out.println(student1.getName() + "的平均成绩低于全班平均分");
			}else {
				System.out.println(student1.getName() + "的平均成绩高于全班平均分");
			}
		}
	}
}
