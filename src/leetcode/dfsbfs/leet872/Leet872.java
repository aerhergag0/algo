package leetcode.dfsbfs.leet872;

import java.util.ArrayList;
import java.util.List;

public class Leet872 {

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

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		collectLeaves(list1, root1);
		collectLeaves(list2, root2);

		if (list1.equals(list2)) {
			return true;
		} else {
			return false;
		}
	}

	private void collectLeaves(List<Integer> stack, TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		if (treeNode.left == null && treeNode.right == null) {
			stack.add(treeNode.val);
			return;
		} else {
			collectLeaves(stack, treeNode.left);
			collectLeaves(stack, treeNode.right);
		}
	}
}
