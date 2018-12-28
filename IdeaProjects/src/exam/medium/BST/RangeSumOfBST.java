package medium.BST;

/**
 * @author YangShuo
 * @create 2018/12/21
 * @comment
 */

/**
 *
 *  Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

 The binary search tree is guaranteed to have unique values.



 Example 1:

 Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 Output: 32

 Example 2:

 Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 Output: 23

 */
//对二叉搜索树进行递归遍历，判断节点的值是否在值范围，然后求和即可
public class RangeSumOfBST {

    public int result;
    public class BSTNode{
        Integer value;
        BSTNode right;
        BSTNode left;
    }

    public static void main(String[] args){

    }
    public  int rangesum(BSTNode node,int r,int l){
        if(node.value == null){
            return result;
        }
        if(node.value>=l && node.value<=r){
            result+=node.value;
        }
        rangesum(node.right,r,l);
        rangesum(node.left,r,l);
        return result;

    }


}
