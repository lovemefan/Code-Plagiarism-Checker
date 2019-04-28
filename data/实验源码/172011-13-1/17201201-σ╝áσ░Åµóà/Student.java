//声明一个Student类
public class Student {

	private String name; // 声明私有属性学生姓名name
	private int id; // 声明私有属性学生学号id
	private int[] scores = new int[4]; // 声明私有属性学生成绩数组scores[4]

	// 返回学生成绩函数
	public int[] getScores() {
		return scores;
	}

	// 返回学生姓名函数
	public String getName() {
		return name;
	}

	// 返回学生学号函数
	public int getID() {
		return id;
	}

	// 带3个形参的构造函数
	public Student(String name, int id, int[] scores) {
		this.name = name;
		this.id = id;
		this.scores = scores;
	}

	// 构造函数
	public Student() {
		String names[] = { "Alice", "Bob", "Candy", "David", "Dannis", "Emily", "Frank", "Green", "Haris", "Moana",
				"Bella", "Amy", "Jessie", "Lucy", "Amanda", "Jef", "Abby", "Ariel", "Nala", "Maria",
				"Tiana", "Loren", "Nicole", "Sarah", "Kate", "Wilson", "Carl", "Nancy", "Kevin", "James", "Princess",
				"Rebecca", "Rachel", "Sharon", "Tina", "Paul", "Denny", "Vanessa", "Sugar", "Andrew", "Hebe", "Selina",
				"Ella", "Luna", "Nick", "Peter", "Jason", "Johnny", "Winter", "Tan", "Smile", "Dud", "Edison",
				"Gala" }; // 定义数组names[]
		name = names[(int) (Math.random() * 54)];
		id = (int) (Math.random() * 100) + 1;
		int i;
		for (i = 0; i < 4; i++)
			scores[i] = (int) (Math.random() * 100) + 1;
	}

	// 返回最高分函数
	public int maxScore() {
		int i = 0;
		int max = scores[0]; // 声明变量max，用来保存最高分
		for (i = 1; i < 4; i++) {
			if (scores[i] > scores[0])
				max = scores[i];
		}
		return max;
	}

	// 返回平均分函数
	public double averageScore() {
		double average = 0; // 声明变量average,用来保存平均分
		average = (scores[0] + scores[1] + scores[2] + scores[3]) / 4.0;
		return average;
	}

}
