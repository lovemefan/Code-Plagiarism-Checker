import java.util.Scanner;

//����һ��Studentmessage��
public class Studentmessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 0;
		Student[] stu = new Student[30]; // ����һ��Student�������stu[30]
		for (i = 0; i < 30; i++) // ����30��ѧ����Ϣ
			stu[i] = new Student();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Student n; // ����һ��Student��ı���n,nָ����ѧ��
		System.out.println("��������ѧ��������:");
		String newName; // ����һ���ַ�������newName������������ѧ������
		newName = input.nextLine(); // ������ѧ������
		System.out.println("��������ѧ����ѧ��:");
		int id; // ����һ�����ͱ���id
		id = input.nextInt(); // ������ѧ��ѧ��
		System.out.println("��������ѧ���ĳɼ�:");
		int[] a = new int[4]; // ����һ������a[4]������������ѧ��4���ɼ�
		for (i = 0; i < 4; i++) { // ������ѧ����4���ɼ�
			a[i] = input.nextInt();
		}
		n = new Student(newName, id, a); // ���ô�3�������Ĺ��캯�������ѧ����Ϣ
		System.out.println("��ѧ��������" + n.getName());
		System.out.println("��ѧ��ѧ�ţ�" + n.getID());
		System.out.print("��ѧ�����ſεĳɼ����Կո�ָ���");
		for (i = 0; i < 4; i++)
			System.out.print(a[i] + " ");
		System.out.println(" ");
		System.out.println("��ѧ��ƽ���֣�" + n.averageScore() + "��߷֣�" + n.maxScore());

		if (a[0] > 100 || a[1] > 100 || a[2] > 100 || a[3] > 100)
			System.out.println("�γ̳ɼ����ܸ���100��!!");
		else if (a[0] == 100 && a[1] == 100 && a[2] == 100 && a[3] == 100)
			System.out.println(n.getName() + "�����ǰ��ϳɼ���õ�ѧ����");

		// �õ�ȫ���ƽ����
		double sum = 0;
		double ave = 0; // �������ave����������ȫ���ƽ����
		for (i = 0; i < 30; i++) {
			sum = sum + stu[i].averageScore();
		}
		ave = sum / 30;
		// �õ�30��ѧ���е����ƽ����
		double max = stu[0].averageScore(); // ����һ�������ͱ���max�������������ƽ����
		for (i = 1; i < 30; i++) {
			if (max < stu[i].averageScore())
				max = stu[i].averageScore();
		}
		for (i = 0; i < 30; i++) {
			if (stu[i].averageScore() == max) {
				System.out.println(stu[i].getName() + "��ƽ�������: " + max + " ��߷�:" + stu[i].maxScore());
				if (n.averageScore() < ave)
					System.out.println(n.getName() + "��ƽ���ֵ���ȫ���ƽ����");
				else
					System.out.println(n.getName() + "��ƽ���ָ���ȫ���ƽ����");
			}
		}
	}
}
