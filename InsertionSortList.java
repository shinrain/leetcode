import java.util.*;
import java.lang.*;

// InsertionSortList.java

// Sort a linked list using insertion sort


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }

 class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null) return head;

    	ListNode H = head;
    	head = H.next;
    	H.next  = null;
    	

    	while(head!=null)
    	{
    		ListNode prev  = null, cur = H;
    		while(cur!=null && cur.val <= head.val)
    		{
    			prev = cur;
    			cur = cur.next;
    		}
    		if(cur == null)
    		{
    			prev.next = head;
    			head = head.next;
    			prev.next.next = null;
    		}
    		else
    		{
    			if(prev!=null)
    			{
	    			prev.next = head;
	    			head = head.next;
	    			prev.next.next = cur;
	    		}
	    		else{
	    			ListNode new_head = head.next;
	    			head.next = H;
	    			H = head;
	    			prev = H;
	    			head = new_head;
	    		}
    		}
    	}
    	return H;
	}

	public static void main(String[] args){}

}
