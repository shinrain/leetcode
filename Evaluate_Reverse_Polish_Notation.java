import java.util.*;
import java.lang.*;

// Evaluate_Reverse_Polish_Notation.java

// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


class Solution {
	static int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;

        Stack<Integer> st = new Stack<Integer>();

        for(String s:tokens)
        {
        	if(s.equals("+"))
        	{
        		if(st.isEmpty()) break;
        		int i = st.pop();
        		if(st.isEmpty()) break;
        		int j = st.pop();
        		st.push(i+j);

        	}else if(s.equals("-"))
        	{
        		if(st.isEmpty()) break;
        		int i = st.pop();
        		if(st.isEmpty()) break;
        		int j = st.pop();
        		st.push(j-i);
        	}else if(s.equals("*"))
        	{
        		if(st.isEmpty()) break;
        		int i = st.pop();
        		if(st.isEmpty()) break;
        		int j = st.pop();
        		st.push(i*j);
        	}else if(s.equals("/"))
        	{
        		if(st.isEmpty() || st.peek() == 0) break;
        		int j = st.pop();
        		if(st.isEmpty()) break;
        		int i = st.pop();

        		st.push(i/j);
        	}else
        	{
        		st.push(Integer.parseInt(s));
        	}
        }
        return st.isEmpty()?0:st.peek();
    }

    public static void main(String[] args){
    	String a[] = {"2", "1", "+", "3", "*"};
    	String b[] = {"4", "13", "5", "/", "+"};
    	System.out.println(evalRPN(b));
    }
}