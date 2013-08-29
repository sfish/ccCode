/** 
 * @Title: poly.java 
 * @Package  
 * @Description: ∂‡Ã¨
 * @author nutc
 * @date 2013-8-9 …œŒÁ9:24:20 
 * @version V1.0 
 */
public class poly {

	
	public static void main(String args[]){
		father f = new son();
		f.f();
	}
	
}

class father{
	
	public void f(){
		System.out.println("father");
	}
}

class son extends father{
	public void f(){
		System.out.println("son");
	}
}
 

