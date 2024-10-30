package codes.dfsbfs.leet1448;

public class Leet1448 {
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

	public int goodNodes(TreeNode root) {
		dfs(root, root.val);
		return answer;
	}

	private void dfs(TreeNode treeNode, int maxSoFar) {
		if (treeNode == null) {
			return;
		}

		if (treeNode.val >= maxSoFar) {
			answer++;
		}

		maxSoFar = Math.max(maxSoFar, treeNode.val);

		dfs(treeNode.left, maxSoFar);
		dfs(treeNode.right, maxSoFar);
	}
}
