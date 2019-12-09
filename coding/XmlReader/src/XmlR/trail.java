package XmlR;

import java.util.Scanner;

public class trail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String m = "Hello123";
		@SuppressWarnings("resource")
		Scanner in = new Scanner(m).useDelimiter("[^0-9]+");
		int integer = in.nextInt();
		if(integer == 123){
		System.out.println(integer);}

	}

}
