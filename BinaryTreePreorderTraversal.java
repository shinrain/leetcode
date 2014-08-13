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
    static List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> re = new LinkedList<Integer>();

    	if(root == null)     return re;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	st.push(root);

    	while(!st.isEmpty()){
    		TreeNode cur = st.pop();
    		re.add(cur.val);
    		if(cur.right!=null)
    			st.add(cur.right);
    		if(cur.left!=null)
    			st.add(cur.left);
    	}
    	return re;
    }
    public static void main(String[] args){
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	a.right = b;
    	System.out.println(preorderTraversal(a));
    }
}