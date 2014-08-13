import java.util.*;
import java.lang.*;



//Definition for binary tree
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1].


class Solution {
    static List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> re = new LinkedList<Integer>();

    	if(root == null)     return re;

    	Stack<TreeNode> st = new Stack<TreeNode>();

    	st.push(root);
    	TreeNode prev = null, cur = null;

    	while(!st.isEmpty()){
    		cur = st.peek();
    		System.out.println(cur.val);
    		if(prev ==null || prev.left == cur || prev.right == cur){
    			if(cur.left !=null)
    				st.push(cur.left);
    			else if(cur.right != null)
    				st.push(cur.right);
    			prev = cur;
    		}else{
    			cur = st.peek();
    			if(prev==cur.left && cur.right!=null)
    				st.push(cur.right);
    			else{
    				re.add(cur.val);
    				st.pop();
    			}
    			prev = cur;
    		}
    	}
    	return re;
    }
    public static void main(String[] args){
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	a.right = b;
    	System.out.println(postorderTraversal(a));
    }
}