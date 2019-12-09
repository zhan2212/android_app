package practice;
import java.util.ArrayList;

public class ptrArray {
	static ArrayList<Integer> ary = new ArrayList<Integer>();
	public static void main(String[] args){
		
		for(int i=0;i<10;i++){
			ary.add(i);
		}
		
		for(int m:ary){
			System.out.println(m);
		}
		
	}
}