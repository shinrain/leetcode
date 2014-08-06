import java.util.*;
import java.lang.*;

// Sort_List.java
// Sort a linked list in O(n log n) time using constant space complexity.


// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 

class Solution {


	static ListNode merge(ListNode a, ListNode b){

		// Cannot use recursive solution. Because cost is high on leetcode server

		ListNode n1 = a, n2 = b;

		ListNode head = null, prev = null;

		while(n1!=null && n2!=null)
		{
			if(n1.val <= n2.val)
			{
				if(head == null)
				{
					head = n1;
					prev = n1;
					n1 = n1.next;
					prev.next = null;

				}else{
					prev.next = n1;
					n1 = n1.next;
					prev = prev.next;
					prev.next = null;
				}
			}else{
				if(head == null)
				{
					head = n2;
					prev = n2;
					n2 = n2.next;
					prev.next = null;

				}else{
					prev.next = n2;
					n2 = n2.next;
					prev = prev.next;
					prev.next = null;
				}
			}
		}
		if(n1!=null) prev .next = n1;
		if(n2!=null) prev.next = n2;
		return head;
	}

	static ListNode sortList(ListNode head){
		if(head == null ||head.next == null) return head;

		int ct = 0;
		ListNode n1 = head, n2 = head;

		while(n2.next!=null){
			ct++;
			n2 = n2.next;
			if(ct%2 == 0){
				n1 = n1.next;
			}
		}
		n2 = n1.next;
		n1.next = null;
		return merge( sortList(head), sortList(n2) );

	}

	public static void main(String[] args){}

}