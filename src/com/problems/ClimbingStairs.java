package com.problems;

import java.util.ArrayList;
import java.util.List;

public class ClimbingStairs {
    static List<List<Integer>> list = new ArrayList<List<Integer>>();
    
//    public static int climbStairs(int num) {
//	
//    }
    
    public static void climbStairs(int num, List<Integer> listed) {
	int sum = 0;
	for(Integer a: listed) {
	    sum += a;
	}
	
	if(sum == num) {
	    list.add(new ArrayList(listed));
	}else if (sum > num) {
	    return;
	}
	
	listed.add(1);
	climbStairs(num, listed);
	listed.remove(listed.size()-1);
	
	listed.add(2);
	climbStairs(num, listed);
	listed.remove(listed.size()-1);
    }

    public static void main(String[] args) {
	List<Integer> alist = new ArrayList<Integer>();
	climbStairs(3, alist);
	System.out.println(list);	

    }

}
