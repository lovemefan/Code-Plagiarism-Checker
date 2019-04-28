//����һ��Student��
public class Student {

	private String name; // ����˽������ѧ������name
	private int id; // ����˽������ѧ��ѧ��id
	private int[] scores = new int[4]; // ����˽������ѧ���ɼ�����scores[4]

	// ����ѧ���ɼ�����
	public int[] getScores() {
		return scores;
	}

	// ����ѧ����������
	public String getName() {
		return name;
	}

	// ����ѧ��ѧ�ź���
	public int getID() {
		return id;
	}

	// ��3���βεĹ��캯��
	public Student(String name, int id, int[] scores) {
		this.name = name;
		this.id = id;
		this.scores = scores;
	}

	// ���캯��
	public Student() {
		String names[] = { "Alice", "Bob", "Candy", "David", "Dannis", "Emily", "Frank", "Green", "Haris", "Moana",
				"Bella", "Amy", "Jessie", "Lucy", "Amanda", "Jef", "Abby", "Ariel", "Nala", "Maria",
				"Tiana", "Loren", "Nicole", "Sarah", "Kate", "Wilson", "Carl", "Nancy", "Kevin", "James", "Princess",
				"Rebecca", "Rachel", "Sharon", "Tina", "Paul", "Denny", "Vanessa", "Sugar", "Andrew", "Hebe", "Selina",
				"Ella", "Luna", "Nick", "Peter", "Jason", "Johnny", "Winter", "Tan", "Smile", "Dud", "Edison",
				"Gala" }; // ��������names[]
		name = names[(int) (Math.random() * 54)];
		id = (int) (Math.random() * 100) + 1;
		int i;
		for (i = 0; i < 4; i++)
			scores[i] = (int) (Math.random() * 100) + 1;
	}

	// ������߷ֺ���
	public int maxScore() {
		int i = 0;
		int max = scores[0]; // ��������max������������߷�
		for (i = 1; i < 4; i++) {
			if (scores[i] > scores[0])
				max = scores[i];
		}
		return max;
	}

	// ����ƽ���ֺ���
	public double averageScore() {
		double average = 0; // ��������average,��������ƽ����
		average = (scores[0] + scores[1] + scores[2] + scores[3]) / 4.0;
		return average;
	}

}
