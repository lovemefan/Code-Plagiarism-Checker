package greatproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	String s;
	Pattern p;
	Matcher m;

	public Check(String s) {
		this.s = s;
	}

	public String judge() {
		// �жϿ��ַ���
		if (s.equals("")) {
			return "���ַ���";
		}
		// ����Ƿ��пո�,һ��Ҫ���ڿ�ͷ��Ҫ��Ȼ�����ѿո񵱳�λ���ַ�
		p = Pattern.compile("\\s+");
		m = p.matcher(s);
		if (m.find()) {
			return "�ո�";
		}

		// �жϵ�һ���ַ��Ƿ�Ϊ���ֻ���������
		p = Pattern.compile("[\\d\\(]");// ƥ�俪ͷ���߽�βʱ��d���治��+
		m = p.matcher(s);
		if (m.lookingAt() == false) {
			if (s.matches("\\-\\d+.*") == false) {
				return "�ԷǷ��ַ���ͷ";
			}
		}
		// �ж����һ���ַ��Ƿ�Ϊ���ֻ���������
		p = Pattern.compile("[\\d\\)]$");// $��ʾ�н�β ^��ʾ�п�ͷ
		m = p.matcher(s);
		if (m.find() == false) {
			return "�ԷǷ��ַ���β";
		}
		// ���ַ��������صķ���
		if (!this.chara().equals("�޴���")) {
			return this.chara();
		}

		// ���ж�������صķ���
		if (!this.paren().equals("�޴���")) {
			return this.paren();
		}

		// �ж�(�����������
		p = Pattern.compile("\\([\\+\\*\\/]");
		m = p.matcher(s);
		if (m.find()) {
			return "(�����������";
		}
		// �жϸ��Ÿ�ʽ����
		p = Pattern.compile("\\(\\-\\d++(?!\\))");// \\d+���ܴ���������,??
		// Ϊʲô��Ҫд�����Ӻţ�����������
		m = p.matcher(s);
		if (m.find()) {
			return "���Ÿ�ʽ����";
		}
		return "�޴���";
	}

	private String paren() {
		// �жϿ�����
		p = Pattern.compile("\\(\\)");
		m = p.matcher(s);
		if (m.find()) {
			return "������";
		}
		// �ж�(ǰ�治Ϊ�����,)ǰ���������,)���治��Ϊ����
		p = Pattern.compile("\\d\\(");
		m = p.matcher(s);
		if (m.find()) {
			return "'('ǰ�治�������";
		}
		p = Pattern.compile("[\\+\\-\\*\\/]\\)");
		m = p.matcher(s);
		if (m.find()) {
			return "')'ǰ���������";
		}
		p = Pattern.compile("\\)\\d");
		m = p.matcher(s);
		if (m.find()) {
			return "')'���治��Ϊ����";
		}

		// ����ƥ��
		p = Pattern.compile("\\(");
		m = p.matcher(s);
		int l = 0;
		while (m.find()) {
			l++;
		}
		p = Pattern.compile("\\)");
		m = p.matcher(s);
		int r = 0;
		while (m.find()) {
			r++;
		}
		if (l != r) {
			return "���Ų�ƥ��";
		}
		return "�޴���";
	}

	private String chara() {
		// ƥ���Ƿ���������ַ�
		p = Pattern.compile("[^\\+\\-\\*\\/\\(\\)\\d]");// [^abc]
														// ����a��b��c������ַ���ƥ��
		m = p.matcher(s);
		if (m.find()) {
			return "���������ַ�";
		}
		// �ж������Ƿ���д��ȷ
		p = Pattern.compile("\\d{2,}");
		m = p.matcher(s);
		while (m.find()) {
			if (m.group().matches("0.*")) {
				return "���ָ�ʽ��д����";
			}
		}
		// �ж����������
		p = Pattern.compile("[\\+\\-\\*\\/]{2,}");
		m = p.matcher(s);
		if (m.find()) {
			return "���������";
		}
		// �жϷ�ĸ����Ϊ0
		p = Pattern.compile("\\/0");
		m = p.matcher(s);
		if (m.find()) {
			return "��ĸ����Ϊ0";
		}

		return "�޴���";
	}

}
