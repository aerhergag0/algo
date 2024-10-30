package codes.dfsbfs.leet104;

public class Leet104 {
	/**
	 * Definition for a binary tree node.
    **/
	public class TreeNode {
		int      val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val   = val;
			this.left  = left;
			this.right = right;
		}
	}

	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return dfsDepth(root);
	}

	public int dfsDepth(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}

		int leftDepth = dfsDepth(treeNode.left);
		int rightDepth = dfsDepth(treeNode.right);

		return Math.max(leftDepth, rightDepth) + 1;
	}

}
