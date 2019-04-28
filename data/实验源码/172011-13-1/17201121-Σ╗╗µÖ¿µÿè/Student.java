package TestStudent;

class Student {
	private String Name = "abc";// 同学的名字
	private String ID = "172011";// 同学的学号
	int[] Grade;// 同学的分数数组

	public Student() {// 构造调用这个类的方法

	}

	public String getName() {// 随机生成一个英文名字
		String newName = "abc";
		String[] temp = new String[3];
		String Name = "abcdefghijklmnopqrstuvwxyz";

		for (int n = 0; n < 3; n++) {
			temp[n] = "" + Name.charAt((int) (Math.random() * 26));
		}
		newName = "" + temp[0] + temp[1] + temp[2];
		return newName;
	}

	public Student(String newName, String newID,int[] newGrade) {// 取得该同学的属性
		Name = newName;
		ID = newID;
		Grade = newGrade;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getname() {
		return Name;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}

	public int getAverange() {// 取得该同学平均分的方法
		int add = 0, averange = 0;
		for (int i = 0; i < 4; i++) {
			add += Grade[i];
		}
		averange = add / 4;
		return averange;
	}

	public int getHighest() {// 取得该同学的最高分
		int highest = Grade[0];
		for (int i = 0; i < 4; i++) {
			if (Grade[i] > highest) {
				highest = Grade[i];
			}
		}
		return highest;
	}

}
