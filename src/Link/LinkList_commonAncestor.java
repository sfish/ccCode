package Link;  
/** 
 * @Title: LinkList_commonAncestor.java 
 * @Package Link 
 * @Description: TODO
 * @author nutc
 * @date 2013-8-14 上午10:26:58 
 * @version V1.0 
 */
public class LinkList_commonAncestor {
	
	
	public static Node find(Node n1,Node n2){
		int len1=0,len2=0;
		Node now1=n1,now2=n2;
		
		while(now1!=null){
			len1++;
			now1= now1.next;
		}
		while(now2!=null){   //重复代码考虑用函数去解决啊！！！
			len2++;
			now2= now2.next;
		}
		now1 = n1; now2 = n2;
		if(len1>len2){
			for(int i=0;i<len1-len2;i++){
				now1 = now1.next;
			}
		}else{
			for(int i=0;i<len2-len1;i++){
				now2 = now2.next;
			}
		}
		while(now1!=now2){
			now1= now1.next;
			now2 = now2.next;
		}
		return now1;
	}

}
 

