package work;

public class Student { //ѧ������
	String studentID;
	String studentName;
	int []scores;
	public String getID(){//�ַ�ѧ��ID
		return studentID;
	}
	public String getName(){//�ַ�ѧ������
		return studentName;
	}
	public Student(String studentName,String studentID,int []scores){
		this.studentName = studentName;
		this.studentID = studentID;
		this.scores = scores;
	}
	public int max(){//���ֵ
		int max = scores[0];
		for(int x = 1;x < scores.length;x++){
			if (scores[x] > max){
				max = scores[x];//�Ƚ�ȡ�����ֵ
			}
		}
		return max;//����ֵ
	}
	public double averageScore(){//ƽ����
		double average = 0;//��ʼ��
		double sum = 0;
		for(int y = 0;y < scores.length;y++){
			sum = sum + scores[y];
		}
		 average = sum/4;//���ƽ��ֵ
		 return average;//����ֵ
	}

}
