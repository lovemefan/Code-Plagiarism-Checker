package Calculator;

public enum OperatorsEnum {
	PLUS(0, '+'), 
	MINUS(0, '-'), 
	MULTIPLY(1, '*'),
	DIVIDE(1, '/'), 
	MODULAR(1, '%'),
	LEFT_BRACKET(2,'('),
	RIGHT_BRACKET(2, ')');
    public Integer prior;// 优先级
    public Character operator;// 操作符

    private OperatorsEnum(int prior, char operator) {
        this.prior = prior;
        this.operator = operator;
    }

    public String toString() {
        return String.valueOf(operator);
    }
}
