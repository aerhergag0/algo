package codes.dfsbfs.leet437;

import java.util.HashMap;
import java.util.Map;

public class Leet437 {

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

	int answer = 0;
	Map<Long, Integer> prefixSum;

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) return 0;

		prefixSum = new HashMap<>();
		prefixSum.put(0L,1);

		dfs(root, 0, targetSum);

		return answer;
	}

	private void dfs(TreeNode treeNode, long currentSum, int targetNum) {
		if (treeNode == null) return;

		currentSum += treeNode.val;

		answer += prefixSum.getOrDefault(currentSum - targetNum, 0);
		prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

		dfs(treeNode.left, currentSum, targetNum);
		dfs(treeNode.right, currentSum, targetNum);

		prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);
	}
}
