//学生类
class Student {
	static int p = 0;
	int studentID = 17201300;// 学生学号
	String studentName = "";// 学生姓名
	int[] scores = new int[4];// 学生成绩

//获得学生学号
	public int getID() {
		return studentID;
	}

//获得学生的姓名
	public String getName() {
		return studentName;
	}

//学生类的构造方法
	public Student() {
		p++;
		studentID += p;
		for (int j = 0; j < (int) (3 + Math.random() * 6); j++) {
			studentName += (char) ('a' + Math.random() * ('z' - 'a' + 1));
		}
		for (int i = 0; i < 4; i++) {
			scores[i] = (int) (Math.random() * 101);
		}
	}

//获得学生成绩的最高分
	public double max() {
		int max = 0;
		for (int i = 0; i < 4; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		return max;
	}

//获得学生成绩的平均值
	public double averageScore() {
		double total = 0;
		for (int i = 0; i < 4; i++) {
			total += scores[i];
		}
		return total / 4;
	}
}