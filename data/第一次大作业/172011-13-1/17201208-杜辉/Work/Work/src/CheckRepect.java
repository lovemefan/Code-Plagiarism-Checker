
//�ж��ַ����Ƿ��ظ�����
import java.util.HashMap;
import java.util.Map;

class CheckRepect {
	Map<String, Double> map;

	CheckRepect() {
		map = new HashMap<String, Double>(); // ��������
	}

	public Double getAns(String s) {
		return map.get(s); // �õ�s����ַ�����Ӧ����ֵ
	}

	public void putAns(String s, Double ans) {
		map.put(s, ans);// ��s����ַ�����ans��ֵ��Ӧ����
	}

}
