package TestStudent;

class Student {
	private String Name = "abc";// ͬѧ������
	private String ID = "172011";// ͬѧ��ѧ��
	int[] Grade;// ͬѧ�ķ�������

	public Student() {// ������������ķ���

	}

	public String getName() {// �������һ��Ӣ������
		String newName = "abc";
		String[] temp = new String[3];
		String Name = "abcdefghijklmnopqrstuvwxyz";

		for (int n = 0; n < 3; n++) {
			temp[n] = "" + Name.charAt((int) (Math.random() * 26));
		}
		newName = "" + temp[0] + temp[1] + temp[2];
		return newName;
	}

	public Student(String newName, String newID,int[] newGrade) {// ȡ�ø�ͬѧ������
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

	public int getAverange() {// ȡ�ø�ͬѧƽ���ֵķ���
		int add = 0, averange = 0;
		for (int i = 0; i < 4; i++) {
			add += Grade[i];
		}
		averange = add / 4;
		return averange;
	}

	public int getHighest() {// ȡ�ø�ͬѧ����߷�
		int highest = Grade[0];
		for (int i = 0; i < 4; i++) {
			if (Grade[i] > highest) {
				highest = Grade[i];
			}
		}
		return highest;
	}

}
