import java.util.Scanner;

//声明一个Studentmessage类
public class Studentmessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 0;
		Student[] stu = new Student[30]; // 定义一个Student类的数组stu[30]
		for (i = 0; i < 30; i++) // 生成30个学生信息
			stu[i] = new Student();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Student n; // 定义一个Student类的变量n,n指代新学生
		System.out.println("请输入新学生的名字:");
		String newName; // 定义一个字符串变量newName，用来保存新学生姓名
		newName = input.nextLine(); // 输入新学生姓名
		System.out.println("请输入新学生的学号:");
		int id; // 定义一个整型变量id
		id = input.nextInt(); // 输入新学生学号
		System.out.println("请输入新学生的成绩:");
		int[] a = new int[4]; // 定义一个数组a[4]，用来保存新学生4个成绩
		for (i = 0; i < 4; i++) { // 输入新学生的4个成绩
			a[i] = input.nextInt();
		}
		n = new Student(newName, id, a); // 调用带3个参数的构造函数输出新学生信息
		System.out.println("新学生姓名：" + n.getName());
		System.out.println("新学生学号：" + n.getID());
		System.out.print("新学生四门课的成绩，以空格分隔：");
		for (i = 0; i < 4; i++)
			System.out.print(a[i] + " ");
		System.out.println(" ");
		System.out.println("新学生平均分：" + n.averageScore() + "最高分：" + n.maxScore());

		if (a[0] > 100 || a[1] > 100 || a[2] > 100 || a[3] > 100)
			System.out.println("课程成绩不能高于100分!!");
		else if (a[0] == 100 && a[1] == 100 && a[2] == 100 && a[3] == 100)
			System.out.println(n.getName() + "现在是班上成绩最好的学生了");

		// 得到全班的平均分
		double sum = 0;
		double ave = 0; // 定义变量ave，用来保存全班的平均分
		for (i = 0; i < 30; i++) {
			sum = sum + stu[i].averageScore();
		}
		ave = sum / 30;
		// 得到30个学生中的最高平均分
		double max = stu[0].averageScore(); // 定义一个浮点型变量max，用来保存最高平均分
		for (i = 1; i < 30; i++) {
			if (max < stu[i].averageScore())
				max = stu[i].averageScore();
		}
		for (i = 0; i < 30; i++) {
			if (stu[i].averageScore() == max) {
				System.out.println(stu[i].getName() + "的平均分最高: " + max + " 最高分:" + stu[i].maxScore());
				if (n.averageScore() < ave)
					System.out.println(n.getName() + "的平均分低于全班的平均分");
				else
					System.out.println(n.getName() + "的平均分高于全班的平均分");
			}
		}
	}
}
