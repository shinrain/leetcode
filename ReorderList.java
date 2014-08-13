import java.util.*;
import java.lang.*;


// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.



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

	static ListNode reverse(ListNode nd){
		if(nd == null || nd.next == null)  return nd;

		ListNode cur = nd;
		nd = nd.next;
		cur.next = null;

		while(nd!=null){
			ListNode n = nd.next;
			nd.next = cur;
			cur = nd;
			nd = n;
		}
		return cur;
	}

	static ListNode merge(ListNode a, ListNode b){
		if(a==null) return b;
		if(b==null) return a;

		ListNode head = a, tail = a;
		a = a.next;
		while(b!=null && a!= null)
		{
			tail.next = b;
			tail = b;
			b=b.next;
			tail.next=null;

			tail.next = a;
			tail = a;
			a=a.next;
			tail.next=null;
		}
		if(a==null) tail.next = b;
		if(b==null) tail.next = a;
		return head;
	}

    static void reorderList(ListNode head) {
    	if(head == null || head.next == null) return;

    	ListNode N1 = head;
    	ListNode N2 = head;

    	int count = 0;
    	while(N1!=null){
    		count++;
    		N1=N1.next;
    		if(count%2==0){
    			N2=N2.next;
    		}
    	}
    	ListNode new_node = N2.next;
    	N2.next = null;

    	head = merge(head,reverse(new_node));

    }


public static void main(String[] args){

	ListNode a = new ListNode(1);
	ListNode b = new ListNode(2);
	ListNode c = new ListNode(3);
	a.next = b;
	b.next = c;
	reorderList(a);
	System.out.println(a);

}




}