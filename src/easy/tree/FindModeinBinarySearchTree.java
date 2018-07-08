package easy.tree;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * @author wenhanglei
 */
public class FindModeinBinarySearchTree {
	/*
	 * 思路：
	 * 遍历两遍
	 * 第一遍获得mode的个数，用于创建对应的结果数组
	 * 第二遍保存相应的mode即可
	 */
	private int[] modes;                           //结果变量
	private int modeNum;                           //mode的个数
	private int curCount;                          //当前值的重复次数
	private int maxCount;                          //最大重复次数
	private Integer preValue = null;               //用于和当前值比较的上一个节点的值
	
	public int[] findMode(TreeNode root) {
		//中序遍历二叉排序树获得mode的个数
		inorder(root);       
		//边界检查
		if(modeNum == 0) return new int[0];
		//初始化结果变量
		modes = new int[modeNum];
		//初始化上一个节点的值
		preValue = null;
		//初始化结果数量
		modeNum = 1;
		//中序遍历保存相应的值
		inorder(root);
		//返回结果数组
        return modes;
    }
	
	/**
	 * 中序遍历二叉树
	 */
	private void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		handleValue(root.val);
		inorder(root.right);
	}
	
	/**
	 * 处理当前节点
	 */
	private void handleValue(int value){
		//判断当前节点值是否和上一个节点值重复
		if(preValue == null || value != preValue){
			preValue = value;
			curCount = 0;
		}
		curCount++;
		if(curCount > maxCount){
			maxCount = curCount;
			modeNum = 1;
		}else if(curCount == maxCount){
			if(modes != null)
				modes[modeNum-1] = value;
			modeNum++;
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}

}
