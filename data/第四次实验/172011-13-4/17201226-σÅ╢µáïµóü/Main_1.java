package Hellowworld;
 
public class Main_1 {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal pet1 = new fish("小丑鱼",4);
		
		Animal pet3 = new fish_2("海豚",0);
		
		Animal park[] = {
				pet1,pet3
		};
		
		int i;
		for(i = 0; i< 3; i++){
			park[i].shout();
		}
		
		//对instanceof的理解
		fish fish = new fish();
		fish_1 fish_1= new fish_1();
		
		System.out.println(fish instanceof fish);
		System.out.println(fish instanceof Animal);
		System.out.println(fish instanceof Terrestrlal);
		System.out.println(fish_1 instanceof Terrestrlal);
//		System.out.println(cat instanceof Dolphin);    //错误
//		System.out.println(dolphin instanceof Cat);    //错误
	}
}