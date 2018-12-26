package medium.tree;

/**
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL. Initially, all next
 * pointers are set to NULL.
 * 
 * @author wenhanglei
 */
public class PopulatingNextRightPointersEachNodeII {
	/*
	 * 思路:使用递归实现即可
	 * 方案二：使用迭代实现逐层遍历
	 */
	public void connect(TreeLinkNode root) {
		
		TreeLinkNode head = null;         //下一层链表的头结点
		TreeLinkNode tail = null;         //下一层链表的当前尾节点
		TreeLinkNode curr = root;         //当前需要处理的节点
		
		while(curr != null){
			
			while(curr != null){
				if(curr.left != null){
					if(head == null){
						head = curr.left;           //初始化下一层节点的头结点
						tail = head;
					}else{
						tail.next = curr.left;
						tail = curr.left;
					}
				}
				
				if(curr.right != null){
					if(head == null){
						head = curr.right;
						tail = head;
					}else{
						tail.next = curr.right;
						tail = curr.right;
					}
				}
				
				curr = curr.next;
			}
			
			curr = head;
			head = null;
			tail = null;
			
		}
		
	}
//	public void connect(TreeLinkNode root) {
//		if(root == null) return;
//		helper(root, null);
//	}
	
	private void helper(TreeLinkNode node, TreeLinkNode head){
		if(node == null) return;
		if(head == null){
			helper(node.left, null);
			helper(node.right, node.left);
		}else{
			TreeLinkNode curr = head, next = null;
			while(curr != null){
				if(next == null){
					if(curr.right != null) next = curr.right;
					if(curr.left != null) next = curr.left;
				}
				if(curr.next == null) break;
				curr = curr.next;
			}
			curr.next = node;
			helper(node.left, next);
			if(next == null) helper(node.right, node.left);
			else helper(node.right, next);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		TreeLinkNode root = TreeUtils.getLinkTree(new int[]{7,-10,2,-4,3,-8,'#','#','#','#',-1,11});
		PopulatingNextRightPointersEachNodeII sol = new PopulatingNextRightPointersEachNodeII();
		sol.connect(root);
		System.out.println(root);
	}
}
