import java.util.*;
import java.lang.*;

// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the


class Solution {
	static void reverse(char[] s, int l, int r){
		if(s==null || l>=r) return;

		while(l<r){
			char t = s[l];
			s[l] = s[r];
			s[r] = t;
			l++;
			r--;
		}
	}

	static String reverseWords(String s) {
        if(s==null || s=="") return s;

        char[] ss = s.toCharArray();
        reverse(ss, 0, ss.length-1);

        int cur = 0;
        int l=0, r=0;
        s =  new String(ss);
        while(l<ss.length)
        {
        	while(l<ss.length && ss[l]==' ') l++;
        	if(l==ss.length) break;

        	r = l;
        	while(r<ss.length && ss[r]!=' ') r++;

        	reverse(ss,l,r-1);

        	if(cur<l){
	        	for(int i=l; i<r; i++)
	        	{
	        		ss[cur++] = ss[i];
	        	}
	        }else{
	        	cur = r;
	        }
        	l=r;
	        if(cur<ss.length){
	        	ss[cur++] = ' ';
	        }
        }
        if(cur == 0) return "";
        if(ss[cur-1]==' ') cur--;
        return new String(ss).substring(0,cur);
    }

    public static void main(String[] args){
    	String s = "a";
    	System.out.println("\""+reverseWords(s)+"\"");
    }

}