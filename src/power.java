/**
 * @Title: power.java
 * @Package
 * @Description: TODO
 * @author nutc
 * @date 2013-8-12 ÏÂÎç8:16:55
 * @version V1.0
 */
public class power {
	
	public static void main(String args[]){
		System.out.println(Power(0,0)+" ");
		System.out.println(Power(2,3)+" ");
		System.out.println(Power(-2.0,7)+" ");
		System.out.println(Power(-2.3,-7)+" ");

	}

	static double Power(double base, int exponent) {
		if (equal(base, 0.0)) return 0;
//			throw new Exception("error input");
		if (exponent == 0)
			return 0;
		if (exponent == 1)
			return base;
		boolean negative = false;
		if (exponent < 0) {
			negative = true;
			exponent = -exponent;
		}
		double result = ex(base,exponent) ;
		if (negative)
			result = 1 / result;
		return result;
	}

	static boolean equal(double d1, double d2) {
		if (d1 - d2 < 0.0000001 && d1 - d2 > -0.0000001) {
			return true;
		} else
			return false;
	}
	
	public static double ex(double base,int e){
		if(e==0 )return 1;
		if(e==1)return base;
		double result =  ex(base,e>>1);
		result *= result;
		if((e & 1)==1) result *=base;
		return result;
	}
}
