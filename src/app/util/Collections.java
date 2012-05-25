package app.util;

import java.util.*;

public abstract class Collections {

	public static <T> List<T> List(T... params) {
		List<T> list = new ArrayList<T>();
		for (T e : params) 
			list.add(e);
		return list;
	}
	
	public static List<Integer> Range(int a, int b) {
		List<Integer> result = new ArrayList<Integer>();
		if (a > b)
			for (int i = a; i-- >= b;)
				result.add(i);
		else
			for (int i = a; i++ <= b;)
				result.add(i);
		return result;
	}
	
}
