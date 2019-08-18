package core;

import java.util.ArrayList;
import java.util.List;

public class changeCOLLECTIONONITERATION {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		for(Integer i : list) {
			if(i==2) {
				list = new ArrayList<Integer>();
				break;
			}
		}
		System.out.println(list);
		
	}
}
