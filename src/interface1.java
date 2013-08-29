import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
 
//证明在接口中的域隐式地是static和final的

interface T12 {
    int ONE = 1, TWO = 2;
}
 
public class interface1 {
    public static void main(String[] args)  {
    	
    	//http://bbs.csdn.net/topics/330082243
        try{
               Class obj = T12.class;
               Field field = obj.getField("ONE");
               int mod=field.getModifiers();
               System.out.println("属性修饰符＝"+Modifier.toString(mod));
        }catch(Exception e){
             
        }
    }
 
}