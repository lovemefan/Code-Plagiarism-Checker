
public class Main {
	//主类
	public static void main(String[] args) {
		// 创建30个学生对象
		Student[] student = new Student[30];
		// 创建一个学生对象
		Student student1;
		student1 = new Student();
		// 创建1个处理对象
		Proceed Deel = new Proceed();
		// 初始化30个学生对象
		Deel.initialize(student);
		//输入新同学的数据
		if (Deel.input(student1) == 1){
			return;
		}
		//输出新同学数据
		Deel.output(student1);
		// 计算新同学的平均成绩和最高分
		Deel.judge(student1,student);
		
	}
}
