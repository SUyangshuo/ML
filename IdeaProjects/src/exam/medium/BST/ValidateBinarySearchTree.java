package medium.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangShuo
 * @create 2019/2/15
 * @comment
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class ValidateBinarySearchTree {
    /**
     * 判断一课树是否是平衡二叉树，经过一次遍历，查看是否按照顺序排列
     **/

    public List<Integer> list=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {

        //对这棵树进行中序遍历 左中右
        if(root == null){
            return false;
        }
        if(root.left != null){
            isValidBST(root.left);
        }
        list.add(root.val);

        if(root.right != null){
            isValidBST(root.right);
        }
        return true;
    }

    /**
     *简便算法 --把最大值和最小值放进比较
     */
    public boolean isValidBST(TreeNode root,long min,long max) {
        if(root ==null){
            return true;
        }
        if(root.val<min || root.val>max){
            return false;
        }
        
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}

