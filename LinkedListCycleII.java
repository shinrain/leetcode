
import java.util.*;
import java.lang.*;


// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Follow up:
// Can you solve it without using extra space?




// Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

      public String toString(){
      	ListNode n = next;
      	String str = val+", ";
      	while(n!=null)
      	{
      		str+=(n.val+", ");
      		n=n.next;
      	}
      	return str;
      }
  }


   class Solution {
    static  ListNode detectCycle(ListNode head) {
        if(head==null) return null;

        ListNode n1 = head, n2 = head;
        int count = 0;
        while(N1!=null){
        	N1 = N1.next;
        	count++;
        	if(count%2==0){
        		N2=N2.next;
        		if(N1==N2)
        			break;
        	}
        }
        if(N1==null) return null;

        N2 = head;
        while(N1!=N2){
        	N1 = N1.next;
        	N2 = N2.next;
        }
        return N1;
    }
}


