package handleliste;

import java.util.ArrayList;
import java.util.List;

public class HandlelisteUtil {
	
	public static List<String> handlelisten = new ArrayList<String>();
	
	public static boolean add(String a) {
		return handlelisten.add(a);
	}

	public static boolean remove(String a) {
		return handlelisten.remove(a);
	}

	public static List<String> getAll() {
		return handlelisten;
	}
	
	public static void printAll() {
		System.out.println(handlelisten);
	}
}
