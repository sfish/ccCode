/**
 * @Title: Father.java
 * @Package
 * @Description: TODO
 * @author nutc
 * @date 2013-8-7 ÉÏÎç11:42:01
 * @version V1.0
 */
public class Fathers {
	public static void whichFoo(Base arg1, Base arg2) {
		System.out.print(arg1.getClass() + " " + arg2.getClass() + "\n");
		arg1.foo(arg2);

	}

	public static void main(String[] args) {
		String a = "a",  c = "c";
		String now = a;

		System.out.print(now == a);
		
		Base b = new Base();
		Derived d = new Derived();

		whichFoo(b, b);
		whichFoo(b, d);
		whichFoo(d, b);
		whichFoo(d, d);

//		int a = 5;
//		c(a);
//		System.out.println(a + " ");

		Fathers f = new Fathers();
		in i2;
		Fathers.in i1 = f.new in();
		// Father.in i2 = new in();
	}

	public static void c(int a) {
		a = 10;
	}
	
	public void chage(final Derived d){
		d.v = 9;
//		d = new Derived();
	}

	class in {

	}
}

class Derived extends Base {
	int v;
	public void foo(Base x) {
		System.out.println("Derived.Base");
	}

	public void foo(Derived x) {
		System.out.println("Derived.Derived");
	}
}

class Base {
	public void foo(Base x) {
		System.out.println("Base.Base");
	}

	public void foo(Derived x) {
		System.out.println("Base.Derived");
	}
}
