package 第一次大作业;
import java.util.Stack;
import java.math.BigDecimal; 
public class Operation {
	String s;
	float ans;
	public Operation(String s) {
		ans=0;
		this.s=s;
	}
	float getans() {
		String[] InPo=new String[100];
		transform a=new transform();
		InPo=a.getRepolish(s);
		Stack<String> OP=new Stack<String>();
		int j=0;
		while(j<InPo.length&&InPo[j]!=null) {
			if(!InPo[j].equals("+")&&!InPo[j].equals("-")&&!InPo[j].equals("*")&&!InPo[j].equals("/")) {
				OP.add(InPo[j]);
				j++;
			}
			else if(InPo[j].equals("+")) {
				BigDecimal w=new BigDecimal(OP.pop());
				BigDecimal m=new BigDecimal(OP.pop());
				w=w.add(m);
				OP.add(w.toString());
				j++;
			}
			else if(InPo[j].equals("-")) {
				BigDecimal m=new BigDecimal(OP.pop());
				BigDecimal w=new BigDecimal(OP.pop());
				w=w.subtract(m);
				OP.add(w.toString());
				j++;
			}
			else if(InPo[j].equals("*")) {
				BigDecimal w=new BigDecimal(OP.pop());
				BigDecimal m=new BigDecimal(OP.pop());
				w=w.multiply(m);
				OP.add(w.toString());
				j++;
			}
			else if(InPo[j].equals("/")) {
				BigDecimal m=new BigDecimal(OP.pop());
				BigDecimal w=new BigDecimal(OP.pop());
				w=w.divide(m);
				OP.add(w.toString());
				j++;
			}
		}
		BigDecimal ans1=new BigDecimal(OP.pop());
		ans=ans1.intValue();
		return ans;
	}
}
	class transform {
		public String[] getRepolish(String s) {
			String[] S=new String[100];
			int i=1;
			int j=0;
			String temp="";
			Stack<String> s1=new Stack<String>();
			BJ bj1=new BJ();
			s1.add("#");
			while(i<s.length()) {
				if(!s.substring(i, i+1).equals("+")&&!s.substring(i, i+1).equals("-")&&!s.substring(i, i+1).equals("*")&&!s.substring(i, i+1).equals("/")&&!s.substring(i, i+1).equals("(")&&!s.substring(i, i+1).equals(")")&&!s.substring(i, i+1).equals("#")) {
					temp=temp+s.substring(i, i+1);
				}
				else if (s.substring(i, i+1).equals("(")){
					if(!temp.equals("")) {
						temp=temp.trim();
						S[j]=temp;
						temp="";
						j++;
					}
					s1.add(s.substring(i, i+1));
				}
				else if(s.substring(i, i+1).equals(")")) {
					String b=" ";
					temp=temp.trim();
					S[j]=temp;
					temp="";
					j++;
					while(!s1.peek().equals("(")) {
						b=s1.pop();
							S[j]=b;
							j++;
					}
					s1.pop();
				}
				else if(s.substring(i, i+1).equals("#")) {
					if(!temp.equals("")) {
						temp=temp.trim();
						S[j]=temp;
						temp="";
						j++;
					}
					while(!s1.peek().equals("#")&&!s1.empty()) {
						S[j]=s1.pop();
						j++;
					}
				}
				else {
					if(s1.peek().equals("(")) {
						if(!temp.equals("")) {
							temp=temp.trim();
							S[j]=temp;
							temp="";
							j++;
						}
						s1.add(s.substring(i, i+1));
					}
					else if(bj1.bjyxj(s.substring(i, i+1), s1.peek())==1) {
						if(!temp.equals("")) {
							temp=temp.trim();
							S[j]=temp;
							temp="";
							j++;
						}
						s1.add(s.substring(i, i+1));
					}
					else {
						if(!temp.equals("")) {
							temp=temp.trim();
							S[j]=temp;
							temp="";
							j++;
						}
						while(bj1.bjyxj(s.substring(i, i+1), s1.peek())!=1) {
							S[j]=s1.pop();
							j++;
						}
						s1.add(s.substring(i, i+1));
					}
				}
				i++;
			}
			/*for(int k=0;k<j;k++) {
				System.out.println(S[k]);
			}
			System.out.println("\n\n\n");
			while(!s1.empty()) {
				System.out.println(s1.pop());
			}*/
			return S;
		}
	}
	class BJ{
		int bjyxj(String a,String b) {
			int c=0;
			int e=0;
			int f=0;
			int[] [] matrix= {
					{1,1,0,0,0,1,1},
					{1,1,0,0,0,1,1},
					{1,1,1,1,0,1,1},
					{1,1,1,1,0,1,1},
			};
			if(a.equals("+"))
				e=0;
			else if(a.equals("-"))
				e=1;
			else if(a.equals("*"))
				e=2;
			else if(a.equals("/"))
				e=3;
			if(b.equals("+"))
				f=0;
			else if(b.equals("-"))
				f=1;
			else if(b.equals("*"))
				f=2;
			else if(b.equals("/"))
				f=3;
			else if(b.equals("("))
				f=4;
			else if(b.equals(")"))
				f=5;
			else if(b.equals("#"))
				f=6;
			c=matrix[e][f];
			return c;
		}
}