package tests;

import java.util.HashMap;
import java.util.Scanner;

public class FindOccurance {
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		String name=s.nextLine();
		System.out.println(name);
	String name2 =s.next();
	System.out.println(name2);
	HashMap<Character, Integer> map=new HashMap<>();
	for(int i=0;i<name.length();i++) {
		if(!map.containsKey(name.charAt(i))) {
			map.put(name.charAt(i), 1);
		}
		else {
			map.put(name.charAt(i), map.get(name.charAt(i))+1);
		}
		
	}
	System.out.println(map);

}
}
