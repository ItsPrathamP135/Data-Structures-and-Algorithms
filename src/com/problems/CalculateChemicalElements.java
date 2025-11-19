package com.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CalculateChemicalElements {

    public static String getValues(String str) {
	ArrayList<String> queue = new ArrayList<String>();
	Stack<Integer> prt = new Stack<Integer>();
	String strs = "";
	int len = str.length() - 1;

	while (len >= 0) {
	    if (Character.isLowerCase(str.charAt(len))) {
		strs += str.charAt(len - 1) + "" + str.charAt(len);
		queue.add(strs);
		strs = "";
		len--;
		len--;
	    } else if (Character.isUpperCase(str.charAt(len))) {
		strs += "" + str.charAt(len);
		queue.add(strs);
		strs = "";
		len--;
	    } else if (Character.isDigit(str.charAt(len))) {
		int val = str.charAt(len) - '0';
		int num = 10;
		while (len > 0 && Character.isDigit(str.charAt(len - 1))) {
		    val = ((str.charAt(len - 1)) - '0') * num + val;
		    num = num * 10;
		    len--;
		}
		strs += String.valueOf(val);
		queue.add(strs);
		strs = "";
		len--;
	    } else {
		strs += str.charAt(len);
		queue.add(strs);
		strs = "";
		len--;
	    }
	}

	String[] arr = queue.toArray(new String[0]);
	int num = 1;
	boolean isNumber = false;
	HashMap<String, Integer> map = new HashMap<>();

	for (int i = 0; i < arr.length; i++) {
	    if (arr[i].equals(")") && i > 0) {
		isNumber = isNumber(arr[i - 1]);
		if (isNumber) {
		    prt.push(Integer.parseInt(arr[i - 1]));
		}
	    } else if (arr[i].equals("(") && !prt.isEmpty()) {
		prt.pop();
	    } else if (!arr[i].equals("(") && !arr[i].equals(")")) {
		if (i > 0 && isNumber(arr[i - 1]) && !isNumber(arr[i])) {
		    num = Integer.parseInt(arr[i - 1]) * inStack(prt);
		    if (map.containsKey(arr[i])) {
			num = map.get(arr[i]) + num;
			map.put(arr[i], num);
		    } else {
			map.put(arr[i], num);
		    }
		    num = 1;
		} else if (i > 0 && !isNumber(arr[i - 1]) && !isNumber(arr[i])) {
		    num = num * inStack(prt);

		    if (map.containsKey(arr[i])) {
			num = map.get(arr[i]) + num;
			map.put(arr[i], num);
		    } else {
			map.put(arr[i], num);
		    }
		    num = 1;
		} else if (!isNumber(arr[i]) && i == 0) {
		    if (map.containsKey(arr[i])) {
			num = map.get(arr[i]) + num;
			map.put(arr[i], num);
		    } else {
			map.put(arr[i], num);
		    }
		    num = 1;
		}
	    }
	}

	for (Map.Entry m : map.entrySet()) {
	    String val = "";
	    if ((Integer) m.getValue() > 1) {
		val = String.valueOf(m.getValue());
	    }

	    strs += m.getKey() + "" + val;
	}

	return strs.toString();

    }

    public static int inStack(Stack<Integer> stk) {
	Integer[] arr = stk.toArray(new Integer[0]);
	int a = 1, i = 0;
	while (i < arr.length) {
	    a = a * arr[i];
	    i++;
	}
	return a;
    }

    public static boolean isNumber(String str) {
	for (int i = 0; i < str.length(); i++) {
	    if (!Character.isDigit(str.charAt(i))) {
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	System.out.println(getValues("Ca(SO)4"));
	System.out.println(getValues("MgSO4"));
    }

}
