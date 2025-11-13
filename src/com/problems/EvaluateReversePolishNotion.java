package com.problems;


import java.util.Stack;

public class EvaluateReversePolishNotion {
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int sum = 0, a = 0, b = 0;

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
        	b = stk.pop();
        	a = stk.pop();
                sum = notion(a, b, tokens[i]);
                stk.push(sum);
            } else{
                stk.push(Integer.parseInt(tokens[i]));
            }
        } 
        
        if(sum != 0) {
            return sum;
        } else if(stk.isEmpty()) {
            return 0;
        }else {
            return stk.pop();
        }
    }
    
    public static int notion(int a, int b, String sym) {
	switch(sym){
	    case "+" : return a + b;
	    case "-" : return a - b;
	    case "*" : return a * b;
	    default : return a / b;
	}
    }
    
    public static void main(String[] args) {
	String[] arr = {"4","13","5","/","+"};
	System.out.println(evalRPN(arr));
    }

}


//package problems.com;
//
//import java.util.Stack;
//
//public class EvaluateReversePolishNotion {
//    
//    public static int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        
//        for (String token : tokens) {
//            if (isOperator(token)) {
//                int b = stack.pop();
//                int a = stack.pop();
//                stack.push(notion(a, b, token));
//            } else {
//                stack.push(Integer.parseInt(token));
//            }
//        }
//        return stack.pop();
//    }
//    
//    private static boolean isOperator(String token) {
//        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
//    }
//    
//    private static int notion(int a, int b, String sym) {
//        switch (sym) {
//            case "+": return a + b;
//            case "-": return a - b;
//            case "*": return a * b;
//            case "/": return a / b;
//            default: throw new IllegalArgumentException("Invalid operator: " + sym);
//        }
//    }
//    
//    public static void main(String[] args) {
//        String[] arr = {"4", "13", "5", "/", "+"};
//        System.out.println(evalRPN(arr));  // Output: 6
//    }
//}
