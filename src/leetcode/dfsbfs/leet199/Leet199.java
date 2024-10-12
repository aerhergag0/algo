package leetcode.dfsbfs.leet199;

import java.util.*;

public class Leet199 {
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

	List<Integer> treeDepth = new LinkedList<>();
	Deque<TreeNode> arrayDeque = new ArrayDeque<>();
	List<Integer> answer = new ArrayList<>();

	public List<Integer> rightSideView(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		arrayDeque.offer(root);
		treeDepth.add(1);

		bfs(root, treeDepth, arrayDeque);
		String[] s1 = {"1","2","3","1","2","3","1","2","3","1","2","3"};
		Set<String> set = new HashSet<>(List.of(s1));
		int[] i1 = Arrays.stream(s1).mapToInt(Integer::parseInt).sorted().toArray();

		boolean b = Arrays.asList(s1).contains("1");

		return answer;
	}

	private void bfs(TreeNode treeNode,
	                 List<Integer> treeDepth,
	                 Deque<TreeNode> arrayDeque
	) {
		while (!arrayDeque.isEmpty()) {

		}
	}
}
