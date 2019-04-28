package assignment_one;

import java.util.Scanner;


public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StackOfChar stack = new StackOfChar();
		System.out.println("Please input a String£º");
		String s = input.nextLine();
		for(int i = 0;i < s.length(); i++){
			char c = s.charAt(i);	
			stack.push(c);
		}
		while(!stack.isEmpty()){
			char c = stack.pop();
			System.out.print(c + " ");
		}
		input.close();
	}
	
}
class StackOfChar{
	
	private char[] elements;
	private int size ;
	public static final int DEFAULT_CAPACITY = 20;
	
	public StackOfChar(){
		this(DEFAULT_CAPACITY);
	}
	
	public StackOfChar(int capacity){
		elements = new char[capacity];
	}
	
	public void push(char value){
		if(size >= elements.length){
			char[] temp = new char [elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements [ size++ ] = value;
	}
	
	public char pop(){
		return elements[--size];
	}
	
	public char peek(){
		return elements[size - 1];
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int getSize(){
		return size;
	}
}