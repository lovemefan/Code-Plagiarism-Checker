package calculator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class Calculator {
	private Expression expression;
	private Transformer transformer;
	private Validator validator;

	private PrintWriter printWriter;

	public Calculator() {
		transformer = new Transformer();
		validator = new Validator();
	}

	public Calculator(String outFile) throws FileNotFoundException {
		transformer = new Transformer();
		validator = new Validator();
		printWriter = new PrintWriter(new FileOutputStream(outFile), true);
	}

	public void input(String str) {
		expression = new Expression(str);
	}

	public void cal() {
		boolean valid = validator.validate(expression.getContent());
		if (valid) {
			double result = f(transformer.transform(expression.getContent()));
			printToScreen(valid, expression, result);
			printToFile(valid, expression, result);
		} else {
			printToScreen(valid, expression, 0);
			printToFile(valid, expression, 0);
		}
	}

	public void printToScreen(boolean valid, Expression expression, double result) {
		if (valid) {
			System.out.println(expression + "=" + result);
		} else {
			System.out.print("ERROR!");
			System.out.println("#" + expression);
		}
	}

	public void printToFile(boolean valid, Expression expression, double result) {
		if (printWriter == null||printWriter.checkError()) {
			return;
		}
		if (valid) {
			printWriter.println(expression + "=" + result);
		} else {
			printWriter.print("ERROR!");
			printWriter.println("#" + expression);
		}
	}

	public void setPrintWriter(String outFile) throws FileNotFoundException {
		printWriter = new PrintWriter(new FileOutputStream(outFile), true);
	}

	public void closePrintWriter() {
		if (printWriter != null) {
			printWriter.close();
		}
	}

	@SuppressWarnings("rawtypes")
	private double f(List list) {
		Stack<Double> result = new Stack<Double>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String m = it.next().toString();
			if (m.equals("+") || m.equals("-") || m.equals("*") || m.equals("/")) {
				double b = result.pop();

				double a = result.pop();
				double v = stepCal(a, b, m);
				result.push(v);
			} else {
				result.push(Double.valueOf(m));
			}
		}
		return (result.pop());
	}

	private double stepCal(double a, double b, String m) {

		double v = 0;
		switch (m) {
		case "+":
			v = a + b;
			break;
		case "-":
			v = a - b;
			break;
		case "*":
			v = a * b;
			break;
		case "/":
			v = a / b;
			break;
		}
		return v;

	}

}
