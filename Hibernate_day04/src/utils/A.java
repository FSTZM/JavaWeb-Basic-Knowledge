package utils;

public class A{
	
	private static int i = 1;
	static{
		i = 2;
	}
	public static int next(){
		return i++;
	}
	
	public static void main(String[] ards){
		A a = new A();
		A b = new A();
		A.next();
		System.out.println("111");
		a.next();
		System.out.println("222");
		b.next();
		System.out.println(a.next());
		
	}
}
