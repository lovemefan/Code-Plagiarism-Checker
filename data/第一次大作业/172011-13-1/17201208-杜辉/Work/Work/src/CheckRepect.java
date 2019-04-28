
//判断字符串是否重复输入
import java.util.HashMap;
import java.util.Map;

class CheckRepect {
	Map<String, Double> map;

	CheckRepect() {
		map = new HashMap<String, Double>(); // 构建函数
	}

	public Double getAns(String s) {
		return map.get(s); // 得到s这个字符串对应的数值
	}

	public void putAns(String s, Double ans) {
		map.put(s, ans);// 将s这个字符串与ans数值对应起来
	}

}
