
//ѧ���࣬��������ѧ����Ϣ
public class Student {
	private String studentID;//ѧ����ѧ������
	private String studentName;//ѧ������������
	private int[] score = new int[4];//ѧ�����ĸ���Ŀ�ķ���������
//ѧ������޲ι��췽��
	Student() {
	}	
//��������studentID�ķ���
	String setID() {
		return this.studentID;
	}
//ѧ����ķ���������������studentID��ֵ
	public void setID(String studentID) {
		this.studentID = studentID;
	}
//��������studentName�ķ���
	String setName() {
		return this.studentName;
	}
//ѧ����ķ���������������studentName��ֵ
	public void setName(String studentName) {
		this.studentName = studentName;
	}
//������������score�ķ���
	int[] setScore() {
		return score;
	}
//ѧ����ķ���������������score��ֵ
	public void setScore(int[] score) {
		this.score = score;
	}
//����getID(),�����õ�ѧ�������ѧ��
	public String getID() {
		studentID = "172011" + (int) (10 + Math.random() * 30);
		return studentID;
	}
//����getName(),�����õ�ѧ�����������
	public String getName() {
		char a = (char) ('a' + Math.random() * ('z' - 'a' + 1));
		char b = (char) ('a' + Math.random() * ('z' - 'a' + 1));
		char c = (char) ('a' + Math.random() * ('z' - 'a' + 1));
		char d = (char) ('a' + Math.random() * ('z' - 'a' + 1));
		studentName = "" + a + b + c + d;
		return studentName;
	}
//���Է����������������ѧ����ÿ�η���
	/*void outPutScore(){
		for(int i = 0;i < 4;i ++) {
			System.out.printf("%3d\t",score[i]);
		}
		System.out.println();
	}*/
//����getScore(),��������õ�ѧ���ĸ���Ŀ�ĳɼ�
	public int[] getScore() {
		for (int i = 0; i < 4;i ++) {
			score[i] = (int) (Math.random() * 101);
		}
		return score;
	}
//����max(),�ó�ѧ���ĸ���Ŀ����ߵķ���
	public int max() {
		int highestScore = score[0];
		for (int i = 1; i < score.length;i ++) {
			if (highestScore < score[i]) {
				highestScore = score[i];
			}
		}
		return highestScore;
	}
//����averageScore(),�õ�ѧ���ĸ���Ŀ��ƽ������
	public double averageScore() {
		return (score[0] + score[1] + score[2] + score[3]) / 4.0;
	}
}

