
import java.util.Scanner;
//������
public class ANewStudent {
	public static void main(String[] args) {
		
		Student[] studentInformation = new Student[31];
		initializeObject(studentInformation);
		getInformation(studentInformation);
		Scanner input = new Scanner(System.in);
		System.out.println("������ѧ������ : ");
		studentInformation[30].setName(input.nextLine());
		System.out.println("������ѧ��ѧ�� : ");
		studentInformation[30].setID(input.nextLine());
		System.out.println("���������ſεĳɼ����Կո�ָ� : ");
		int[] transfer = new int[4];
		for(int i = 0;i < 4;i ++) {
			transfer[i] = input.nextInt();
			if(transfer[i] > 100) {
				System.out.println("�γ̳ɼ����ܸ���100�֣���");
				return;
			}
		}
		studentInformation[30].setScore(transfer);
		System.out.println(studentInformation[30].setName() + "(ID: " + studentInformation[30].setID() + ") ƽ���� "
				+ studentInformation[30].averageScore() + " ��߷� " + studentInformation[30].max());
		bestStudent(studentInformation);
		averageOrLow(studentInformation);
		/*for(int i = 0;i < studentInformation.length;i ++) {
			System.out.print(studentInformation[i].setName() + " " + studentInformation[i].setID() + " ");
			studentInformation[i].outPutScore();������䣬ʹ��Student���е�outPutScore����
		}
		*/
	}
	public static void initializeObject(Student[] studentInformation) {
		for (int i = 0; i < studentInformation.length;i ++) {
			studentInformation[i] = new Student();
		}
	}
	
	public static void getInformation(Student[] studentInformation) {
		for (int i = 0; i < 30;i ++) {
			studentInformation[i].getID();
			studentInformation[i].getName();
			studentInformation[i].getScore();
		}
	}

	public static void bestStudent(Student[] studentInformation) {
		int sign = 0;
		double highestScore = studentInformation[0].max();
		for (int i = 1; i < studentInformation.length;i ++) {
			if (highestScore < studentInformation[i].averageScore()) {
				highestScore = studentInformation[i].averageScore();
				sign = i;
			}
		}
		if (sign == 30) {
			System.out.println(studentInformation[sign].setName() + "�����ǰ��ϳɼ���õ�ѧ����");
		} else {
			System.out.println(studentInformation[sign].setName() + "(ID: " + studentInformation[sign].setID()
					+ ") �����ƽ���� " + studentInformation[sign].averageScore() + " ��߷� " + studentInformation[sign].max());
		}
	}
	public static void averageOrLow(Student[] studentInformation) {
		int classAverage = 0;
		int sum = 0;
		for (int i = 0; i < studentInformation.length;i ++) {
			sum += studentInformation[i].averageScore();
		}
		classAverage = sum / studentInformation.length;
		if (studentInformation[30].averageScore() < classAverage) {
			System.out.println(studentInformation[30].setName() + "��ƽ���ɼ�����ȫ���ƽ����");
		} else if (studentInformation[30].averageScore() > classAverage) {
			System.out.println(studentInformation[30].setName() + "��ƽ���ɼ�����ȫ���ƽ����");
		} else {
			System.out.println(studentInformation[30].setName() + "��ƽ���ɼ��պõ���ȫ���ƽ����");
		}
	}
}
